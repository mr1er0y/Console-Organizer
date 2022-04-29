package Task;

import java.util.ArrayList;
import java.util.Date;

public class Task {
    public Date deadline;
    public String text;
    public ArrayList<String> tags;
    public Boolean is_don;

    public Task(String new_text) {
        this.text = new_text;
        this.is_don = Boolean.FALSE;
    }
    public Task(String new_text, Date deadline) {
        this.text = new_text;
        this.deadline = deadline;
        this.is_don = Boolean.FALSE;
    }

    public void edit_name(String new_name) {
        text = new_name;
    }

    public void edit_deadline(Date new_deadline) {
        deadline = new_deadline;
    }

    public void done() {
        is_don = Boolean.TRUE;
    }
}

