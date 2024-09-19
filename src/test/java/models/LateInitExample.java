package models;

public class LateInitExample {

    private String value;
    private static String name;
    private static String city = "Moscow";
    private Integer manCount;
    private Integer womanCount;

    static  {
        name = "test";
    }

    public LateInitExample() {
        value = "some value";
    }

    public int getPeopleCount() {
        return manCount + womanCount;
    }




}
