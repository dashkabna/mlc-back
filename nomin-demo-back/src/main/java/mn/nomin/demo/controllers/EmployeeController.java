package mn.nomin.demo.controllers;

import mn.nomin.demo.entities.Employee;
import mn.nomin.demo.entities.Order;
import mn.nomin.demo.services.EmployeeService;

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

@RequestMapping("/employees")
@RestController
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAll() {

        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{pKey}")
    public ResponseEntity<Employee> get(@PathVariable("pKey") Long pKey) {
        Employee res = service.get(pKey);
        return ResponseEntity.ok(res);
    }

    @PostMapping()
    public ResponseEntity<Employee> save(@RequestBody Employee req) {
        Employee res = service.save(req);
        return ResponseEntity.ok(res);
    }

    @PutMapping()
    public ResponseEntity<Employee> update(@RequestBody Employee req) {
        service.update(req);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{pKey}")
    public ResponseEntity<?> delete(@PathVariable("pKey") Long pKey) {
        service.delete(pKey);
        return ResponseEntity.ok().build();
    }
}
