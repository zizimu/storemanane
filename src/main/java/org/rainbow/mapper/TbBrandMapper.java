package org.rainbow.mapper;

import org.rainbow.pojo.TbBrand;

public interface TbBrandMapper {
    int deleteByPrimaryKey(Long brandId);

    int insert(TbBrand record);

    int insertSelective(TbBrand record);

    TbBrand selectByPrimaryKey(Long brandId);

    int updateByPrimaryKeySelective(TbBrand record);

    int updateByPrimaryKey(TbBrand record);
}