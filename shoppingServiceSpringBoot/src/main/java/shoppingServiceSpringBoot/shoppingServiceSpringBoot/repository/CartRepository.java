package shoppingServiceSpringBoot.shoppingServiceSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shoppingServiceSpringBoot.shoppingServiceSpringBoot.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
