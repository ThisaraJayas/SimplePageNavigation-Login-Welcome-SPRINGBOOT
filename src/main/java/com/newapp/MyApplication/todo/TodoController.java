package com.newapp.MyApplication.todo;

import com.newapp.MyApplication.todo.todoService.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping("list-todos")
    public String listTodos(ModelMap model){
        String username = getLoggedInUsername(model);
        List<Todo> todos = todoService.findByUsername(username);
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    private static String getLoggedInUsername(ModelMap model) {
        return (String) model.get("name");
    }

    @RequestMapping(value = "add-todos",method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        String username = getLoggedInUsername(model);
        Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        return "AddTodo";
    }
    @RequestMapping(value = "add-todos",method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()){
            return "AddTodo";
        }
        String username = getLoggedInUsername(model);
        todoService.addTodo(username,todo.getDescription(), todo.getTargetDate(),false);
        return "redirect:list-todos"; //redirect to previsly created list
    }
    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoService.deleteTodo(id);
        return "redirect:list-todos";
    }
    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model){
        Todo todo = todoService.findById(id);
        model.addAttribute("todo",todo);
        return "AddTodo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){

        if(result.hasErrors()){
            return "AddTodo";
        }
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }
    private String getLoggedInUsername(){
        Authentication authenticaton = SecurityContextHolder.getContext().getAuthentication();
        return authenticaton.getName();
    }


}
