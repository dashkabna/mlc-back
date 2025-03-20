package mn.nomin.demo.controllers;

import mn.nomin.demo.entities.Order;
import mn.nomin.demo.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/orders")
@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService service) {
        this.orderService = service;
    }

    @GetMapping()
    public ResponseEntity<List<Order>> getAll() {

        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/{pKey}")
    public ResponseEntity<Order> get(@PathVariable("pKey") Long pKey) {
        Order res = orderService.get(pKey);
        return ResponseEntity.ok(res);
    }

    @PostMapping()
    public ResponseEntity<Order> save(@RequestBody Order req) {
        Order res = orderService.save(req);
        return ResponseEntity.ok(res);
    }

    @PutMapping()
    public ResponseEntity<Order> update(@RequestBody Order req) {
        orderService.update(req);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{pKey}")
    public ResponseEntity<?> delete(@PathVariable("pKey") Long pKey) {
        orderService.delete(pKey);
        return ResponseEntity.ok().build();
    }

}
