package models;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data//@Data сразу объединяет @ToString, @Getter, @Setter, @EqualsAndHashCode

public class Cat {

    private String name;
    private String model;

/* @Getter @Setter заменяют конструкции ниже
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    @AllArgsConstructor из плагина lombok заменяет эту конструкцию
    public Cat(String name, String model) {
        this.name = name;
        this.model = model;
    }

    //Пустой конструктор для создания обьектов
    @NoArgsConstructor из плагина lombok заменяет эту конструкцию
    public Cat() {
    }

    @ToString из плагина lombok заменяет этот конструктор
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
 */

}
