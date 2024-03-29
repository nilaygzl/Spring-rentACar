package kodlama.io.rentACar.core.utilities.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Service;

@Service //her seferinde yeni bir ModelMapper üretilmesini istemiyorum bunun IOC'ye yerleşmesi için
@AllArgsConstructor //ModelMapper enjeksiyonu için
public class ModelMapperServiceImpl implements ModelMapperService{

    private ModelMapper modelMapper;
    @Override
    public ModelMapper forResponse() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
        //stratejimizi belirleriz.
        //stratejiye göre o stratejiyi set edip modelMapper dönüyoruz.
    }

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
        return this.modelMapper;
    }
}
