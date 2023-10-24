package kodlama.io.RentACar.Core.Utilities.Mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor  // bu anotasyon sayesinde manuel constructor yazmamiza gerek kalmaz
public class ModelMapperManager implements ModelMapperService {
    private ModelMapper modelMapper;

   /* public ModelMapperManager(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }*/

    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)  // belirsizlik olursa gormezden gel
                .setMatchingStrategy(MatchingStrategies.LOOSE);  // mapleyebildiklerini mapler mapleyemedikleri icin kizmaz

        return this.modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD); // mapleyemedikleri icin kizsin

        return this.modelMapper;
    }
}
