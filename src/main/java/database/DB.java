package database;

import beans.Prisoner;
import beans.Vehicle;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class DB {
    public static List<Prisoner> getPrisonersList() throws IOException {
        InputStream inputStream = Resources.getResource("prisoners.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<Prisoner>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }

    public static List<Vehicle> getVehicleList() throws IOException {
        InputStream inputStream = Resources.getResource("vehicles.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<Vehicle>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }
}
