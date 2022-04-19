package Task;

import java.util.ArrayList;

public class Tasks {
    public  ArrayList<Task> task_list;

    public Tasks(int n) {
        task_list = new ArrayList<Task>(n);
    }

    public void add(String text){
        task_list.add(new Task(text));
    }

    public void save(String filename){
//        save_file(String filename,  task_list);
    }

}