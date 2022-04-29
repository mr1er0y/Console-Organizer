package Task;

import static java.lang.System.out;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

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

    public void edit(String name, String option, String new_value) {
        if (option.equals("name")) {
            for (int i = 0; i < task_list.size(); i++) {
                Task curr_task = task_list.get(i);
                if (curr_task.text.equals(name)) {
                    task_list.get(i).edit_name(new_value);
                }
            }
        }

        if (option.equals("deadline")) {
            try {
                Date deadline_date = new SimpleDateFormat("dd/MM/yyyy").parse(new_value);
                for (int i = 0; i < task_list.size(); i++) {
                    Task curr_task = task_list.get(i);
                    if (curr_task.text.equals(name)) {
                        task_list.get(i).edit_deadline(deadline_date);
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public void save(String filename) {
        TaskFiles a = new TaskFiles();
        a.save_file(filename,  task_list);
    }

    public void delete(String name) {
            task_list.removeIf(task -> task.text.equals(name));
    }

    public void read(String filename){
//        save_file(String filename,  task_list);
    }
}