package org.rainbow.service;

import org.rainbow.pojo.TbGoods;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-04-10
 */
public interface GoodsService {

	int addGoods(TbGoods goods);

	List<TbGoods> getAllGoods();

	TbGoods getGoodsByID(long ID);

	int deleteGoodsBystatus(long ID);

	int updateGoods(TbGoods goods);
}
