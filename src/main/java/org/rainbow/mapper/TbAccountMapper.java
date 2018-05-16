package org.rainbow.mapper;

import org.rainbow.pojo.TbAccount;

import java.util.List;

public interface TbAccountMapper {
    int deleteByPrimaryKey(Long sid);

    int insert(TbAccount record);

    int insertSelective(TbAccount record);

    TbAccount selectByPrimaryKey(Long sid);

    int updateByPrimaryKeySelective(TbAccount record);

    int updateByPrimaryKey(TbAccount record);

    TbAccount selectByName(String name);

	List<TbAccount> selectAll();


}