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
    private int currentId;

    public Tasks() {
        task_list = new ArrayList<Task>();
        currentId = 0;
    }

    public String getTempFilename() {
        return temp_filename;
    }

    public void setTempFilename(String new_name) {
        temp_filename = new_name;
    }

    public void add(String text) {
        task_list.add(new Task(text, currentId++, 0));
    }

    public void add(String text, String StringDate, String StringPrioroty) {
        SimpleDateFormat dateParser = new SimpleDateFormat("MM/dd/yy HH:mm");
        {
            try {
                if (StringDate == null) {
                    int priority = Integer.parseInt(StringPrioroty);
                    task_list.add(new Task(text,  currentId++, priority));
                } else {
                    Date date = dateParser.parse(StringDate);
                    int priority = Integer.parseInt(StringPrioroty);
                    task_list.add(new Task(text,  currentId++, date, priority));
                }


            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public void done(int Id) {
        task_list.get(Id).done();
    }

    public void addTag(int Id, String tag_name) {
        task_list.get(Id).addTag(tag_name);
    }

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
        a.saveFile(filename, task_list);
    }


    public void saveJson() {
        TaskFiles a = new TaskFiles();
        a.save_gson_file(temp_filename, task_list);
    }

    public void readJson(String filename) throws FileNotFoundException {
        TaskFiles a = new TaskFiles();
        task_list = a.read_gson_file(temp_filename);
    }

    public void delete(int Id) {
        task_list.remove(Id);
    }

    public void read(String filename) {
//        save_file(String filename,  task_list);
    }

    // Сортировка по метке

    public int tagSort(String tag) {
        int count = 0;
        for (Task task : task_list) {
            if (task.getTags().contains(tag)) {
                System.out.println(task.getId() + ". " + task.getText() + " Deadline: " + task.getDeadline() + " Priority: " + task.getPriority() + " Is done: " + task.isDone());
                out.println("tags: ");
                for (String t : task.getTags()) {
                    out.print(t + " ");
                }
                out.println();
                ++count;
            }
        }
        return count;
    }

    // Сортировка по дедлайну

    public List<Task> deadlineSort() {
        List<Task> res = new ArrayList<>();

        //  deepcopy
        for (int i = 0; i < task_list.size(); i++) {
            if (task_list.get(i).getDeadline() != null) {
                res.add(task_list.get(i));
            }
        }

        res.sort((o2, o1) -> o2.getDeadline().compareTo(o1.getDeadline()));

        for (Task task : task_list) {
            System.out.println(task.getId() + ". " + task.getText() + " Deadline: " + task.getDeadline() + " Priority: " + task.getPriority() + " Is done: " + task.isDone());
            out.println("tags: ");
            for (String t : task.getTags()) {
                out.print(t + " ");
            }
            out.println();
        }
        return res;
    }

    // Список сделанных дел
    public int doneSort() {
        int count = 0;
        for (Task task : task_list) {
            if (task.isDone() == "YES") {
                System.out.println(task.getId() + ". " + task.getText() + " Deadline: " + task.getDeadline() + " Priority: " + task.getPriority() + " Is done: " + task.isDone());
                out.println("tags: ");
                for (String t : task.getTags()) {
                    out.print(t + " ");
                }
                out.println();
                ++count;
            }
        }
        return count;
    }

    // Сортировка по выбранному приоритету 
    public void priority_sort(int priority) {
        for (Task task : task_list) {
            if (task.getPriority() == priority) {
                System.out.println(task.getId() + ". " + task.getText() + " Deadline: " + task.getDeadline() + " Priority: " + task.getPriority() + " Is done: " + task.isDone());
                out.println("tags: ");
                for (String t : task.getTags()) {
                    out.print(t + " ");
                }
                out.println();

            }
        }
    }

    // Список несделанных дел 

    public int notDoneSort() {
        int count = 0;
        for (Task task : task_list) {
            if (task.isDone() == "NO") {
                System.out.println(task.getId() + ". " + task.getText() + " Deadline: " + task.getDeadline() + " Priority: " + task.getPriority() + " Is done: " + task.isDone());
                out.println("tags: ");
                for (String t : task.getTags()) {
                    out.print(t + " ");
                }
                out.println();
                ++count;
            }
        }
        return count;
    }
}
