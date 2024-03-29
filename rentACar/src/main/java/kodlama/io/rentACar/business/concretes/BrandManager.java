package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.Entities.Brand;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.DTO.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.DTO.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.DTO.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.DTO.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //yani bu sınıf bir Bussiness nesnesidir.
//@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    //mapper kullanmak için
    private ModelMapperService modelMapperService; //AllArgsConstructor kullanıdğım için enjekte oldu. constructor oluşturmamam ve @Autowired eklememe gerek kalmadı

    private BrandBusinessRules brandBusinessRules;

    @Autowired
    public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService, BrandBusinessRules brandBusinessRules) {
        this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
        this.brandBusinessRules = brandBusinessRules;
    }

    @Override
    public List<GetAllBrandsResponse> getAll() { //Servisimizin getAll'ı Repository'nin findAll'ını çağırıyor
        //iş kuralları
        List<Brand> brands = brandRepository.findAll();

        //1.Kullanım şekli
       // List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();

       // for (Brand brand : brands){
        //    GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
         //   responseItem.setId(brand.getId());
         //   responseItem.setName(brand.getName());

          //  brandsResponse.add(responseItem);
      //  }

        List<GetAllBrandsResponse> brandsResponse = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
                 // elimizde bir liste varsa onu tek tek dolaşmayı sağlıyor

        return brandsResponse;
// Brand i GetAllBrandsResponse'ye çevirmem gerekiyor. Bunun için;
// Boş bir liste oluşturuyorum, ana listeyi dolaşıyorum, her seferinde her markanın id-sini ve name-ini set ediyorum.
// Sonrasında boş listeme ekliyorum ve return ediyorum
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();

        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());// iş kuralı

       // //1.Kullanım şekli
       // Brand brand = new Brand();
       // brand.setName(createBrandRequest.getName());
       // this.brandRepository.save(brand);

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
