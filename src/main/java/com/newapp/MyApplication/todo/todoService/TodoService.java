package com.newapp.MyApplication.todo.todoService;

import com.newapp.MyApplication.todo.Todo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
        Predicate<Todo> todoPredicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(todoPredicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done ){
        ++todoCount;
        Todo todo = new Todo(++todoCount,username,description,targetDate,done);
        todos.add(todo);

    }
    public void deleteTodo(int id){
        Predicate<Todo> todoPredicate = todo -> todo.getId() == id;
        todos.removeIf(todoPredicate);
    }
    public Todo findById(int id){
        Predicate<Todo> todoPredicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(todoPredicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo){
        deleteTodo(todo.getId());
        todos.add(todo);
    }

}
