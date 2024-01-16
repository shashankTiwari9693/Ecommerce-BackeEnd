package shoppingServiceSpringBoot.shoppingServiceSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shoppingServiceSpringBoot.shoppingServiceSpringBoot.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
