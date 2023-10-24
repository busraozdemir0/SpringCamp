package kodlama.io.RentACar.Business.Rules;

import kodlama.io.RentACar.Core.Utilities.Exceptions.BusinessException;
import kodlama.io.RentACar.DataAccess.Abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

// is kurallari
@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){   // marka ismi tekrar ediyor mu?
        if(this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand name already exists!");  // Java exception types
        }
    }
}
