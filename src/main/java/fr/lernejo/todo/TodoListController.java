package fr.lernejo.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoListController {

    private TodoRepository repository;

    public TodoListController(TodoRepository repo){
        this.repository = repo;
    }

    @PostMapping("api/todo")
    public void post(@RequestBody TodoEntity todo){
        this.repository.save(todo);
    }

    @GetMapping("api/todo")
    public Iterable<TodoEntity> get()
    {
        return this.repository.findAll();
    }
}
