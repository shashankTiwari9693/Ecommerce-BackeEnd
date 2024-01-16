package shoppingServiceSpringBoot.shoppingServiceSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shoppingServiceSpringBoot.shoppingServiceSpringBoot.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
