package Task;

import java.lang.reflect.Type;
import java.nio.file.Path;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files


import Task.Task;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
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


    public void saveFile(String filename, List<Task> list_tasks) {
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



    public void save_gson_file(String filename, List<Task> list_tasks) {
        File file = new File(System.getProperty("user.dir") + File.separator + filename);
        Gson gson = new Gson();
        try (FileWriter myWriter = new FileWriter(file)) {
            gson.toJson(list_tasks, myWriter);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public List<Task> read_gson_file(String filename)  {
        Gson gson = new Gson();
        List<Task> data = null;
        Type AR_TYPE = new TypeToken<List<Task>>() {
        }.getType();
        try (FileReader myReader = new FileReader(filename)) {
            JsonReader reader = new JsonReader(myReader);

            data = gson.fromJson(reader, AR_TYPE);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }
}
