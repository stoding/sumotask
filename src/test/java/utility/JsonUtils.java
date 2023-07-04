package utility;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import utility.data.FilePath;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;

public class JsonUtils<T> {

    public static Object jsonReader(String jsonFileName, Type classType) {
        Gson gson = new Gson();
        try {
            return gson.fromJson(new JsonReader(new FileReader(String.format(FilePath.PATH_TO_RESOURCES_PACKAGE+"%s", jsonFileName))), classType);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found");
        }
    }

//    public <T> T jsonReader(String jsonFileName){
//        Gson gson = new Gson();
//        try {
//            Class<T> type = T;
//            return gson.fromJson(new JsonReader(new FileReader(String.format(pathToResourcesPackage,jsonFileName))), type);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException("File with user info not found");
//        }
//    }
//    private static class JsonOutputType<T> {
//        final Class<T> typeParameterClass;
//
//        public JsonOutputType(Class<T> typeParameterClass) {
//            this.typeParameterClass = typeParameterClass;
//        }
//
//        public void bar() {
//            // you can access the typeParameterClass here and do whatever you like
//        }
//    }
}
