package org.rainbow.mapper;

import org.rainbow.pojo.TbStaff;

public interface TbStaffMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(TbStaff record);

    int insertSelective(TbStaff record);

    TbStaff selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(TbStaff record);

    int updateByPrimaryKey(TbStaff record);
}