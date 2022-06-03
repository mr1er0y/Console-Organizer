package Task;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

public  class Task {
    private  int Id;
    private Date deadline;
    private  String text;
    private Set<String> tags;
    private Boolean is_done;
    private int priority;

    public Task(String new_text, int Id, Date deadline, int priority) {
        this.Id = Id;
        this.text = new_text;
        this.deadline = deadline;
        this.tags = new HashSet<String>();
        this.is_done = Boolean.FALSE;

        this.priority = 0;

    }
    public Task(String new_text, int Id,  int priority) {
        this.Id = Id;
        this.text = new_text;
        this.tags = new HashSet<String>();
        this.is_done = Boolean.FALSE;

        this.priority = 0;

    }

    public Task(String new_text, Date deadline, int Id) {
        this.Id = Id;
        this.text = new_text;
        this.deadline = deadline;
        this.tags = new HashSet<String>();
        this.is_done = Boolean.FALSE;
    }

    public int getId() {
        return Id;
    }

    public void setId(int new_id) {
        Id = new_id;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date new_deadline) {
        deadline = new_deadline;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String new_text) {
        text = new_text;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void getTags(Set<String> new_tags) {
        tags = new_tags;
    }

    public Boolean getIsDone() {
        return is_done;
    }

    public void setIsDone(Boolean new_is_done) {
        is_done = new_is_done;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int new_priority) {
        priority = new_priority;
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