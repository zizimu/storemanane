package org.rainbow.service;

import org.rainbow.pojo.TbGoodsType;

import java.util.List;
import java.util.Map;

public interface TypeService {

	List<TbGoodsType> getAllType();

	int addType(TbGoodsType goodsType);

	TbGoodsType getTypeByID(long id);

	int updateType(TbGoodsType goodsType);

	List<TbGoodsType> searchType(String key);

	Map<Long, String> getAllTypeName();

	Map<Long, String> getAllUnits();
}
