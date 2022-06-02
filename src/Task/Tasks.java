package Task;

import static java.lang.System.out;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.util.ArrayList;


public class Tasks {
    public ArrayList<Task> task_list;
    public String temp_filename;

    public Tasks() {
        task_list = new ArrayList<>();
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

    public void add_tag(int Id, String tag_name) {task_list.get(Id).add_tag(tag_name);}

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


    public void save_json() {
        TaskFiles a = new TaskFiles();
        a.save_gson_file(temp_filename, task_list );
    }

    public void read_json(String filename) throws FileNotFoundException {
        TaskFiles a = new TaskFiles();
        task_list = a.read_gson_file(temp_filename);
    }

    public void delete(int Id) {
            task_list.remove(Id);
    }

    public void read(String filename){
//        save_file(String filename,  task_list);
    }

    // Сортировка по метке
    public ArrayList<Task> tag_sort(String tag) {
        ArrayList<Task> res = new ArrayList<>();
        for (int i = 0; i < task_list.size(); i++) {
            if (task_list.get(i).tags.contains(tag)) {
                res.add(task_list.get(i));
            }
        }
        return res;
    }

    // Сортировка по дедлайну
    public ArrayList<Task> deadline_sort() {
        ArrayList<Task> res = new ArrayList<>();

        //  deepcopy
        for (int i = 0; i < task_list.size(); i++) {
            res.add(task_list.get(i));
        }

        res.sort((o1, o2) -> o1.deadline.compareTo(o2.deadline));
        return res;
    }

    // Список сделанных дел
    public ArrayList<Task> done_sort() {
        ArrayList<Task> res = new ArrayList<>();
        for (int i = 0; i < task_list.size(); i++) {
            if (task_list.get(i).is_done) {
                res.add(task_list.get(i));
            }
        }
        return res;
    }

    // Список несделанных дел 
    public ArrayList<Task> not_done_sort() {
        ArrayList<Task> res = new ArrayList<>();
        for (int i = 0; i < task_list.size(); i++) {
            if (!task_list.get(i).is_done) {
                res.add(task_list.get(i));
            }

        }
        return res;

    }
}