package kodlama.io.RentACar.WebAPI.Controllers;

import jakarta.validation.Valid;
import kodlama.io.RentACar.Business.Abstracts.BrandService;
import kodlama.io.RentACar.Business.Requests.CreateBrandRequest;
import kodlama.io.RentACar.Business.Requests.UpdateBrandRequest;
import kodlama.io.RentACar.Business.Responses.GetAllBrandsResponse;
import kodlama.io.RentACar.Business.Responses.GetByIdBrandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController    // annotation
@RequestMapping("/api/brands")  // tarayicidaki adreslemede gorulen sey
public class BrandsController {
    private BrandService brandService;

    @Autowired   // BrandService'i kim implemente ediyor diye bakacak
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    // markalari listeleme islemi
    @GetMapping("/getall")   // www.kodlama.io/api/brands/getall
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")  // id path'den gelecek
    public GetByIdBrandResponse getById(@PathVariable int id) // id'yi path'den alsin
    {
        return brandService.getById(id);
    }

    // marka ekleme islemi
    @PostMapping("/add")
    @ResponseStatus(code=HttpStatus.CREATED)  // 201 kodunu dondurmek icin - 201 islem basarili ve veri olustu demek
    public void add(@RequestBody() @Valid() CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }


    @PutMapping("/update")
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){  // degisken Body'den gelecek
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }
}
