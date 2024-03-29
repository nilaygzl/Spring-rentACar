package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.Entities.Brand;
import kodlama.io.rentACar.Entities.Model;
import kodlama.io.rentACar.business.DTO.requests.CreateModelRequest;
import kodlama.io.rentACar.business.DTO.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.DTO.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();

        List<GetAllModelsResponse> modelsResponse = models.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());

        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);
        this.modelRepository.save(model);

    }
}
