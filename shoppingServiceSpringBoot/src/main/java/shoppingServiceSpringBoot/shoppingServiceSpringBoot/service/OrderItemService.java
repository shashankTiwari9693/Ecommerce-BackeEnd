package shoppingServiceSpringBoot.shoppingServiceSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoppingServiceSpringBoot.shoppingServiceSpringBoot.entity.OrderItem;
import shoppingServiceSpringBoot.shoppingServiceSpringBoot.repository.OrderItemRepository;

import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public OrderItem updateOrderItem(Long id, OrderItem updatedOrderItem) {
        OrderItem existingOrderItem = getOrderItemById(id);

        if (existingOrderItem != null) {
            updatedOrderItem.setItemId(id);
            return orderItemRepository.save(updatedOrderItem);
        }

        return null;
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}