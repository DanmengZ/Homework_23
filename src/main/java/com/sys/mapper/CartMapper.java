package com.sys.mapper;
import com.sys.model.Cart;
import com.sys.vo.CartVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartMapper {
    //新增用户
    int add(CartVO cartVO);
    //删除用户
    void delete(int cartId);
    //修改
    void modify(CartVO cartVO);
    //查询
    List<Cart> query(CartVO cartVO);
    //增加购物车
    void addCart(CartVO cartVO);
    //移除购物车
    void subCart(CartVO cartVO);
    //计算购物车总金额
    double computeTotalAmount(int userId);
}
