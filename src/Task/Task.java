package Task;

import java.util.Date;

public class Task {
    public Date deadline;
    public String text;
    public String[] tags;
    public Boolean is_don;

    public Task(String new_text) {
        this.text = new_text;
    }
    public Task() {
    }
}

