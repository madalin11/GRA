package rep.PP.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import rep.PP.exceptions.EmployeeAlreadyExistsException;
import rep.PP.model.EmployeeClass;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class EmployeeService {


    private static JSONArray usersList = new JSONArray();
    private static ArrayList<EmployeeClass> users = new ArrayList<>();


    public static void  loadEmployeesFromFile()  {

        Object p;
        JSONParser parser = new JSONParser();
        try{
            FileReader readFile = new FileReader("src/main/java/rep/PP/data/employees.json");
            BufferedReader read = new BufferedReader(readFile);
            p = parser.parse(read);
            if(p instanceof JSONArray)
            {
                usersList =(JSONArray)p;
            }

        } catch (ParseException | IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void read () {

        JSONParser parser1 = new JSONParser();

        try (Reader reader = new FileReader("src/main/java/rep/PP/data/employees.json")) {
            JSONArray jsonArray = (JSONArray) parser1.parse(reader);

            Iterator<JSONObject> it = jsonArray.iterator();
            while (it.hasNext()) {
                JSONObject obj = it.next();
                EmployeeClass user = new EmployeeClass(obj.get("name").toString(),obj.get("role").toString(),obj.get("CNP").toString(), obj.get("firstname").toString());
                users.add(user);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static void  addEmployee(String name, String role, String CNP,  String firstname) throws EmployeeAlreadyExistsException {

        loadEmployeesFromFile();   //Incarcam toti useri din fisierul json intr-o lista pentru a nu ii pierde
        read();                //Incarcam useri intr-un ArrayList
        //Salvam continutul deja existent in  fisier pentru a nu se pierde


        checkUserDoesNotAlreadyExist(CNP);
        //Punem un nou obiect in fisier
        JSONObject user = new JSONObject();

        user.put("name",name);
        user.put("role",role);
        user.put("CNP", CNP);
        user.put("firstname", firstname);
        usersList.add(user);


        try (FileWriter file = new FileWriter("src/main/java/rep/PP/data/employees.json")) {

            file.write(usersList.toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static void checkUserDoesNotAlreadyExist( String CNP)throws EmployeeAlreadyExistsException {

        for (EmployeeClass userIterator : users) {
            if (Objects.equals(CNP, userIterator.getCNP()) )
                throw new EmployeeAlreadyExistsException(CNP);
        }
    }
}