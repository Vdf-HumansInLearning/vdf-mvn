package streams.countries.model;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;

public class World {

    @Getter
    private final Set<Country> countries = new HashSet<>();

    public void addCountry(Country country) {
        countries.add(country);
    }

}
