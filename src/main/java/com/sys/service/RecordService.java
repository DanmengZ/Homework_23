package com.sys.service;

import com.sys.mapper.RecordMapper;
import com.sys.model.Record;
import com.sys.vo.RecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service
 */
@Service
public class RecordService {
    private RecordMapper recordMapper;//recordMapper
    @Autowired
    public RecordService(RecordMapper recordMapper) {
        this.recordMapper = recordMapper;
    }
    public RecordService() {
    }

    /**
     * 新增用户
     * @param recordVO
     */
    public int add(RecordVO recordVO){
        return recordMapper.add(recordVO);
    }

    /**
     * 删除用户
     * @param recordId
     */
    public void delete(int recordId){
        recordMapper.delete(recordId);
    }

    /**
     * 修改用户
     * @param recordVO
     */
    public void modify(RecordVO recordVO){
        recordMapper.modify(recordVO);
    }

    /**
     * 查询用户
     * @param recordVO
     * @return
     */
    public List<Record> query(RecordVO recordVO){
        return recordMapper.query(recordVO);
    }
    
    
}
