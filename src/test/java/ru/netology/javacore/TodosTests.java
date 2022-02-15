package ru.netology.javacore;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodosTests {

    static Todos todos = null;

    @BeforeEach
    public void  init(){
        System.out.println("test started");
        todos = new Todos();
    }

    @BeforeAll
    public static void started(){
        System.out.println("tests started");
    }

    @AfterEach
    public void finished() {
        System.out.println("test completed");
    }

    @AfterAll
    public static void finishedAll(){
        System.out.println("tests completed");
    }

    @Test
    public void testAddTask() {
        //arrange
        String task = "Погулять", expected = "Погулять";
        //act
        todos.addTask(task);
        String result = todos.getTasksElementByIndex(0);
        //assert
        assertEquals(expected, result);
    }

    @Test
    public void testSortTasks() {
        //arrange
        String expected = "[Выучить уроки, Закрыть окно, Поспать, Умыться]";
        //act
        todos.addTask("Поспать");
        todos.addTask("Умыться");
        todos.addTask("Закрыть окно");
        todos.addTask("Выучить уроки");
        String result = todos.getAllTasks();
        //assert
        assertEquals(expected, result);
    }

    @Test
    public void testRemoveTask() {
        //arrange
        String expected = "[Выучить уроки, Поспать, Умыться]";
        //act
        todos.addTask("Поспать");
        todos.addTask("Умыться");
        todos.addTask("Закрыть окно");
        todos.addTask("Выучить уроки");
        todos.removeTask("Закрыть окно");
        String result = todos.getAllTasks();
        //assert
        assertEquals(expected, result);
    }
}
