package org.rainbow.mapper;

import java.util.List;

import org.rainbow.pojo.TbActivity;

public interface TbActivityMapper {
    int deleteByPrimaryKey(Integer activityId);

    int insert(TbActivity record);

    int insertSelective(TbActivity record);

    TbActivity selectByPrimaryKey(Integer activityId);

    int updateByPrimaryKeySelective(TbActivity record);

    int updateByPrimaryKey(TbActivity record);
    
    List<TbActivity> selectAll();

	List<TbActivity> searchActivity(String key);
}