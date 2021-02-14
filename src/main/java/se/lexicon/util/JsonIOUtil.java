package se.lexicon.util;



import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import se.lexicon.modelCarRegister.Car;
import se.lexicon.modelCarRegister.Owner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class JsonIOUtil {

    private ObjectMapper objectMapper;



    public JsonIOUtil() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.registerModule(new JavaTimeModule());
    }



    public void serializeCarListToJson(List<Car> cars, File file) {

        try {
            if (!file.exists()){
                file.createNewFile();
            }
            objectMapper.writeValue(file, cars);
            System.out.println("Operation is Done.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void serializeOwnerListToJson(List<Owner> owner, File file) {

        try {
            if (!file.exists()){
                file.createNewFile();
            }
            objectMapper.writeValue(file, owner);
            System.out.println("Operation is Done.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public List<Car> deserializeJsonListToCar(File file) {
        List<Car> result= new ArrayList<>();

        try{
            result = objectMapper.readValue(file, new TypeReference<List<Car>>() {});
        } catch (JsonParseException | JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }



    public List<Owner> deserializeJsonListToOwner(File file) {
        List<Owner> result= new ArrayList<>();

        try{
            result = objectMapper.readValue(file, new TypeReference<List<Owner>>() {});
        } catch (JsonParseException | JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }



}
