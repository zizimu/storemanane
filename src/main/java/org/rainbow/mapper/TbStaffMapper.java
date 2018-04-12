package org.rainbow.mapper;

import org.rainbow.pojo.TbStaff;

public interface TbStaffMapper {
    int deleteByPrimaryKey(Long staffId);

    int insert(TbStaff record);

    int insertSelective(TbStaff record);

    TbStaff selectByPrimaryKey(Long staffId);

    int updateByPrimaryKeySelective(TbStaff record);

    int updateByPrimaryKey(TbStaff record);
}