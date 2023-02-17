import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<City> cities = CityUtils.parseCities();

        sortByCityName(cities);
        print(cities);

        sortByDistrictAndName(cities);
        print(cities);

        searchMaxPopulation(cities);

        numberCityOfRegion(cities);

    }

    private static void numberCityOfRegion(List<City> cities) {
        Map<String, Long> regions =
                cities.stream().collect(Collectors.groupingBy(
                        City :: getRegion, Collectors.counting()));
        regions.forEach((region, numb) -> System.out.println(region + " - " + numb));

    }

    private static void searchMaxPopulation(List<City> cities) {
        cities.toArray();
        City maxPopulation = Collections.max(cities, Comparator.comparingLong(City::getPopulation));
        System.out.println("["+ cities.indexOf(maxPopulation) +"]" + " = " + maxPopulation.getPopulation());
    }

    private static void sortByCityName(List<City> cities) {
        cities.sort((c1,c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
    }

    private static void sortByDistrictAndName(List<City> cities) {
        cities.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
    }

    public static void print(List<City> cities) {
        cities.forEach(System.out :: println);

    }

}

