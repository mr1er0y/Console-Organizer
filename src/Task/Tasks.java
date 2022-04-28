package Task;

import static java.lang.System.out;

import java.util.ArrayList;
import Task.TaskFiles;

public class Tasks {
    public  ArrayList<Task> task_list;

    public Tasks(int n) {
        task_list = new ArrayList<Task>(n);
    }

    public void add(String text){
        task_list.add(new Task(text));
    }

    public void save(String filename) {
        TaskFiles a = new TaskFiles();
        a.save_file(filename,  task_list);
    }

    public void read(String filename){
//        save_file(String filename,  task_list);
    }

}