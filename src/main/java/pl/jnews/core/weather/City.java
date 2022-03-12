package pl.jnews.core.weather;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String country;
    private String latitude;
    private String longitude;
    private String clouds;
    private Short temperatura;
    private Short feelsLike;
    private Short pressure;
    private Short humidity;
    private Double windSpeed;
}
