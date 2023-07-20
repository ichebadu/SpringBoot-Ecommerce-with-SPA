package com.NisRids.ecommerce.Service;

import com.NisRids.ecommerce.model.User;
import com.NisRids.ecommerce.model.WishList;
import com.NisRids.ecommerce.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final WishListRepository wishListRepository;

    public void createdWishList(WishList wishList){
        wishListRepository.save(wishList);
    }
    public List<WishList> readWishList(User user) {
        return wishListRepository.findAllByUserOrderByCreatedDateDesc(user);
    }
}
