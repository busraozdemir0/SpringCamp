package kodlama.io.RentACar.WebAPI.Controllers;

import jakarta.validation.Valid;
import kodlama.io.RentACar.Business.Abstracts.ModelService;
import kodlama.io.RentACar.Business.Requests.CreateBrandRequest;
import kodlama.io.RentACar.Business.Requests.CreateModelRequest;
import kodlama.io.RentACar.Business.Responses.GetAllBrandsResponse;
import kodlama.io.RentACar.Business.Responses.GetAllModelsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;
    @GetMapping("/getall")
    public List<GetAllModelsResponse> getAll(){

        return modelService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody() @Valid() CreateModelRequest createModelRequest){

        this.modelService.add(createModelRequest);
    }
}
