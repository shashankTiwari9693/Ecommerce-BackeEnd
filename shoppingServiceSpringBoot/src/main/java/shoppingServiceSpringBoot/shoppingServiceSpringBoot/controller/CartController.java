package shoppingServiceSpringBoot.shoppingServiceSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shoppingServiceSpringBoot.shoppingServiceSpringBoot.entity.Cart;
import shoppingServiceSpringBoot.shoppingServiceSpringBoot.entity.OrderItem;
import shoppingServiceSpringBoot.shoppingServiceSpringBoot.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public  List<Cart>getAllCartItem(){
        return cartService.getAllCartItems();
    }


    @PostMapping
    public Cart addToCart(@RequestBody Cart cartItem) {
        return cartService.addToCart(cartItem);
    }

    @DeleteMapping("/{cartId}")
    public void removeFromCart(@PathVariable Long cartId) {
        cartService.removeFromCart(cartId);
    }
}