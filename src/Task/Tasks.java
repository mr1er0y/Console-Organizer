package Task;

import static java.lang.System.out;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import Task.TaskFiles;
import org.json.JSONObject;


public class Tasks {
    public  ArrayList<Task> task_list;

    public Tasks() {
        task_list = new ArrayList<Task>();
    }

    public void add(String text) {
        task_list.add(new Task(text, task_list.size()));
    }

    public void add(String text, String StringDate) {
        SimpleDateFormat dateParser = new SimpleDateFormat("MM/dd/yy HH:mm");
        {
            try {
                Date date = dateParser.parse(StringDate);
                task_list.add(new Task(text, date, task_list.size()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public void done(int Id) {
        task_list.get(Id).done();
    }

    public void edit(int Id, String option, String new_value) {
        if (option.equals("n")) {
            task_list.get(Id).edit_name(new_value);
        }
        if (option.equals("d")) {
            SimpleDateFormat dateParser = new SimpleDateFormat("MM/dd/yy HH:mm");
            {
                try {
                    Date newDate = dateParser.parse(new_value);
                    task_list.get(Id).edit_deadline(newDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

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

    public void delete(int Id) {
            task_list.remove(Id);
    }

    public void read(String filename){
//        save_file(String filename,  task_list);
    }

    // Сортировка по метке 
    public ArrayList<Task> tag_sort(String tag) {
        res = new ArrayList<Task>();
        for (int i = 0; i < task_list.size(); i++) {
            if ((task_list.tags).contains(tag)) {
                res.add(task_list[i]);
            }
        }
        return task;
    }

    // Сортировка по дедлайну
    public ArrayList<Task> deadline_sort(String tag) {
        res = new ArrayList<Task>();

        //  deepcopy
        for (int i = 0; i < task_list.size(); i++) {
            res.add(task_list[i]);
        }

        res.sort((o1, o2) -> o1.deadline.compareTo(o2.deadline));
        return res;
    }

    // Список сделанных дел
    public ArrayList<Task> done_sort(String tag) {
        res = new ArrayList<Task>();
        for (int i = 0; i < task_list.size(); i++) {
            if (task_list.is_done) {
                res.add(task_list[i]);
            }
        }
        return task;
    }

    // Список несделанных дел 
    public ArrayList<Task> not_done_sort(String tag) {
        res = new ArrayList<Task>();
        for (int i = 0; i < task_list.size(); i++) {
            if (!task_list.is_done) {
                res.add(task_list[i]);
            }
        }
        return task;
    }
}