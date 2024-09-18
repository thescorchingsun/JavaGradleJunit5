package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.People;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class JacksonTests {

    @Test
    public void test() throws IOException {
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
}

