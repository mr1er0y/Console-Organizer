//package examples.dustin.commandline.picocli;

import static java.lang.System.out;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;


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
    @Option(names={"-v", "--verbose"}, description="Verbose output?")
    private boolean verbose;

    @Option(names={"-f", "--file"}, description="Path and name of file", required=true)
    private String fileName;

    @Option(names={"-h", "--help"}, description="Display help/usage.", help=true)
    boolean help;

    public static void main(final String[] arguments)
    {
        final Main main = CommandLine.populateCommand(new Main(), arguments);
        Tasks task_man = new Tasks(5);
        if (main.help)
        {
            CommandLine.usage(main, out, CommandLine.Help.Ansi.AUTO);
        }
        if (main.fileName != null) {
            out.println("Your file is: " + main.fileName );
            task_man.read(main.fileName);
        }
        Console console = System.console();

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
