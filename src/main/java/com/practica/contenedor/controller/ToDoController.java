package com.practica.contenedor.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.contenedor.model.ToDo;

@RestController
@RequestMapping("/api/v1/task")
public class ToDoController {
    private List<ToDo> taskList = new ArrayList<ToDo>();

    @GetMapping
     public ResponseEntity<List<ToDo>> getAllTasks() {
        return ResponseEntity.ok(taskList);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<ToDo> getTaskById(@PathVariable Long taskId) {
    // Buscar la tarea con el taskId proporcionado en la lista de tareas
    for (ToDo task : taskList) {
        if (task.getTaskId().equals(taskId)) {
            return ResponseEntity.ok(task);
        }
    }
    
    // Si no se encuentra la tarea, devolver una respuesta 404 (no encontrado)
    return ResponseEntity.notFound().build();
}


@PostMapping
public ResponseEntity<String> createTask(@RequestBody ToDo newTask) {
    // Verificar si se proporciona un ID en la solicitud
    Long newTaskId = newTask.getTaskId();

    // Si el ID proporcionado es nulo o igual a cero, genera un nuevo ID aleatorio
    if (newTaskId == null || newTaskId == 0) {
        newTaskId = new Random().nextLong();
        newTask.setTaskId(newTaskId);
    }

    // Agregar la tarea a la lista de tareas
    taskList.add(newTask);

    // Devolver una respuesta con el ID generado o proporcionado
    return ResponseEntity.ok("Tarea creada con ID: " + newTaskId);
}


     @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
        // Buscar la tarea con el ID proporcionado y eliminarla si existe
        ToDo taskToRemove = null;
        for (ToDo task : taskList) {
            if (task.getTaskId().equals(taskId)) {
                taskToRemove = task;
                break;
            }
        }

        if (taskToRemove != null) {
            taskList.remove(taskToRemove);
            return ResponseEntity.ok("Tarea borrada con ID: " + taskId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
