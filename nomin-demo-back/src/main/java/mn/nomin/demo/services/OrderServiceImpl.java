package mn.nomin.demo.services;

import mn.nomin.demo.core.BaseServiceImpl;
import mn.nomin.demo.entities.Order;
import mn.nomin.demo.repositories.OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public JpaRepository<Order, Long> getRepo() {
        return orderRepository;
    }
}
