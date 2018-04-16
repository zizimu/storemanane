package org.rainbow.mapper;

import java.util.List;

import org.rainbow.pojo.TbStaff;

public interface TbStaffMapper {
    int deleteByPrimaryKey(Long staffId);

    int insert(TbStaff record);

    int insertSelective(TbStaff record);

    TbStaff selectByPrimaryKey(Long staffId);

    int updateByPrimaryKeySelective(TbStaff record);

    int updateByPrimaryKey(TbStaff record);
    
    List<TbStaff> selectAll();
    
    List<TbStaff> searchStaff(String key);
}