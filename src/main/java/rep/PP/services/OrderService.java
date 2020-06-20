package rep.PP.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import rep.PP.model.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class OrderService {
    private static JSONArray ordList = new JSONArray();
    private static ArrayList<Order> orders = new ArrayList<Order>();


    public static void  loadOrdersFromFile()  {

        Object p;
        JSONParser parser = new JSONParser();
        try{
            FileReader readFile = new FileReader("src/main/java/rep/PP/data/order.json");
            BufferedReader read = new BufferedReader(readFile);
            p = parser.parse(read);
            if(p instanceof JSONArray)
            {
                ordList =(JSONArray)p;
            }

        } catch (ParseException | IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void read () {

        JSONParser parser1 = new JSONParser();

        try (Reader reader = new FileReader("src/main/java/rep/PP/data/order.json")) {
            JSONArray jsonArray = (JSONArray) parser1.parse(reader);

            Iterator<JSONObject> it = jsonArray.iterator();
            while (it.hasNext()) {
                JSONObject obj = it.next();
                Order order = new Order(obj.get("name").toString(),obj.get("interior").toString(), obj.get("culoare").toString(),obj.get("jante").toString(),obj.get("feedback").toString());
                orders.add(order);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void  addOrder(String name, String interior,  String culoare, String jante,String feedback)  {

        loadOrdersFromFile();
        read();

    //Punem un nou obiect in fisier
    JSONObject car = new JSONObject();

    car.put("name", name);
    car.put("feedback",feedback);
    car.put("interior", interior);
    car.put("culoare", culoare);
    car.put("jante", jante);
    ordList.add(car);


        try (FileWriter file = new FileWriter("src/main/java/rep/PP/data/order.json")) {

            file.write(ordList.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
