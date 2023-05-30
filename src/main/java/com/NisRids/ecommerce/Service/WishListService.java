package com.NisRids.ecommerce.Service;

import com.NisRids.ecommerce.model.User;
import com.NisRids.ecommerce.model.WishList;
import com.NisRids.ecommerce.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {
    @Autowired
    private WishListRepository wishListRepository;

    public void createdWishList(WishList wishList){
        wishListRepository.save(wishList);
    }
    public List<WishList> readWishList(User user) {
        return wishListRepository.findAllByUserByOrderByCreatedDateDesc(user);
    }
}
