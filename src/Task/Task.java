package Task;

import java.util.Date;
import java.util.HashSet;

public final class Task {
    public int Id;
    public Date deadline;
    public String text;
    public HashSet<String> tags;
    public Boolean is_done;
    public int priority;

    public Task(String new_text, int Id, Date deadline) {
        this.Id = Id;
        this.text = new_text;
        this.deadline = deadline;
        this.tags = new HashSet<>();
        this.is_done = Boolean.FALSE;
        this.priority = 0;
    }

    public Task(String new_text, Date deadline, int Id, int priority) {
        this.Id = Id;
        this.text = new_text;
        this.deadline = deadline;
        this.tags = new HashSet<>();
        this.is_done = Boolean.FALSE;
        this.priority = priority;
    }


    public void editName(String new_name) {
        this.text = new_name;
    }

    public void editDeadline(Date new_deadline) {
        this.deadline = new_deadline;
    }

    public Task(int id) {
        Id = id;
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

    public HashSet<String> getTags() {
        return this.tags;
    }

    public String isDone() {
        if (is_done) {
            return "YES";
        }
        return "NO";
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }


    public void done() {
        this.is_done = Boolean.TRUE;
    }

}