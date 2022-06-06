import Task.Tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TasksClassTest {

    @Test
    public void doneSort() {
          Tasks myTasks = new Tasks();
          myTasks.add("FirstTask");
          myTasks.add("SecondTask");
          myTasks.add("ThirdTask");
          myTasks.done(0);
          myTasks.done(2);
          assertEquals(2, myTasks.doneSort());
    }

    @Test
    public void notDoneSort() {
          Tasks myTasks = new Tasks();
          myTasks.add("FirstTask");
          myTasks.add("SecondTask");
          myTasks.add("ThirdTask");
          myTasks.done(0);
          myTasks.done(2);
          assertEquals(1, myTasks.notDoneSort());
    }

    @Test
    public void deadlineSort() {
          Tasks myTasks = new Tasks();
          String FirstTaskDeadline = "01/01/20 13:13";
          myTasks.add("FirstTask", FirstTaskDeadline, "0");
          String SecondTaskDeadline = "01/01/10 12:12";
          myTasks.add("SecondTask", SecondTaskDeadline, "0");
          String ThirdTaskDeadline = "01/05/15 14:14";
          myTasks.add("ThirdTask", ThirdTaskDeadline, "0");
          assertEquals("SecondTask", myTasks.deadlineSort().get(0).getText());
          assertEquals("ThirdTask", myTasks.deadlineSort().get(1).getText());
          assertEquals("FirstTask", myTasks.deadlineSort().get(2).getText());
    }

    @Test
    public void tagSort() {
          Tasks myTasks = new Tasks();
          String firstTag = "Today", secondTag = "Tomorrow", ThirdTag = "Food";
          myTasks.add("FirstTask");
          myTasks.addTag(0, "Today");
          myTasks.addTag(0, "Food");
          myTasks.add("SecondTask");
          myTasks.addTag(1, "Today");
          myTasks.addTag(1, "Food");
          myTasks.add("ThirdTask");
          myTasks.addTag(2, "Tomorrow");
          myTasks.add("FourthTask");
          myTasks.addTag(3, "Tomorrow");
          myTasks.addTag(3, "Food");
          assertEquals(2, myTasks.tagSort("Today"));
          assertEquals(2, myTasks.tagSort("Tomorrow"));
          assertEquals(3, myTasks.tagSort("Food"));
    }

    @Test
    public void delete() {
          Tasks myTasks = new Tasks();
          myTasks.add("FirstTask");
          myTasks.add("SecondTask");
          assertEquals(2, myTasks.notDoneSort());
          myTasks.delete(1);
          assertEquals(1, myTasks.notDoneSort());
          myTasks.delete(0);
          assertEquals(0, myTasks.notDoneSort());
    }

    @Test
    public void edit() {
          Tasks myTasks = new Tasks();
          String FirstTaskDeadline = "02/01/20 13:13";
          myTasks.add("FirstTask", FirstTaskDeadline,"0");
          String SecondTaskDeadline = "02/01/10 12:12";
          myTasks.add("SecondTask", SecondTaskDeadline,"0");
          String ThirdTaskDeadline = "02/05/15 14:14";
          myTasks.add("ThirdTask", ThirdTaskDeadline,"0");
          assertEquals("SecondTask", myTasks.deadlineSort().get(0).getText());
          assertEquals("ThirdTask", myTasks.deadlineSort().get(1).getText());
          assertEquals("FirstTask", myTasks.deadlineSort().get(2).getText());
          myTasks.edit(1, "d", ThirdTaskDeadline);
          myTasks.edit(2, "d", SecondTaskDeadline);
          assertEquals("ThirdTask", myTasks.deadlineSort().get(0).getText());
          assertEquals("SecondTask", myTasks.deadlineSort().get(1).getText());
          assertEquals("FirstTask", myTasks.deadlineSort().get(2).getText());
          myTasks.edit(1, "n", "ThirdTask");
          myTasks.edit(2, "n", "SecondTask");
          assertEquals("SecondTask", myTasks.deadlineSort().get(0).getText());
          assertEquals("ThirdTask", myTasks.deadlineSort().get(1).getText());
          assertEquals("FirstTask", myTasks.deadlineSort().get(2).getText());
    }
}
