package com.sys.mapper;
import com.sys.model.Customer;
import com.sys.vo.CustomerVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMapper {
    //新增
    void add(CustomerVO customerVO);
    //删除
    void delete(int id);
    //修改
    void modify(CustomerVO customerVO);
    //查询
    List<Customer> query(CustomerVO customerVO);
    //修改密码
    public void modifyPwd(CustomerVO customerVO);
    public double queryAccumulatedAmount(int recordId);
    //更新累计金额
    public void modifyAccumulatedAmount(CustomerVO customerVO);
}
