package org.rainbow.mapper;

import org.rainbow.pojo.TbParameter;

import java.util.List;

public interface TbParameterMapper {
    int deleteByPrimaryKey(Integer parameterid);

    int insert(TbParameter record);

    int insertSelective(TbParameter record);

    TbParameter selectByPrimaryKey(Integer parameterid);

    TbParameter selectByParameterName(String name);

    int updateByPrimaryKeySelective(TbParameter record);

    int updateByPrimaryKey(TbParameter record);

    List<TbParameter> selectAll();
}