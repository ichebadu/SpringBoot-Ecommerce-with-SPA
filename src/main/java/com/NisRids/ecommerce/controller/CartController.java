package com.NisRids.ecommerce.controller;

import com.NisRids.ecommerce.Service.AuthenticationService;
import com.NisRids.ecommerce.Service.CartService;
import com.NisRids.ecommerce.Service.ProductService;
import com.NisRids.ecommerce.common.ApiResponse;
import com.NisRids.ecommerce.dto.AddToCartDto;
import com.NisRids.ecommerce.exceptions.AuthenticationFailException;
import com.NisRids.ecommerce.exceptions.ProductNotExistException;
import com.NisRids.ecommerce.model.Product;
import com.NisRids.ecommerce.model.User;
import com.NisRids.ecommerce.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    private final ProductService productService;
    private final AuthenticationService authenticationService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam("token") String token)
        throws AuthenticationFailException, ProductNotExistException, AuthenticationFailException {
            //first authenticate the token
            authenticationService.authenticate(token);

            //get the User
            User user = authenticationService.getUser(token);

            //find the product to add and add item by service
            Product product = productService.getProductById(addToCartDto.getProductId());
            cartService.addToCart(addToCartDto, product, user);

            return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
    }
}
