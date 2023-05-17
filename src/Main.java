import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            CityService cityService = new CityService("http://localhost/IS_LAB6_REST/cities/read/10");
            List<City> cities = cityService.getCities();
            for (City city : cities) {
                System.out.println("\nId:" + city.getId());
                System.out.println("\tName:" + city.getName());
                System.out.println("\tCountry Code:" + city.getCountryCode());
                System.out.println("\tDistrict:" + city.getDistrict());
                System.out.println("\tPopulation:" + city.getPopulation());
            }
        } catch (Exception e) {
            System.err.println("Wystąpił nieoczekiwany błąd!!! ");
            e.printStackTrace(System.err);
        }
    }
}


/*
public class Main {
    public static void main(String[] args) {
        try {
            //Test działania lokalnego REST API
            String temp_url = "http://localhost/IS_LAB6_REST/cities/read/";
            URL url = new URL(temp_url);
            System.out.println("Wysyłanie zapytania...");
            InputStream is = url.openStream();
            System.out.println("Pobieranie odpowiedzi...");
            String source = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
            System.out.println("Przetwarzanie danych...");
            JSONObject json = new JSONObject(source);
            JSONArray recieveddata = (JSONArray)json.get("cities");
            for (Object element : recieveddata) {
                System.out.println("\nId:" + ((JSONObject)element).get("ID"));
                System.out.println("\tName:" + ((JSONObject)element).get("Name"));
                System.out.println("\tCountry Code:" + ((JSONObject)element).get("Country Code"));
                System.out.println("\tDistrict:" + ((JSONObject)element).get("District"));
                System.out.println("\tPopulation:" + ((JSONObject)element).get("Population"));
            }
        } catch (Exception e) {
            System.err.println("Wystąpił nieoczekiwany błąd!!! ");
            e.printStackTrace(System.err);
        }
    }
}*/