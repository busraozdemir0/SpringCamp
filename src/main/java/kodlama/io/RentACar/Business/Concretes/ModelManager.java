package kodlama.io.RentACar.Business.Concretes;

import kodlama.io.RentACar.Business.Abstracts.ModelService;
import kodlama.io.RentACar.Business.Requests.CreateModelRequest;
import kodlama.io.RentACar.Business.Responses.GetAllBrandsResponse;
import kodlama.io.RentACar.Business.Responses.GetAllModelsResponse;
import kodlama.io.RentACar.Core.Utilities.Mappers.ModelMapperService;
import kodlama.io.RentACar.DataAccess.Abstracts.ModelRepository;
import kodlama.io.RentACar.Entities.Concretes.Brand;
import kodlama.io.RentACar.Entities.Concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository; // Constructor yazmamiza gerek yok cunku AllArgsConstructor yazdigimiz icin lombok otomatik olusturur
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models=modelRepository.findAll(); // findAll metodu JpaRepository bize hazir olarak getirdi

        List<GetAllModelsResponse> modelsResponse= models.stream().map(model -> this.modelMapperService.forResponse().map(model,GetAllModelsResponse.class)).collect(Collectors.toList());  // her bir brand icin cevirecek ve collect ile toplayarak toList yapacak - stream api'nin map'i

        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model= this.modelMapperService.forRequest().map(createModelRequest,Model.class);
        this.modelRepository.save(model);
    }
}
