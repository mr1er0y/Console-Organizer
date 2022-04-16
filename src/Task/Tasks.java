package Task;

import java.util.LinkedList;

public class Tasks {
    public static LinkedList<Task> task_list;

    public Tasks(int n) {
        task_list = new LinkedList<Task>();
    }

    public void add(String text){
        task_list.add(new Task(text));
    }

}