package org.rainbow.mapper;

import org.rainbow.pojo.TbPreact;

public interface TbPreactMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(TbPreact record);

    int insertSelective(TbPreact record);

    TbPreact selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(TbPreact record);

    int updateByPrimaryKey(TbPreact record);
}