package com.example.app.rest.Controller;

import com.example.app.rest.Model.Task;
import com.example.app.rest.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController
{
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping(value = "/")
    public String holaMundo()
    {
        return "Hola Mundo";
    }

    @GetMapping(value = "/tasks")
    public List<Task> getTasks()
    {
        return todoRepository.findAll();
    }

    @PostMapping(value = "/savetask")
    public String savetask(@RequestBody Task task)
    {
        todoRepository.save(task);
        return "saved task";
    }

    @PutMapping(value = "/update/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task)
    {
        Task updatedTask = todoRepository.findById(id).get();
        updatedTask.setTitulo(task.getTitulo());
        updatedTask.setDescripcion(task.getDescripcion());
        todoRepository.save(updatedTask);
        return "Updated task";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteTask(@PathVariable long id, @RequestBody Task task)
    {
        Task delete = todoRepository.findById(id).get();
        todoRepository.delete(delete);
        return "Deleted Task";
    }
}
