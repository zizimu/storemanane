package org.rainbow.mapper;

import org.rainbow.pojo.TbStockManage;

public interface TbStockManageMapper {
    int deleteByPrimaryKey(Integer gid);

    int insert(TbStockManage record);

    int insertSelective(TbStockManage record);

    TbStockManage selectByPrimaryKey(Integer gid);

    int updateByPrimaryKeySelective(TbStockManage record);

    int updateByPrimaryKey(TbStockManage record);
}