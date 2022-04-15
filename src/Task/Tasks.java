package Task;

import java.util.ArrayList;

public class Tasks {
    public ArrayList<Task> task_list;

    public Tasks(int n) {
        task_list = new ArrayList<Task>(n);
    }

    public void add(String text) {
        Task tmp = null;
        tmp.text = text;
        task_list.add(tmp);
    }

}