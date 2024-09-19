package tests;

import lombok.SneakyThrows;
import models.Settings;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import tests.utils.AppConfig;
import tests.utils.JsonHelper;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReaderTests {

    //1 способ для прочтения файла с настройками без сторонних библиотек
    @Test
    @SneakyThrows
    public void simpleReaderTest() {
        Properties properties = new Properties();
        FileInputStream fs = new FileInputStream("src/test/resources/project.properties");
        properties.load(fs);

        String url = properties.getProperty("url");
        boolean isProduction = Boolean.parseBoolean(properties.getProperty("is_production")); //Полученную строчку преобразовать в тип boolean
        int threads = Integer.parseInt(properties.getProperty("threads")); //Полученную строчку преобразовать в тип int

        System.out.println(url);
        System.out.println(isProduction);
        System.out.println(threads);
    }

    //2 способ для прочтения файла с настройками с помощью библиотеки jackson
    @Test
    @SneakyThrows
    public void jacksonReaderTest() {
        Properties properties = new Properties();
        FileInputStream fs = new FileInputStream("src/test/resources/project.properties");
        properties.load(fs);

        String json = JsonHelper.toJson(properties);
        System.out.println(json);

        Settings settings = JsonHelper.fromJsonString(json, Settings.class);
        System.out.println(settings.getUrl());
        System.out.println(settings.getIsProduction());
        System.out.println(settings.getThreads());
    }

    //3 способ для прочтения файла с библиотекой owner
    @Test
    public void ownerReaderTest() {
        AppConfig appConfig = ConfigFactory.create(AppConfig.class);
        System.out.println(appConfig.threads());
        System.out.println(appConfig.isProd());
        System.out.println(appConfig.url());


    }




}
