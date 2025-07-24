
package Form;

//for imports of the .io fields (Everything);
import java.io.*;
//for the arraylists;
import java.util.ArrayList;

//This Class handles the saving and loading of the employee data upon closing and opening;
public class FileHandler {
    
    //to save the data to "Borrowers.dat";
    public static void saveToFile(ArrayList<Employee> employeeList, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(employeeList);
            System.out.println("Saved successfully to " + filename);
        }
        catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }        
    }
   
    //to load the data from to "Borrowers.dat";
    public static ArrayList<Employee> loadFromFile(String filename) {
        ArrayList<Employee> loadedList = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            loadedList = (ArrayList<Employee>) in.readObject();
            System.out.println("Loaded successfully from " + filename);
        } 
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading employees: " + e.getMessage());
        }
        return loadedList;
    }
}
