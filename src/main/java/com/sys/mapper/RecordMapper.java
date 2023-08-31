package com.sys.mapper;
import com.sys.model.Record;
import com.sys.vo.RecordVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordMapper {
    //新增用户
    int add(RecordVO recordVO);
    //删除用户
    void delete(int recordId);
    //修改
    void modify(RecordVO recordVO);
    //查询
    List<Record> query(RecordVO recordVO);
}
