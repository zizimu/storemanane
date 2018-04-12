package org.rainbow.mapper;

import org.rainbow.pojo.TbActivityRange;
import org.rainbow.pojo.TbActivityRangeKey;

public interface TbActivityRangeMapper {
    int deleteByPrimaryKey(TbActivityRangeKey key);

    int insert(TbActivityRange record);

    int insertSelective(TbActivityRange record);

    TbActivityRange selectByPrimaryKey(TbActivityRangeKey key);

    int updateByPrimaryKeySelective(TbActivityRange record);

    int updateByPrimaryKey(TbActivityRange record);
}