package uz.maniac4j.gatewayserver.uti;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MapperUtils {


    ObjectMapper mapper = new ObjectMapper();;

    public  <T> T objectMapper(Object object,Class<T> contentClassType){
        return mapper.convertValue(object, contentClassType);
    }
}
