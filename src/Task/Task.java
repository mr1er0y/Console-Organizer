package Task;

import java.util.ArrayList;
import java.util.Date;
import org.json.JSONObject;


public class Task {
    public Date deadline;
    public String text;
    public ArrayList<String> tags;
    public Boolean is_done;

    public Task(String new_text) {
        this.text = new_text;
        this.is_done = Boolean.FALSE;
    }
    public Task(String new_text, Date deadline) {
        this.text = new_text;
        this.deadline = deadline;
        this.is_done = Boolean.FALSE;
    }

    public void edit_name(String new_name) {
        text = new_name;
    }

    public void edit_deadline(Date new_deadline) {
        deadline = new_deadline;
    }

    public Task() { }


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

