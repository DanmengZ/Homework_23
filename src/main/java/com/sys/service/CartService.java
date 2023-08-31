package com.sys.service;

import com.sys.mapper.CartMapper;
import com.sys.model.Cart;
import com.sys.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service
 */
@Service
public class CartService {
    private CartMapper cartMapper;//cartMapper
    @Autowired
    public CartService(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }
    public CartService() {
    }

    /**
     * 新增用户
     * @param cartVO
     */
    public int add(CartVO cartVO){
        return cartMapper.add(cartVO);
    }

    /**
     * 删除用户
     * @param cartId
     */
    public void delete(int cartId){
        cartMapper.delete(cartId);
    }

    /**
     * 修改用户
     * @param cartVO
     */
    public void modify(CartVO cartVO){
        cartMapper.modify(cartVO);
    }

    /**
     * 查询用户
     * @param cartVO
     * @return
     */
    public List<Cart> query(CartVO cartVO){
        return cartMapper.query(cartVO);
    }
    
    public void addCart(CartVO cartVO) {
    	cartMapper.addCart(cartVO);
    }
    
    public void subCart(CartVO cartVO) {
    	cartMapper.subCart(cartVO);
    }
    
    public double computeTotalAmount(int userId) {
    	double totalAmount = 0;
    	CartVO cartVO = new CartVO();
    	cartVO.setUserId(userId);
    	List<Cart> carts = cartMapper.query(cartVO);
    	for (Cart cart : carts) {
    		totalAmount += cart.getRetailPrice() * cart.getQuantity();
		}
    	return totalAmount;
    }
}
