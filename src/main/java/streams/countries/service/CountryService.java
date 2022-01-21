package streams.countries.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import streams.countries.model.City;
import streams.countries.model.Country;
import streams.countries.model.World;

public class CountryService {

    public List<City> findMostPopulatedCitiesInTheWorld(World world) {
        return world.getCountries()
            .stream()
            .map(getCountryOptionalFunction())
            .filter(Optional::isPresent)
            .map(Optional::get)
            .peek(System.out::println)
            .collect(Collectors.toList());
    }

    private Function<Country, Optional<City>> getCountryOptionalFunction() {
        return country -> country.getCities().stream().max(Comparator.comparing(City::getPopulation));
    }

    public List<City> findMostPopulatedCitiesInTheWorldImperative(World world) {
        List<City> cities = new ArrayList<>();
        for(Country country: world.getCountries()) {
            City city = getMostPopulatedCity(country);
            if(city != null) {
                cities.add(city);
            }
        }
        return cities;
    }

    private City getMostPopulatedCity(Country country) {
        if(country.getCities().isEmpty()) {
            return null;
        }
        City result = country.getCities().iterator().next();
        for(City city: country.getCities()) {
            if(city.getPopulation() > result.getPopulation()) {
                result = city;
            }
        }
        System.out.println(result);
        return result;
    }

//    public List<City> findMostPopulatedCitiesPerContinentInTheWorld(World world) {
//        Collector<City, ?, Map<String, Optional<City>>> collector = Collectors
//            .groupingBy(City::getContinent, Collectors.maxBy(Comparator.comparing(City::getPopulation)));
//    }


}
