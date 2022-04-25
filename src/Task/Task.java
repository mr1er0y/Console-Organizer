package Task;

import java.util.ArrayList;
import java.util.Date;
import org.json.simple.JSONObject;

public class Task {
    public Date deadline;
    public String text;
    public ArrayList<String> tags;
    public Boolean is_done;

    public Task(String new_text) {
        this.text = new_text;
    }
    public Task() {

    }

    public SaveIntoJson() {
        JSONObject json = new JSONObject();
        
        json.put("deadline", this.deadline);
        json.put("text", this.text);
        json.put("tags", this.tags);
        json.put("is_done", this.is_done);

        return json;
    }
}

