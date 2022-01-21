package streams.countries.model;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@RequiredArgsConstructor
public class Country {
    private final String code;
    private final String name;
    private final String continent;
    @Setter
    private double surfaceArea;
    @Setter
    private int population;
    @Setter
    private int capital;

    private final Set<City> cities = new HashSet<>();

    public void addCity(City city) {
        cities.add(city);
    }

}
