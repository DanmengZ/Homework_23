package com.sys.service;

import com.sys.mapper.CustomerMapper;
import com.sys.mapper.UserMapper;
import com.sys.model.Customer;
import com.sys.vo.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service
 */
@Service
public class CustomerService {
    private CustomerMapper customerMapper;//customerMapper
    private UserMapper userMapper;
    @Autowired
    public CustomerService(CustomerMapper customerMapper,UserMapper userMapper) {
        this.customerMapper = customerMapper;
        this.userMapper = userMapper;
    }
    public CustomerService() {
    }

    /**
     * 新增
     * @param customerVO
     */
    public void add(CustomerVO customerVO){
        customerMapper.add(customerVO);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(int id){
    	CustomerVO customerVO = new CustomerVO();
    	customerVO.setId(id);
    	Customer customer= query(customerVO).get(0);
    	int userId = customer.getUser().getId();
        customerMapper.delete(id);
        userMapper.delete(userId);
    }

    /**
     * 修改
     * @param customerVO
     */
    public void modify(CustomerVO customerVO){
        customerMapper.modify(customerVO);
    }

    /**
     * 查询
     * @param customerVO
     * @return
     */
    public List<Customer> query(CustomerVO customerVO){
        return customerMapper.query(customerVO);
    }
    
    public void modifyPwd(CustomerVO customerVO) {
    	customerMapper.modifyPwd(customerVO);
    }
    public double queryAccumulatedAmount(int recordId) {
    	return customerMapper.queryAccumulatedAmount(recordId);
    }
    public void modifyAccumulatedAmount(CustomerVO customerVO) {
    	customerMapper.modifyAccumulatedAmount(customerVO);
    }
}
