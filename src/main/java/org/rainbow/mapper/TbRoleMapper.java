package org.rainbow.mapper;

import java.util.List;

import org.rainbow.pojo.TbRole;
import org.rainbow.pojo.TbStaff;

public interface TbRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(TbRole record);

    int insertSelective(TbRole record);

    TbRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(TbRole record);

    int updateByPrimaryKey(TbRole record);
    
    List<TbRole> selectAll();

	List<TbRole> searchRole(String key);

	List<TbRole> selectAllWithoutStatus();
}