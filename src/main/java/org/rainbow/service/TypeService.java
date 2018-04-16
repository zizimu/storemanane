package org.rainbow.service;

import org.rainbow.pojo.TbGoodsType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-04-16
 */
public interface TypeService {

	List<TbGoodsType> getAllType();

	int addType(TbGoodsType goodsType);

	TbGoodsType getTypeByID(long id);

	int updateType(TbGoodsType goodsType);

	List<TbGoodsType> searchType(String key);
}
