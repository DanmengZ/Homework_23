package com.sys.service;

import com.sys.mapper.ProductMapper;
import com.sys.model.Product;
import com.sys.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service
 */
@Service
public class ProductService {
    private ProductMapper productMapper;//productMapper
    @Autowired
    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
    public ProductService() {
    }

    /**
     * 新增
     * @param productVO
     */
    public void add(ProductVO productVO){
        productMapper.add(productVO);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(int id){
        productMapper.delete(id);
    }

    /**
     * 修改
     * @param productVO
     */
    public void modify(ProductVO productVO){
        productMapper.modify(productVO);
    }

    /**
     * 查询
     * @param productVO
     * @return
     */
    public List<Product> query(ProductVO productVO){
        return productMapper.query(productVO);
    }
    
    public void addNum(ProductVO productVO) {
    	productMapper.addNum(productVO);
    }
    public void subNum(ProductVO productVO) {
    	productMapper.subNum(productVO);
    }
}
