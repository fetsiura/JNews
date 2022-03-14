package pl.jnews.core.weather;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String country;
    private String clouds;
    private Short temperature;
    private Short feelsLike;
    private Short pressure;
    private Short humidity;
    private Double windSpeed;
}
