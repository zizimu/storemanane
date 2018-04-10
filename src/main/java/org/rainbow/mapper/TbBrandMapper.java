package org.rainbow.mapper;

import org.rainbow.pojo.TbBrand;

public interface TbBrandMapper {
    int deleteByPrimaryKey(Long brandid);

    int insert(TbBrand record);

    int insertSelective(TbBrand record);

    TbBrand selectByPrimaryKey(Long brandid);

    int updateByPrimaryKeySelective(TbBrand record);

    int updateByPrimaryKey(TbBrand record);
}