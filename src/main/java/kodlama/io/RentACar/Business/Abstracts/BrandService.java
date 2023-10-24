package kodlama.io.RentACar.Business.Abstracts;

import kodlama.io.RentACar.Business.Requests.CreateBrandRequest;
import kodlama.io.RentACar.Business.Requests.UpdateBrandRequest;
import kodlama.io.RentACar.Business.Responses.GetAllBrandsResponse;
import kodlama.io.RentACar.Business.Responses.GetByIdBrandResponse;

import java.util.List;

// is kurallarini yazacagimiz yapiyi kodlayalim
public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
