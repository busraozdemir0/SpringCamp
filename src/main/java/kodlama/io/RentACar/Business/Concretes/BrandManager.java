package kodlama.io.RentACar.Business.Concretes;

import kodlama.io.RentACar.Business.Abstracts.BrandService;
import kodlama.io.RentACar.Business.Requests.CreateBrandRequest;
import kodlama.io.RentACar.Business.Requests.UpdateBrandRequest;
import kodlama.io.RentACar.Business.Responses.GetAllBrandsResponse;
import kodlama.io.RentACar.Business.Responses.GetByIdBrandResponse;
import kodlama.io.RentACar.Business.Rules.BrandBusinessRules;
import kodlama.io.RentACar.Core.Utilities.Mappers.ModelMapperService;
import kodlama.io.RentACar.DataAccess.Abstracts.BrandRepository;
import kodlama.io.RentACar.Entities.Concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service  // otomatik new'leyecek - IoC (bu sinifin bir business nesnesi oldugunu soyledik)
public class BrandManager implements BrandService {

    // Dependency Injection
   private BrandRepository brandRepository;
   private ModelMapperService modelMapperService;
   private BrandBusinessRules brandBusinessRules;

    @Autowired  // Autowired yazmasak da olur
    public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService, BrandBusinessRules brandBusinessRules) {
        this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
        this.brandBusinessRules=brandBusinessRules;
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands=brandRepository.findAll(); // findAll metodu JpaRepository bize hazir olarak getirdi

        // maplemeden önceki hali
        /*List<GetAllBrandsResponse> brandsResponse=new ArrayList<GetAllBrandsResponse>();
        for(Brand brand: brands){
            GetAllBrandsResponse responseItem=new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandsResponse.add(responseItem);
        }*/

        List<GetAllBrandsResponse> brandsResponse= brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());  // her bir brand icin cevirecek ve collect ile toplayarak toList yapacak - stream api'nin map'i

        return brandsResponse;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand=this.brandRepository.findById(id).orElseThrow();  // orElseThrow => belirtilen id yoksa hata firlatsin

        GetByIdBrandResponse response=this.modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);

        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {

        // is kurali-eklenen brand name vt'de var mi?
        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand= this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);  // createBrandRequest kaynagini Brand classina cevir
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand= this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);  // createBrandRequest kaynagini Brand classina cevir
        this.brandRepository.save(brand); // buradaki save, update islemi gerceklestirir
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
