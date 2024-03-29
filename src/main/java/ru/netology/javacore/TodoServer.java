package ru.netology.javacore;

import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {

    public TodoServer(int port, Todos todos) throws IOException {

        while (true) {
            try (
                    ServerSocket serverSocket = new ServerSocket(port);
                    Socket clientSocket = serverSocket.accept();
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            ) {
                System.out.printf("New connection accepted. Port: %d%n", clientSocket.getPort());
                String json = in.readLine();
                Todos.Task task = new Gson().fromJson(json, Todos.Task.class);

                if ("ADD".equals(task.getType())) {
                    todos.addTask(task.getTask());
                } else if ("REMOVE".equals(task.getType())) {
                    todos.removeTask(task.getTask());
                }
                System.out.println(task);
                out.println(todos.getAllTasks());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

    }

    public void start() throws IOException {
        int port = 8989;
        System.out.println("Starting server at " + port + "...");
    }
}
