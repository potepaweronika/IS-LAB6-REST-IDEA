import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CityService {
    private String Url;

    public CityService(String Url) {
        this.Url = Url;
    }

    public List<City> getCities() throws IOException {
        URL url = new URL(Url);
        InputStream is = url.openStream();
        String source = new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.joining("\n"));
        JSONObject json = new JSONObject(source);
        JSONArray receivedData = (JSONArray)json.get("cities");
        return IntStream.range(0, receivedData.length())
                .mapToObj(i -> receivedData.getJSONObject(i))
                .map(obj -> new City(
                        obj.getInt("ID"),
                        obj.getString("Name"),
                        obj.getString("Country Code"),
                        obj.getString("District"),
                        obj.getInt("Population")
                ))
                .collect(Collectors.toList());
    }
}
