package shoppingServiceSpringBoot.shoppingServiceSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoppingServiceSpringBoot.shoppingServiceSpringBoot.entity.Cart;
import shoppingServiceSpringBoot.shoppingServiceSpringBoot.repository.CartRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getAllCartItems() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartItemById(Long id) {
        return cartRepository.findById(id);
    }


    public Cart addToCart(Cart cartItem) {
        return cartRepository.save(cartItem);
    }

    public Optional<Cart> updateCartItem(Long id, Cart updatedCartItem) {
        Optional<Cart> existingCartItem = cartRepository.findById(id);

        if (existingCartItem.isPresent()) {
            Cart cartItem = existingCartItem.get();
            cartItem.setQuantity(updatedCartItem.getQuantity());

            return Optional.of(cartRepository.save(cartItem));
        }

        return Optional.empty();
    }

    public void removeFromCart(Long id) {
        cartRepository.deleteById(id);
    }


}