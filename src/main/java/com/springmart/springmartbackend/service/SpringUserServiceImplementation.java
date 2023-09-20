package com.springmart.springmartbackend.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.springmart.springmartbackend.dao.SpringUserRepository;
import com.springmart.springmartbackend.dto.SpringUserRegistration;
import com.springmart.springmartbackend.dto.SpringUserDto;
import com.springmart.springmartbackend.entity.Cart;
import com.springmart.springmartbackend.entity.SpringUser;
import com.springmart.springmartbackend.entity.WishList;
import com.springmart.springmartbackend.exception.SpringUserNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SpringUserServiceImplementation implements SpringUserService {

    private SpringUserRepository springUserRepository;
    private CartServiceImplementation cartService;
    private WishListServiceImplementation wishListService;

    /**
     * CREATE USER (++ CREATE CART, CREATE WISHLIST)
     */
    @Override
    public SpringUser registerUser(SpringUserRegistration springUserRegistration) {
        SpringUser springUser = new SpringUser();
        springUser.setEmail(springUserRegistration.getEmail());
        springUser.setPassword(springUserRegistration.getPassword());
        springUser.setFirstName(springUserRegistration.getFirstName());
        springUser.setLastName(springUserRegistration.getLastName());
        springUser.setAddress(springUserRegistration.getAddress());
        springUser.setPostalCode(springUserRegistration.getPostalCode());
        springUser.setUnitNo(springUserRegistration.getUnitNo());
        springUser.setOptMarketing(springUserRegistration.isOptMarketing());
        springUser.setJoinDate(springUserRegistration.getJoinDate());

        springUser = springUserRepository.save(springUser);

        // CREATE CART
        Cart cart = new Cart();
        cartService.createCart(cart);

        // CREATE WISHLIST
        WishList wishList = new WishList();
        wishListService.createWishList(wishList, springUser.getId());

        return springUser;
    }

    /**
     * GET ALL USERS
     */
    @Override
    public List<SpringUser> getAllUsers() {
        List<SpringUser> allUsers = springUserRepository.findAll();
        return allUsers;
    }

    /**
     * GET ONE USER
     */
    @Override
    public SpringUser getUser(Long id) {
        SpringUser springUser = springUserRepository.findById(id)
                .orElseThrow(() -> new SpringUserNotFoundException(id));
        return springUser;
    }

    /**
     * UPDATE USER
     */
    @Override
    public SpringUser updateUser(Long id, SpringUserDto springUserDto) {
        SpringUser updateUser = springUserRepository.findById(id)
                .orElseThrow(() -> new SpringUserNotFoundException(id));
        updateUser.setEmail(springUserDto.getEmail());
        updateUser.setPassword(springUserDto.getPassword());
        updateUser.setFirstName(springUserDto.getFirstName());
        updateUser.setLastName(springUserDto.getLastName());
        updateUser.setAddress(springUserDto.getAddress());
        updateUser.setPostalCode(springUserDto.getPostalCode());
        updateUser.setUnitNo(springUserDto.getUnitNo());
        updateUser.setOptMarketing(springUserDto.isOptMarketing());
        updateUser.setJoinDate(springUserDto.getJoinDate());
        return updateUser;
    }

    /**
     * DELETE USER
     */
    @Override
    public void deleteUser(Long id) {
        springUserRepository.deleteById(id);
    }
}
