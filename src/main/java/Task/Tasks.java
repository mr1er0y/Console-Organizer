package Task;

import static java.lang.System.out;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.ArrayList;

public class Tasks {
    public List<Task> task_list;
    private String temp_filename;

    public Tasks() {
        task_list = new ArrayList<Task>();
    }

    public String getTempFilename() {
        return temp_filename;
    }

    public void setTempFilename(String new_name) {
        temp_filename = new_name;
    }

    public void add(String text) {
        task_list.add(new Task(text, task_list.size(), 0));
    }

    public void add(String text, String StringDate) {
        SimpleDateFormat dateParser = new SimpleDateFormat("MM/dd/yy HH:mm");
        {
            try {
                Date date = dateParser.parse(StringDate);
                task_list.add(new Task(text, task_list.size(), date, 0));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public void done(int Id) {
        task_list.get(Id).done();
    }

    public void addTag(int Id, String tag_name) {task_list.get(Id).addTag(tag_name);}

    public void edit(int Id, String option, String new_value) {
        if (option.equals("n")) {
            task_list.get(Id).editName(new_value);
        }
        if (option.equals("d")) {
            SimpleDateFormat dateParser = new SimpleDateFormat("MM/dd/yy HH:mm");
            {
                try {
                    Date newDate = dateParser.parse(new_value);
                    task_list.get(Id).editDeadline(newDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void save(String filename) {
        TaskFiles a = new TaskFiles();
        a.saveFile(filename,  task_list);
    }


    public void saveJson() {
        TaskFiles a = new TaskFiles();
        a.save_gson_file(temp_filename, task_list );
    }

    public void readJson(String filename) throws FileNotFoundException {
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

    public void tagSort(String tag) {
        for (Task task : task_list) {
            if (task.getTags().contains(tag)) {
                System.out.println(task.getId() + ". " + task.getText() + " Deadline: " + task.getDeadline() + " Is done: " + task.isDone());
                out.println("tags: ");
                for (String t : task.getTags()) { out.print(t + " "); }
                out.println(); 

            }
        }
    }

    // Сортировка по дедлайну

    public void deadlineSort() {
        List<Task> res = new ArrayList<Task>();

        //  deepcopy
        for (int i = 0; i < task_list.size(); i++) {
            res.add(task_list.get(i));
        }

//        res.sort((o1, o2) -> o1.deadline.compareTo(o2.deadline));

        for (Task task : task_list) {
            System.out.println(task.getId() + ". " + task.getText() + " Deadline: " + task.getDeadline() + " Is done: " + task.isDone());
            out.println("tags: ");
            for (String t : task.getTags()) { out.print(t + " "); }
            out.println();
        }
    }

    // Список сделанных дел
    public void doneSort() {
        for (Task task : task_list) {
            if (task.isDone() == "Yes") {
                System.out.println(task.getId() + ". " + task.getText() + " Deadline: " + task.getDeadline() + " Is done: " + task.isDone());
                out.println("tags: ");
                for (String t : task.getTags()) { out.print(t + " "); }
                out.println();
            }
        }
    }

    // Сортировка по выбранному приоритету 
    public void priopity_sort(int priority) {
        for (Task task : task_list) {
            if (task.getPriority() == priority) {
                System.out.println(task.getId() + ". " + task.getText() + " Deadline: " + task.getDeadline() + " Is done: " + task.isDone());
                out.println("tags: ");
                for (String t : task.getTags()) { out.print(t + " "); }
                out.println();

            }
        }
    }

    // Список несделанных дел 

    public void notDoneSort() {
        for (Task task : task_list) {
            if (task.isDone() == "No") {
                System.out.println(task.getId() + ". " + task.getText() + " Deadline: " + task.getDeadline() + " Is done: " + task.isDone());
                out.println("tags: ");
                for (String t : task.getTags()) { out.print(t + " "); }
                out.println();

            }

        }
    }
}