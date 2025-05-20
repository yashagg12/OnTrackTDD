package com.ontrack.yash;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;

public class TaskInboxTest {

    // ✅ Test 1: Add and retrieve two tasks for the same student
    @Test
    public void testAddAndGetTasks() {
        TaskInbox inbox = new TaskInbox();
        inbox.addTask("s123", "Task 1");
        inbox.addTask("s123", "Task 2");

        List<String> tasks = inbox.getTasks("s123");

        assertEquals(2, tasks.size());
        assertTrue(tasks.contains("Task 1"));
        assertTrue(tasks.contains("Task 2"));
    }

    // ✅ Test 2: Get tasks for a student with no submissions
    @Test
    public void testGetTasksForStudentWithNoTasks() {
        TaskInbox inbox = new TaskInbox();
        List<String> tasks = inbox.getTasks("s999");

        assertNotNull(tasks);
        assertTrue(tasks.isEmpty());
    }

    // ✅ Test 3: Add tasks for multiple students and verify separation
    @Test
    public void testMultipleStudents() {
        TaskInbox inbox = new TaskInbox();
        inbox.addTask("s123", "Math Homework");
        inbox.addTask("s456", "Science Project");

        List<String> tasks1 = inbox.getTasks("s123");
        List<String> tasks2 = inbox.getTasks("s456");

        assertEquals(1, tasks1.size());
        assertTrue(tasks1.contains("Math Homework"));

        assertEquals(1, tasks2.size());
        assertTrue(tasks2.contains("Science Project"));
    }
}
// hgvh