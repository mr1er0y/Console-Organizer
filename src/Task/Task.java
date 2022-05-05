package Task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;


public class Task {
    public int Id;
    public Date deadline;
    public String text;
    public ArrayList<String> tags;
    public Boolean is_done;

    public Task(String new_text, int Id) {
        this.text = new_text;
        this.is_done = Boolean.FALSE;
        this.Id = Id;
    }
    public Task(String new_text, Date deadline, int Id) {
        this.text = new_text;
        this.deadline = deadline;
        this.is_done = Boolean.FALSE;
        this.Id = Id;
    }

    public void edit_name(String new_name) {
        text = new_name;
    }

    public void edit_deadline(Date new_deadline) {
        deadline = new_deadline;
    }

    public Task() { }

    public String isDone() {
        if (is_done) {
            return "YES";
        }
        return "NO";
    }


    public void done() {
        is_done = Boolean.TRUE;
    }

     public JSONObject SaveIntoJson() {
        JSONObject json = new JSONObject();
        
        json.put("deadline", this.deadline);
        json.put("text", this.text);
        json.put("tags", this.tags);
        json.put("is_done", this.is_done);

        return json;
    }
}

