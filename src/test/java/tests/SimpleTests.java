package tests;

import models.Cat;
import models.LateInitExample;
import models.People;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public class SimpleTests {

    private String timeNow;

    @BeforeEach
    public void before() {
        timeNow = "LocalTime " + LocalDateTime.now();
    }

    @Test
    public void TwoLessThanThreeTest() {
        System.out.println(timeNow);
        int a = 5;
        int b = 3;
        Assertions.assertTrue(a < b, "Число " + a + " больше чем число " + b);
    }

    @Test
    @DisplayName("Результат сложения 2 + 3 = 5")
    @Disabled("Тест не критичный исправим через месяц. JIRA-564")
    public void sumTest() {
        System.out.println(timeNow);
        int a = 3;
        int b = 2;
        int sum = a + b;
        Assertions.assertEquals(5, sum);
    }

    @ParameterizedTest
    @CsvSource({"Sasha,18,female", "Misha,16,male", "Vera,23,female"})
    public void letterAInNameTest (String name, String age, String gender) {
        System.out.println(name + " " + age + " " + gender);
        Assertions.assertTrue(name.contains("a"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/people.csv", delimiter = ',')
    public void letterAInNameUseCsvFileTest (String name, String age, String gender) {
        System.out.println(name + " " + age + " " + gender);
        Assertions.assertTrue(name.contains("a"));
    }

    private static Stream<Arguments> testPeople() {
        return Stream.of(
                Arguments.of(new People("Sasha",18, "female")),
                Arguments.of(new People("Misha",16, "male")),
                Arguments.of(new People("Vera",23, "female"))
                );
    }

    @ParameterizedTest
    @MethodSource("testPeople")
    public void letterAInNameUseConstructorTest(People people) {
        System.out.println(people.getName() + " " + people.getAge() + " " + people.getGender());
        Assertions.assertTrue(people.getName().contains("a"));
    }

    @Test
    public void printCatCheckLombokTest() {
        Cat cat = new Cat("Pushok", "Egypt");
        System.out.println(cat);
    }

    @Test
    public void countTest() {
        LateInitExample initExample = new LateInitExample();
        System.out.println(initExample.getPeopleCount());
    }

    @AfterEach
    public void after() {
        System.out.println("Test is finished");
    }

}
