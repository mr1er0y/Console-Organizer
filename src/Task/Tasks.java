package Task;

import static java.lang.System.out;

import java.util.ArrayList;
import Task.TaskFiles;
import org.json.JSONObject;


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
    public ArrayList<JSONObject> arr_json() {
        ArrayList<JSONObject> js = new ArrayList<JSONObject>();
        for (Task el: task_list ) {
            js.add(el.SaveIntoJson());
        }
        return js;
    }

    public void read(String filename){
//        save_file(String filename,  task_list);
    }

}