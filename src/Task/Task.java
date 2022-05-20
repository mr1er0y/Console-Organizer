package Task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class Task {
    public int Id;
    public Date deadline;
    public String text;
    public ArrayList<String> tags;
    public Boolean is_done;

    public Task(String new_text, int Id) {
        this.Id = Id;
        this.text = new_text;
        this.tags = new ArrayList<>();
        this.is_done = Boolean.FALSE;
    }

    public Task(String new_text, Date deadline, int Id) {
        this.Id = Id;
        this.deadline = deadline;
        this.text = new_text;
        this.tags = new ArrayList<>();
        this.is_done = Boolean.FALSE;
    }

    public void edit_name(String new_name) {
        this.text = new_name;
    }

    public void edit_deadline(Date new_deadline) {
        this.deadline = new_deadline;
    }

    public Task() {
    }

    public int getId() {
        return this.Id;
    }

    public Date getDeadline() {
        return this.deadline;
    }

    public String getName() {
        return this.text;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public String isDone() {
        if (is_done) {
            return "YES";
        }
        return "NO";
    }

    public void add_tag(String tag) {
        this.tags.add(tag);
    }


    public void done() {
        this.is_done = Boolean.TRUE;
    }

}