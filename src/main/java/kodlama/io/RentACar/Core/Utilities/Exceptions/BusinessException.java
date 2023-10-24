package kodlama.io.RentACar.Core.Utilities.Exceptions;

public class BusinessException extends RuntimeException{  // calisma zamani hatasi
    public BusinessException(String message){
        super(message);  // super() => base sinif demek
    }
}
