package mn.nomin.demo.controllers;

import mn.nomin.demo.entities.Product;
import mn.nomin.demo.entities.Task;
import mn.nomin.demo.services.TaskService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/tasks")
@RestController
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Task>> getAll() {

        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{pKey}")
    public ResponseEntity<Task> get(@PathVariable("pKey") Long pKey) {
        Task res = service.get(pKey);
        return ResponseEntity.ok(res);
    }

    @PostMapping()
    public ResponseEntity<Task> save(@RequestBody Task req) {
        Task res = service.save(req);
        return ResponseEntity.ok(res);
    }

    @PutMapping()
    public ResponseEntity<Task> update(@RequestBody Task req) {
        service.update(req);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{pKey}")
    public ResponseEntity<?> delete(@PathVariable("pKey") Long pKey) {
        service.delete(pKey);
        return ResponseEntity.ok().build();
    }
}
