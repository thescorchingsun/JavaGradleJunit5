package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Cat;
import models.People;
import org.junit.jupiter.api.Test;
import tests.utils.JsonHelper;

import java.io.File;
import java.io.IOException;

public class JacksonTests {

    @Test //Создание одного случая
    public void oneJsonNameTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/test/resources/sasha.json");
        People people = objectMapper.readValue(file, People.class); //json преобразуется в объект
        System.out.println(people.getName());
        System.out.println(people.getAge());
        System.out.println(people.getGender());

        People nikita = new People("Nikita", 13, "male");
        String json = objectMapper.writeValueAsString(nikita); //Преобразование в строчку
        System.out.println(json);
    }

    @Test //Удобно для работы с большим кол-вом данных
    public void aLotOfJsonsTest() throws IOException {

        Cat cat = JsonHelper.fromJsonFile("src/test/resources/cat.json", Cat.class);
        People people = JsonHelper.fromJsonFile("src/test/resources/sasha.json", People.class);

        System.out.println(JsonHelper.toJson(cat));
        System.out.println(JsonHelper.toJson(people));


    }







}

