import java.io.Console;
import java.util.Scanner;

import Task.Task;
import Task.Tasks;

public class Main {

    public static void main(String[] args) {
        Console console = System.console();
        Tasks task_man = new Tasks(5);
        while (console != null) {
            Scanner sc = new Scanner(console.reader());
            System.out.println("Enter your command");
            String input = sc.nextLine();
            if (input.equals("add")) {
                System.out.println("Write task");
                input = sc.nextLine();
                task_man.add(input);
            }
            if (input.equals("print")) {
                System.out.println("Task | is_done");
                for (Task task : task_man.task_list) {
                    System.out.println(task.text);
                }
            }
            console = System.console();
        }
        System.out.println("Console is null");

    }

}
