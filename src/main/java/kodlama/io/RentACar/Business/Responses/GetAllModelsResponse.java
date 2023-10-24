package kodlama.io.RentACar.Business.Responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelsResponse {
    private int id;
    private String name;
    // brandName diye alan olamasa da brand nesnesi icindeki name ifadesine bakar
    private String brandName; // modelleri listelerken brandId yerine brandName getirelim(join ile)
}
