package kodlama.io.rentACar.business.abstracts;


import kodlama.io.rentACar.business.DTO.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.DTO.requests.CreateModelRequest;
import kodlama.io.rentACar.business.DTO.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();

    void add(CreateModelRequest createModelRequest);
}
