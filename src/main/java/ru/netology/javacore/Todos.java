package ru.netology.javacore;

import lombok.Getter;

import java.util.*;

public class Todos {

    @Getter
    static class Task {
        /*
         public enum type {
            ADD, REMOVE
        }*/
        private String type;
        private String task;

        Task(){};

        @Override
        public String toString() {
            return "Task [type=" + type + ", task=" + task + "]";
        }
    }

    private List <String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
        Collections.sort(tasks);
    }

    public void removeTask(String task) {

        tasks.remove(task);
    }

    public String getAllTasks() {

        return tasks.toString();
    }

    public String getTasksElementByIndex (int index) {

        return tasks.get(index);
    }

}
