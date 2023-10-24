package kodlama.io.RentACar.Business.Abstracts;

import kodlama.io.RentACar.Business.Requests.CreateBrandRequest;
import kodlama.io.RentACar.Business.Requests.CreateModelRequest;
import kodlama.io.RentACar.Business.Requests.UpdateBrandRequest;
import kodlama.io.RentACar.Business.Responses.GetAllBrandsResponse;
import kodlama.io.RentACar.Business.Responses.GetAllModelsResponse;
import kodlama.io.RentACar.Business.Responses.GetByIdBrandResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);


   /* GetByIdBrandResponse getById(int id);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);*/
}
