package kodlama.io.RentACar;

import kodlama.io.RentACar.Core.Utilities.Exceptions.BusinessException;
import kodlama.io.RentACar.Core.Utilities.Exceptions.ProblemDetails;
import kodlama.io.RentACar.Core.Utilities.Exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice
public class RentACarApplication {

	public static void main(String[] args) {

		SpringApplication.run(RentACarApplication.class, args);

		// swagger'da gormek icin
		// http://localhost:8081/swagger-ui/index.html
	}

	// Hata oldugunda kullaniciya verilen ciktilarda sistemle ilgili bilgiler yerine bizim olusturdugumuz mesajlari gostersin
	@ExceptionHandler  // hata olusursa burdan gececek
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException){  // eger BusinessException hatasi olursa calisacak
		ProblemDetails problemDetails=new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());

		return problemDetails;
	}

	@ExceptionHandler  // hata olusursa burdan gececek
	@ResponseStatus(code= HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){  // eger MethodArgumentNotValidException hatasi olursa calisacak
		ValidationProblemDetails validationProblemDetails=new ValidationProblemDetails();
		validationProblemDetails.setMessage("VALIDATION.EXCEPTION");

		validationProblemDetails.setValidationErrors(new HashMap<String,String>());

		// birden fazla hata mesaji(mesaj ve validationErrors mesaji) oldugu icin foreach yapisiyla yazdiralim
		for(FieldError fieldError: methodArgumentNotValidException.getBindingResult().getFieldErrors()){
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		return validationProblemDetails;
	}

	@Bean  // bunu gordugu anda ihtiyac duyulursa diye IoC'ye okutarak ekler
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

}
