package rep.PP.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import rep.PP.exceptions.EmployeeAlreadyExistsException;
import rep.PP.model.Car;
import rep.PP.model.EmployeeClass;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class CarService {
    private static JSONArray carList = new JSONArray();
    private static ArrayList<Car> cars = new ArrayList<>();


    public static void  loadCarsFromFile()  {

        Object p;
        JSONParser parser = new JSONParser();
        try{
            FileReader readFile = new FileReader("src/main/java/rep/PP/data/carList.json");
            BufferedReader read = new BufferedReader(readFile);
            p = parser.parse(read);
            if(p instanceof JSONArray)
            {
                carList =(JSONArray)p;
            }

        } catch (ParseException | IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void read () {

        JSONParser parser1 = new JSONParser();

        try (Reader reader = new FileReader("src/main/java/rep/PP/data/carList.json")) {
            JSONArray jsonArray = (JSONArray) parser1.parse(reader);

            Iterator<JSONObject> it = jsonArray.iterator();
            while (it.hasNext()) {
                JSONObject obj = it.next();
                Car car = new Car(obj.get("name").toString(),obj.get("pret").toString(),obj.get("interior").toString(), obj.get("jante").toString(),obj.get("jante").toString());
                cars.add(car);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void  addCar(String name, String pret, String interior,  String culoare, String jante)  {

        loadCarsFromFile();
        read();


        //Punem un nou obiect in fisier
        JSONObject car = new JSONObject();

        car.put("name",name);
        car.put("pret",pret);
        car.put("interior", interior);
        car.put("culoare", culoare);
        car.put("jante", jante);
        carList.add(car);


        try (FileWriter file = new FileWriter("src/main/java/rep/PP/data/carList.json")) {

            file.write(carList.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}