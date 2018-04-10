package org.rainbow.mapper;

import org.rainbow.pojo.TbStore;

public interface TbStoreMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(TbStore record);

    int insertSelective(TbStore record);

    TbStore selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(TbStore record);

    int updateByPrimaryKey(TbStore record);
}