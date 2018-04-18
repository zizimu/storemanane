package org.rainbow.mapper;

import java.util.List;

import org.rainbow.pojo.TbOrder;

public interface TbOrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(TbOrder record);

    int insertSelective(TbOrder record);

    TbOrder selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(TbOrder record);

    int updateByPrimaryKey(TbOrder record);

	List<TbOrder> searchOrder(String key);

	List<TbOrder> selectAll();
}