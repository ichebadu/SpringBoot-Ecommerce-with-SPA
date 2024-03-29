package com.NisRids.ecommerce.controller;

import com.NisRids.ecommerce.Service.AuthenticationService;
import com.NisRids.ecommerce.Service.WishListService;
import com.NisRids.ecommerce.common.ApiResponse;
import com.NisRids.ecommerce.dto.ProductDto;
import com.NisRids.ecommerce.exceptions.AuthenticationFailException;
import com.NisRids.ecommerce.model.Product;
import com.NisRids.ecommerce.model.User;
import com.NisRids.ecommerce.model.WishList;
import com.NisRids.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WishListController {

    private final WishListService wishListService;

    private final AuthenticationService authenticationService;

    private final ProductRepository productRepository;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addWishList(@RequestBody ProductDto productDto, @RequestParam("token") String token) throws AuthenticationFailException {

        authenticationService.authenticate(token);

        User user = authenticationService.getUser(token);

        Product product = productRepository.getById(productDto.getId());
        WishList wishList = new WishList(user, product);

        wishListService.createdWishList(wishList);

        return new ResponseEntity<>(new ApiResponse(true,"Added to wishlist"), HttpStatus.CREATED);
    }
}
