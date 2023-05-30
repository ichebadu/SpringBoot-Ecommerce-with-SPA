package com.NisRids.ecommerce.repository;

import com.NisRids.ecommerce.model.User;
import com.NisRids.ecommerce.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface WishListRepository extends JpaRepository <WishList, Long> {
    List<WishList> findAllByUserByOrderByCreatedDateDesc(User user);
}