package innova4b.empresaReparto.util;

import innova4b.empresaReparto.exceptions.JsonUtilException;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JsonUtil {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public void setObjectMapper(ObjectMapper objectMapper){
		this.objectMapper = objectMapper;
	}
	
	public Object fromJsonToList(String json, TypeReference typeReference) throws JsonUtilException {
		try {
			return objectMapper.readValue(json, typeReference);
		} catch (JsonParseException e) {
			throw new JsonUtilException("Parse: " + e.getMessage());
		} catch (JsonMappingException e) {
			throw new JsonUtilException("Mapping: " + e.getMessage());
		} catch (IOException e) {
			throw new JsonUtilException("IO: " + e.getMessage());
		}
	}
	


}
