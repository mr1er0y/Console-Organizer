import static java.lang.System.out;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;


import java.io.Console;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


import Task.Tasks;
import Task.*;

/**
 * Demonstrate Java-based command-line processing with picocli.
 */
@Command(
        name = "Main",
        description = "@|bold Demonstrating picocli |@",
        headerHeading = "@|bold,underline Demonstration Usage|@:%n%n")
public class Main {
    @Option(names = {"-f", "--file"}, description = "Path and name of file", required = false)
    private String fileName;

    @Option(names = {"-n", "--new file"}, description = "Create new file", required = false)
    private String newfileName;

    @Option(names = {"-h", "--help"}, description = "Display help/usage.", help = true)
    boolean help;

    public static void main(final String[] arguments) throws FileNotFoundException {
        final Main main = CommandLine.populateCommand(new Main(), arguments);

        Tasks task_man = new Tasks();
        if (main.help) {

            CommandLine.usage(main, out, CommandLine.Help.Ansi.AUTO);
        }

        Console console = System.console();
        Scanner sc = new Scanner(console.reader());

        if (main.fileName != null) {
            out.println("Your file is: " + main.fileName);
            System.out.println("Write the fileName");
            String input = sc.nextLine();
            input = input.trim();
            main.fileName = input;
            task_man.read_json(main.fileName);
        }
        if (main.newfileName == null || main.fileName == null) {
            System.out.println("Write filename for new project");
            task_man.temp_filename = sc.nextLine().trim();;
        }


        while (console != null) {
            sc = new Scanner(console.reader());
            System.out.println("Enter your command");
            String input = sc.nextLine();
            input = input.trim();
            if (input.equals("add")) {
                System.out.println("Write task");
                String task_name = sc.nextLine();
                out.println("Want to add a deadline? (y/n)");
                String response = sc.nextLine();
                if (response.equals("y")) {
                    out.println("Write deadline in MM/dd/yyyy HH:mm  format");
                    String stringDate = sc.nextLine();
                    task_man.add(task_name, stringDate);
                }
                if (response.equals("n")) {
                    task_man.add(task_name);
                    out.println("Added task " + task_name);
                }
            }

            if (input.equals("done")) {
                out.println("Write task Id");
                int Id = Integer.parseInt(sc.nextLine());
                task_man.done(Id);
            }

            if (input.equals("print")) {
                System.out.println("Tasks:");
                for (Task task : task_man.task_list) {
                    System.out.println(task.Id + ". " + task.text + " Deadline: " + task.deadline + " Is done: " + task.isDone());
                    out.println("tags: ");
                    for (String tag : task.tags) {out.print(tag + " ");}
                    out.println();
                }
            }

            if (input.equals("sort")) {
                out.println("Choose how to sort by (tag/deadline/done/not done)");
                String sort_option = sc.nextLine();
                ArrayList<Task> to_print = new ArrayList<>();
                if (sort_option.equals("tag")) {
                    out.println("Write tag name");
                    String tag = sc.nextLine();
                    to_print = task_man.tag_sort(tag);
                }
                if (sort_option.equals("deadline")) { to_print = task_man.deadline_sort(); }
                if (sort_option.equals("done")) { to_print = task_man.done_sort(); }
                if (sort_option.equals("not done")) { to_print = task_man.not_done_sort(); }
                for (Task task : to_print) {
                    System.out.println(task.Id + ". " + task.text + " Deadline: " + task.deadline + " Is done: " + task.isDone());
                    out.println("tags: ");
                    for (String t : task.tags) {out.print(t + " ");}
                    out.println();
                }
            }

            if (input.equals("add tag")) {
                out.println("Write task ID");
                int Id = Integer.parseInt(sc.nextLine());
                out.println("Write tag name");
                String tag_name = sc.nextLine();
                task_man.add_tag(Id, tag_name);
                out.println("Successfully added tag " + tag_name);
            }

            if (input.equals("save")) {
                System.out.println("Write file name");
                String filename = sc.nextLine();
                task_man.save(filename);
            }
            if (input.equals("js")) {
                task_man.save_json();
            }
            if (input.equals("read js")) {
                System.out.println("Write file name");
                String filename = sc.nextLine();
                task_man.read_json(filename);
            }

            if (input.equals("edit")) {
                out.println("Write task Id");
                int Id_to_edit = Integer.parseInt(sc.nextLine());
                out.println("Edit name or deadline? (n/d)");
                String option = sc.nextLine();
                out.println("Write new value (if deadline, then write in MM/dd/yyyy HH:mm format)");
                String new_value = sc.nextLine();
                task_man.edit(Id_to_edit, option, new_value);
            }

            if (input.equals("delete")) {
                out.println("Enter task Id");
                int Id_to_delete = Integer.parseInt(sc.nextLine());
                task_man.delete(Id_to_delete);
            }

            if (input.equals("help") || input.equals("h")) {
                out.println("Option");
                out.println("add: add your task");
                out.println("done: mark task as done");
                out.println("edit: edit your task");
                out.println("delete: delete your task");
                out.println("print: output tasks in commandline");
                out.println("save: save tasks in file format.txt");
            }

            console = System.console();
        }
        System.out.println("Console is null");
    }
}
//java -cp $lib\:src src/Main.java -f=input.txt