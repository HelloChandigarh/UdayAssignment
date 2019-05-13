import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class CoordinateDistance {


    public static void main(String[] args) {

        CoordinateDistance coordinateDistance=new CoordinateDistance();
        Integer x=Integer.parseInt(args[0]);
        Integer y=Integer.parseInt(args[1]);

        Map<String,Double> mapDistance=new HashMap<>();

        JSONParser jsonParser=new JSONParser();
        try(FileReader fileReader=new FileReader
                ("C:\\Users\\e5557526\\Desktop\\New folder\\10AprilEveningUpdatedProject" +
                        "\\Assignment\\src\\main\\resources\\Coordinates.json")){
            Object object = jsonParser.parse(fileReader);
            JSONArray array=(JSONArray)object;
            List<JSONObject> jsonObjects=new ArrayList<>();
            array.forEach(a-> jsonObjects.add((JSONObject)a));
            for (JSONObject jsonObject : jsonObjects) {
                String[] values = jsonObject.get("value").toString().split(",");
                int x2=Integer.parseInt(values[0]);
                int y2=Integer.parseInt(values[1]);
                mapDistance.put(jsonObject.get("value").toString(),
                        coordinateDistance.getDistance(x,y,x2,y2));
            }
            Map<String, Double> sortedByDistance =mapDistance.entrySet().stream()
                    .sorted(Map.Entry.<String,Double>comparingByValue())
                    .collect(Collectors.toMap(Map.Entry::getKey,
                            Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            sortedByDistance.entrySet().stream().forEach(a-> System.out.println(a.getKey()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public double getDistance(int x1,int y1,int x2,int y2){
        double dis;
        dis=Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
        return dis;
    }
}
