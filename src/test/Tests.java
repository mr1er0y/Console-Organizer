package test;

import Task.Task;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    @Test
    public void TestAdd() {
      ArrayList<Task> task_list = new ArrayList<>();
      task_list.add(new Task("save", 0));
      assertEquals(task_list.get(0).is_done, false);
      assertEquals(task_list.size(), 1);
    }
  
}