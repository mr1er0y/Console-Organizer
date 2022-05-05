//package examples.dustin.commandline.picocli;

import static java.lang.System.out;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;


import java.awt.geom.RectangularShape;
import java.io.Console;
import java.util.Scanner;

import Task.Task;
import Task.Tasks;
/**
 * Demonstrate Java-based command-line processing with picocli.
 */
@Command(
        name="Main",
        description="@|bold Demonstrating picocli |@",
        headerHeading="@|bold,underline Demonstration Usage|@:%n%n")
public class Main
{
    @Option(names={"-f", "--file"}, description="Path and name of file", required=true)
    private String fileName;

    @Option(names={"-n", "--newfile"}, description="Creat new file", required=false)
    private String newfileName;

    @Option(names={"-h", "--help"}, description="Display help/usage.", help=true)
    boolean help;

    public static void main(final String[] arguments)
    {
        final Main main = CommandLine.populateCommand(new Main(), arguments);
        Tasks task_man = new Tasks();
        if (main.help)
        {
            CommandLine.usage(main, out, CommandLine.Help.Ansi.AUTO);
        }
        if (main.fileName != null) {
            out.println("Your file is: " + main.fileName );

//            task_man.read(main.fileName);
        }
        if (main.newfileName != null) {
            out.println("Your file is: " + main.newfileName );
//            task_man.read(main.new_fileName);

        }
        Console console = System.console();

        while (console != null) {
            Scanner sc = new Scanner(console.reader());
            System.out.println("Enter your command");
            String input = sc.nextLine();
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
                }
            }

            if (input.equals("save")) {
                System.out.println("Write file name");
                String fname = sc.nextLine();
                task_man.save(fname);
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

            console = System.console();
        }
        System.out.println("Console is null");
    }

}
//java -cp $lib\:src src/Main.java -f=input.txt