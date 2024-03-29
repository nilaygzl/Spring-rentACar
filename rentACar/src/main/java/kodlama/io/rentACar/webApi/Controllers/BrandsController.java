package kodlama.io.rentACar.webApi.Controllers;


import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.DTO.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.DTO.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.DTO.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.DTO.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {

    private BrandService brandService;

    //@Autowired
   // public BrandsController(BrandService brandService) { //brandService sorun var bean oluşmadı diyor
    //    this.brandService = brandService;
   // }

    @GetMapping()
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateBrandRequest createBrandRequest){ //Burada yeni sürüm kullandığım için @RequestBody eklemesem de olur.
        this.brandService.add(createBrandRequest);
    }

    @PutMapping()
    public void update(@RequestBody() UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }
}
