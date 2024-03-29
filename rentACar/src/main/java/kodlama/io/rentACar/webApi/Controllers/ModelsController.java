package kodlama.io.rentACar.webApi.Controllers;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import kodlama.io.rentACar.business.DTO.requests.CreateModelRequest;
import kodlama.io.rentACar.business.DTO.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.abstracts.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {

    private ModelService modelService;

    @GetMapping()
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }
}
