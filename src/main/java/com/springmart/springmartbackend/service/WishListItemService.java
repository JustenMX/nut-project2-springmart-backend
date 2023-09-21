package com.springmart.springmartbackend.service;

import java.util.List;

import com.springmart.springmartbackend.entity.WishList;
import com.springmart.springmartbackend.entity.WishListItem;

public interface WishListItemService {


    /**
     * CREATE WISHLIST ITEM UPON ADD WISHLIST
     * 
     * @return
     */

    WishListItem createWishListItem(WishListItem wishListItem);

    /**
     * GET ALL WISHLIST ITEMS FOR ADMIN
     * 
     * 
     * @return
     */
    List<WishListItem> getAllWishListItem();


    /**
     * GET WISHLIST ITEM BASE ON THE ID
     * 
     * @return
     */
    WishListItem getWishListItem(Long id);

     /**
     * GET WISHLIST ITEM BASE ON THE USERID/WISHLISTID
     * 
     * @return
     */



    /**
     * DELETE WISHLIST ITEM BASE ON THE ID
     * 
     * @return
     */

     void deleteWishListItem(Long id);

     




    
    
}