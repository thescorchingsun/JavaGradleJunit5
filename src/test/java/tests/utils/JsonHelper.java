package tests.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;


public class JsonHelper {

    private static final ObjectMapper mapper = new ObjectMapper();

    //Методы для взаимодействия с json

    //Чтение из файла
    //Преобразует json обьекты из resourses в объект java class
    @SneakyThrows
    public static <T> T fromJsonFile(String jsonPatch, Class<T> out) {
            return mapper.readValue(new File(jsonPatch), out);
        }
    //Чтение файла из json
    @SneakyThrows
    public static <T> T fromJsonString(String json, Class<T> out) {
        return mapper.readValue(json, out);
    }

    /* Код с исключениями без аннотации @SneakyThrows
    public static <T> T fromJsonFile(String jsonPatch, Class<T> out) {
        try {
            return mapper.readValue(new File(jsonPatch), out);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
   */

    @SneakyThrows
    public static String toJson(Object object) {
        return mapper.writeValueAsString(object);
    }

    /* Код с исключениями без аннотации @SneakyThrows
    public static String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    */



}