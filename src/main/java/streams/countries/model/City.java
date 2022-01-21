package streams.countries.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class City {
    private final int id;
    private final String name;
    @Setter
    private int population;
    private final String countryCode;

    public String getContinent() {
        return null;
    }
}
