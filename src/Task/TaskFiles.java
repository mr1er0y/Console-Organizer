package Task;

 


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files


import Task.Task;

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
        File file = new File("/Users/sania/IdeaProjects/Console-Organizer/"+filename);
        try (FileWriter myWriter = new FileWriter(file)) {
                for (Task task : list_tasks) {
                    myWriter.write("Task:" + task.text + "Deadline:" + task.text + "is_done" + task.is_don);
                }

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
