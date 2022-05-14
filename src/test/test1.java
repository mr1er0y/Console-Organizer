package test;

import Task.Task;
import Task.Tasks;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class test1 {

    @Test
    public void test12() {
        Task myFirstTask = new Task("123abcABC", 0);
        Boolean taskIsNotDone = false;
        assertEquals(taskIsNotDone, myFirstTask.is_done);
    }
}