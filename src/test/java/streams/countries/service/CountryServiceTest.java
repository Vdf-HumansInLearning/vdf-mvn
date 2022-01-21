package streams.countries.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import streams.countries.model.City;
import streams.countries.model.Country;
import streams.countries.model.World;

class CountryServiceTest {

    public static final String RO = "Ro";
    public static final String NL = "Nl";
    public static final String EUROPE = "Europe";
    private World world;
    private CountryService countryService = new CountryService();
    City city = new City(1, "Bucharest", RO);
    City ams = new City(1, "Amsterdam", NL);

    @BeforeEach
    public void setup() {
        world = new World();
        Country ro = new Country(RO, "Romania", EUROPE);
        city.setPopulation(1900000);
        ro.addCity(city);
        City iasi = new City(2, "Iasi", RO);
        city.setPopulation(350000);
        ro.addCity(iasi);
        world.addCountry(ro);
        Country nl = new Country(NL, "Netherlands", EUROPE);
        ams.setPopulation(1000000);
        nl.addCity(ams);
        City haag = new City(2, "Den Haag", NL);
        haag.setPopulation(450000);
        nl.addCity(haag);
        world.addCountry(nl);
//        City ny = new City(1, "New York", "US");
//        ny.setPopulation(10000000);
//        Country us = new Country("US", "United States", "North America");
//        us.getCities().add(ny);
//        world.addCountry(us);
    }

    @Test
    void findMostPopulatedCitiesInTheWorld() {
        List<City> cities = countryService.findMostPopulatedCitiesInTheWorld(world);

        assertEquals(2, cities.size());
        assertTrue(cities.contains(city));
        assertTrue(cities.contains(ams));
    }

    @Test
    void findMostPopulatedCitiesInTheWorldImperative() {
        List<City> cities = countryService.findMostPopulatedCitiesInTheWorldImperative(world);

        assertEquals(2, cities.size());
        assertTrue(cities.contains(city));
        assertTrue(cities.contains(ams));
    }
}