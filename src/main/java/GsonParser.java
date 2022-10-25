import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class GsonParser {

    public Root parse()
    {
        Gson gson = new Gson();
        Insert insert = new Insert();

        try (FileReader reader = new FileReader(insert.filling())){

            Root root=gson.fromJson(reader, Root.class);
            System.out.println("Файл загружен");
            System.out.println("Файл разобран:");
            return root;

        } catch (Exception e) {
            System.out.println("Parsing error"+e.toString());
        }
        return null;
    }
}

