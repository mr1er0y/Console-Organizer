
import Task.Task;
import Task.Tasks;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TasksClassTest {

    @Test
    public void doneSort() {
//        Tasks myTasks = new Tasks();
//        myTasks.add("FirstTask");
//        myTasks.add("SecondTask");
//        myTasks.add("ThirdTask");
//        myTasks.done(0);
//        myTasks.done(2);
//        assertEquals(2, myTasks.doneSort().size());
    }

    @Test
    public void notDoneSort() {
//        Tasks myTasks = new Tasks();
//        myTasks.add("FirstTask");
//        myTasks.add("SecondTask");
//        myTasks.add("ThirdTask");
//        myTasks.done(0);
//        myTasks.done(2);
//        assertEquals(1, myTasks.notDoneSort().size());
    }

    @Test
    public void deadlineSort() {
//        Tasks myTasks = new Tasks();
//        String FirstTaskDeadline = "01/01/20 13:13";
//        myTasks.add("FirstTask", FirstTaskDeadline);
//        String SecondTaskDeadline = "01/01/10 12:12";
//        myTasks.add("SecondTask", SecondTaskDeadline);
//        String ThirdTaskDeadline = "01/05/15 14:14";
//        myTasks.add("ThirdTask", ThirdTaskDeadline);
//        assertEquals("SecondTask", myTasks.deadlineSort().get(0).getName());
//        assertEquals("ThirdTask", myTasks.deadlineSort().get(1).getName());
//        assertEquals("FirstTask", myTasks.deadlineSort().get(2).getName());
    }

    @Test
    public void tagSort() {
//        Tasks myTasks = new Tasks();
//        String firstTag = "Today", secondTag = "Tomorrow", ThirdTag = "Food";
//        myTasks.add("FirstTask");
//        myTasks.addTag(0, "Today");
//        myTasks.addTag(0, "Food");
//        myTasks.add("SecondTask");
//        myTasks.addTag(1, "Today");
//        myTasks.addTag(1, "Food");
//        myTasks.add("ThirdTask");
//        myTasks.addTag(2, "Tomorrow");
//        myTasks.add("FourthTask");
//        myTasks.addTag(3, "Tomorrow");
//        myTasks.addTag(3, "Food");
//        assertEquals(2, myTasks.tagSort("Today").size());
//        assertEquals(2, myTasks.tagSort("Tomorrow").size());
//        assertEquals(3, myTasks.tagSort("Food").size());
    }

    @Test
    public void delete() {
//        Tasks myTasks = new Tasks();
//        myTasks.add("FirstTask");
//        myTasks.add("SecondTask");
////        assertEquals(2, myTasks.notDoneSort().size());
//        myTasks.delete(1);
////        assertEquals(1, myTasks.notDoneSort().size());
//        myTasks.delete(0);
////        assertEquals(0, myTasks.notDoneSort().size());
    }

    @Test
    public void edit() {
//        Tasks myTasks = new Tasks();
//        String FirstTaskDeadline = "02/01/20 13:13";
//        myTasks.add("FirstTask", FirstTaskDeadline);
//        String SecondTaskDeadline = "02/01/10 12:12";
//        myTasks.add("SecondTask", SecondTaskDeadline);
//        String ThirdTaskDeadline = "02/05/15 14:14";
//        myTasks.add("ThirdTask", ThirdTaskDeadline);
////        assertEquals("SecondTask", myTasks.deadlineSort().get(0).getName());
////        assertEquals("ThirdTask", myTasks.deadlineSort().get(1).getName());
////        assertEquals("FirstTask", myTasks.deadlineSort().get(2).getName());
//        myTasks.edit(1, "d", ThirdTaskDeadline);
//        myTasks.edit(2, "d", SecondTaskDeadline);
////        assertEquals("ThirdTask", myTasks.deadlineSort().get(0).getName());
////        assertEquals("SecondTask", myTasks.deadlineSort().get(1).getName());
////        assertEquals("FirstTask", myTasks.deadlineSort().get(2).getName());
//        myTasks.edit(1, "n", "ThirdTask");
//        myTasks.edit(2, "n", "SecondTask");
////        assertEquals("SecondTask", myTasks.deadlineSort().get(0).getName());
////        assertEquals("ThirdTask", myTasks.deadlineSort().get(1).getName());
////        assertEquals("FirstTask", myTasks.deadlineSort().get(2).getName());
    }
}