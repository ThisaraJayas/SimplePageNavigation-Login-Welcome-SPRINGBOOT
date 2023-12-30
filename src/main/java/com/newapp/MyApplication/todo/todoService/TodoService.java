package com.newapp.MyApplication.todo.todoService;

import com.newapp.MyApplication.todo.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todoCount = 0;
    static {
        todos.add(new Todo(++todoCount,"Thisara","new java course", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todoCount,"Mihindu","new spring course", LocalDate.now().plusYears(2),false));
        todos.add(new Todo(++todoCount,"Nimal","new kotlin course", LocalDate.now().plusYears(3),false));
        todos.add(new Todo(++todoCount,"Harry","new ruby course", LocalDate.now().plusYears(6),false));
        todos.add(new Todo(++todoCount,"Kamal","new flutter course", LocalDate.now().plusYears(2),false));
    }
    public List<Todo> findByUsername(String username){
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done ){
        ++todoCount;
        Todo todo = new Todo(++todoCount,username,description,targetDate,done);

    }

}
