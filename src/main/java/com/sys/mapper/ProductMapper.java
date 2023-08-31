package com.sys.mapper;
import com.sys.model.Product;
import com.sys.vo.ProductVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    //新增
    void add(ProductVO productVO);
    //删除
    void delete(int id);
    //修改
    void modify(ProductVO productVO);
    //查询
    List<Product> query(ProductVO productVO);
    //增加数量
    void addNum(ProductVO productVO);
    //减少数量
    void subNum(ProductVO productVO);
}
