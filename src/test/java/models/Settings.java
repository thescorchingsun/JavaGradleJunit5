package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Settings {

    private String url;
    @JsonProperty("is_production") //переменная из project.properties
    private Boolean isProduction;
    private Integer threads;

}
