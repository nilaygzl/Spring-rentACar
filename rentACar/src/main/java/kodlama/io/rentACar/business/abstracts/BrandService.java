package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.DTO.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.DTO.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.DTO.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.DTO.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    //iş kurallarını yazıyorum
    List<GetAllBrandsResponse> getAll();

    GetByIdBrandResponse getById(int id);

    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
