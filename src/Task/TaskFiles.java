package Task;

import java.nio.file.Path;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files


import Task.Task;
import org.json.JSONObject;

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
        File file = new File( "/Users/leonid/IdeaProjects/Console-Organizer/input.txt"+ filename);
        try (FileWriter myWriter = new FileWriter(file)) {
            for (Task task : list_tasks) {
                myWriter.write("Task:" + task.text + "Deadline:" + task.text + "is_done" + task.is_done);
            }

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void save_jsfile(String filename, ArrayList<JSONObject> list_js) {

        File file = new File(System.getProperty("user.dir") + filename);
        try (FileWriter myWriter = new FileWriter(file)) {
            for (JSONObject el : list_js) {
                myWriter.write(el.toString());
            }

//            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
