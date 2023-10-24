package kodlama.io.RentACar.Core.Utilities.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDetails {
    String message;   // hata bilgisi - sistemle ilgili bilgileri hata mesajinda gostermemek icin

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
