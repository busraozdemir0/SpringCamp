package kodlama.io.RentACar.Business.Requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {
    @NotNull  // validasyon islemleri
    @NotBlank
    @Size(min=3, max=30)
    private String name;
    @NotNull
    @NotBlank
    private int brandId;
}
