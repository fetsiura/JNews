package pl.jnews.core.city;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer temperature;
    private Integer feelsLike;
    private Integer pressure;
    private Integer wind;
    private String cloud;
    private String sunrise;
    private String sunset;
    private String airCondition;
    private String link;

    private LocalTime updated;

}