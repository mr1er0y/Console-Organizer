package test;

import Task.Task;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TaskClassTest {

    @Test
    public void create() {
        ArrayList<String> EmptyTaskTags = new ArrayList<>();

        Date DateFirstTask = new Date(1499995447000L);
        Task FirstTask = new Task("FirstTaskName", 0, DateFirstTask);
        assertEquals(0, FirstTask.getId());
        assertEquals("FirstTaskName", FirstTask.getName());
        assertEquals(EmptyTaskTags, FirstTask.getTags());
        assertEquals("NO", FirstTask.isDone());

        Date DateSecondTask = new Date(1499995447000L);
        Task SecondTask = new Task("SecondTaskName", DateSecondTask, 1, 0);
        assertEquals(1, SecondTask.getId());
        assertEquals(DateSecondTask, SecondTask.getDeadline());
        assertEquals("SecondTaskName", SecondTask.getName());
        assertEquals(EmptyTaskTags, SecondTask.getTags());
        assertEquals("NO", SecondTask.isDone());
    }

    @Test
    public void edit() {
        Date DateSecondTask = new Date(1499995447000L);
        Task FirstTask = new Task("FirstTaskName", DateSecondTask, 1, 0);

        Date NewDateFirstTask = new Date(1451665447567L);
        FirstTask.editDeadline(NewDateFirstTask);
        assertEquals(NewDateFirstTask, FirstTask.getDeadline());

        FirstTask.editName("123ABC!abc_edit");
        assertEquals("123ABC!abc_edit", FirstTask.getName());

        FirstTask.done();
        assertEquals("YES", FirstTask.isDone());

        ArrayList<String> FirstTaskTags = new ArrayList<>();
        assertEquals(FirstTaskTags, FirstTask.getTags());
        FirstTask.addTag("first_tag");
        FirstTaskTags.add("first_tag");
        assertEquals(FirstTaskTags, FirstTask.getTags());
        FirstTask.addTag("second_tag");
        FirstTaskTags.add("second_tag");
        assertEquals(FirstTaskTags, FirstTask.getTags());
    }
}