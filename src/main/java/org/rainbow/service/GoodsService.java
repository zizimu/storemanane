package org.rainbow.service;

import org.rainbow.pojo.TbGoods;

import java.util.List;
import java.util.Map;


public interface GoodsService {

	int addGoods(TbGoods goods);

	List<TbGoods> getAllGoods();

	TbGoods getGoodsByID(long ID);

	int deleteGoodsBystatus(long ID);

	int updateGoods(TbGoods goods);

	List<TbGoods> searchGoods(String key);

	Map<Long,String> getAllGoodsIdName();

}
