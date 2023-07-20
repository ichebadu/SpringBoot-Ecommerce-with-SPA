package com.NisRids.ecommerce.Service;

import com.NisRids.ecommerce.dto.AddToCartDto;
import com.NisRids.ecommerce.model.Cart;
import com.NisRids.ecommerce.model.Product;
import com.NisRids.ecommerce.model.User;
import com.NisRids.ecommerce.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public void addToCart(AddToCartDto addToCartDto, Product product, User uers){
        Cart cart = new Cart(product,addToCartDto.getQuantity(),uers);
        cartRepository.save(cart);
    }

}
