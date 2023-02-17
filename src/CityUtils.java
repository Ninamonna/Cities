import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CityUtils {

    public static List<City> parseCities() {

        List<City> cities = new ArrayList<>();

        Scanner scanner = null;

        try {
            scanner = new Scanner(new File("src/city_ru.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            cities.add(parse(scanner.nextLine()));

        }
        scanner.close();

//        Collections.sort(cities, new Comparator<City>() {
//            public int compare(City o1, City o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        return cities;
    }

    private static void printCities(List<City> cities) {
        cities.forEach(System.out::println);
    }

    public static City parse(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        scanner.skip("\\d*");
        String name = scanner.next();
        String region = scanner.next();
        ;
        String district = scanner.next();
        ;
        long population = scanner.nextLong();
        String foundation = null;
        if (scanner.hasNext()) {
            foundation = scanner.next();
        }
        scanner.close();
        return new City(name, region, district, population, foundation);
    }
}
