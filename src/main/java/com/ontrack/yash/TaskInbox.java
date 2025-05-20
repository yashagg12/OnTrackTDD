package com.ontrack.yash;

import java.util.*;

public class TaskInbox {
    private final Map<String, List<String>> studentTasks = new HashMap<>();

    public void addTask(String studentId, String taskName) {
        studentTasks.computeIfAbsent(studentId, k -> new ArrayList<>()).add(taskName);
    }

    public List<String> getTasks(String studentId) {
        return studentTasks.getOrDefault(studentId, new ArrayList<>());
    }
}
