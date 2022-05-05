package Task;

import java.nio.file.Path;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files


import Task.Task;

import com.google.gson.stream.JsonReader;
import org.json.JSONObject;
import com.google.gson.Gson;


public class TaskFiles {
    public static void main(String[] args) {


        try (Scanner myReader = new Scanner(new File("filename.txt"))) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void save_file(String filename, ArrayList<Task> list_tasks) {
        File file = new File(System.getProperty("user.dir") + File.separator + filename);
        try (FileWriter myWriter = new FileWriter(file)) {

            for (Task task : list_tasks) {
                myWriter.write("Task: " + task.text + " Deadline: " + task.deadline + " is_done " + task.is_done + "\n");
            }

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void save_json_file(String filename, ArrayList<JSONObject> list_js) {
        File file = new File(System.getProperty("user.dir") + File.separator + filename);
        try (FileWriter myWriter = new FileWriter(file)) {
            for (JSONObject el : list_js) {
                myWriter.write(el.toString());
                myWriter.flush();
            }

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public ArrayList<Task> read_json_file(String filename) throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(filename));
        ArrayList<Task> data = gson.fromJson(reader, Task.class);
        return data;
    }
}
