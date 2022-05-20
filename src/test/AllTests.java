package test;

import Task.Task;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class AllTests {

    @Test
    public void TestClassTask() {
        ArrayList<String> EmptyTaskTags = new ArrayList<>();

        Task FirstTask = new Task("FirstTaskName", 0);
        assertEquals(0, FirstTask.getId());
        assertEquals("FirstTaskName", FirstTask.getName());
        assertEquals(EmptyTaskTags, FirstTask.getTags());
        assertEquals(false, FirstTask.is_done);

        FirstTask.edit_name("123ABC!abc_edit");
        assertEquals("123ABC!abc_edit", FirstTask.getName());

        Date NewDateFirstTask = new Date(1451665447567L);
        FirstTask.edit_deadline(NewDateFirstTask);
        assertEquals(NewDateFirstTask, FirstTask.getDeadline());

        Date DateSecondTask = new Date(1499995447000L);
        Task SecondTask = new Task("SecondTaskName", DateSecondTask, 1);
        assertEquals(1, SecondTask.getId());
        assertEquals(DateSecondTask, SecondTask.getDeadline());
        assertEquals("SecondTaskName", SecondTask.getName());
        assertEquals(EmptyTaskTags, SecondTask.getTags());
        assertEquals(false, SecondTask.is_done);

        SecondTask.done();
        assertEquals(true, SecondTask.is_done);

        ArrayList<String> SecondTaskTags = new ArrayList<>();
        assertEquals(SecondTaskTags, SecondTask.getTags());
        SecondTask.add_tag("first_tag");
        SecondTaskTags.add("first_tag");
        assertEquals(SecondTaskTags, SecondTask.getTags());
        SecondTask.add_tag("second_tag");
        SecondTaskTags.add("second_tag");
        assertEquals(SecondTaskTags, SecondTask.getTags());
    }
}