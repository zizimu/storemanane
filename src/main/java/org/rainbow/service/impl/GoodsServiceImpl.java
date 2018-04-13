package org.rainbow.service.impl;

import org.rainbow.mapper.TbGoodsMapper;
import org.rainbow.pojo.TbGoods;
import org.rainbow.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-04-10
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private TbGoodsMapper tbGoodsMapper;

	@Override
	public int addGoods(TbGoods goods) {
		return tbGoodsMapper.insertSelective(goods);
	}

	@Override
	public List<TbGoods> getAllGoods() {
		return tbGoodsMapper.selectAll();
	}

	@Override
	public TbGoods getGoodsByID(long ID) {
		return tbGoodsMapper.selectByPrimaryKey(ID);
	}

	@Override
	public int deleteGoodsBystatus(long ID) {
		TbGoods goods = new TbGoods();
		goods.setGoodsId(ID);
		goods.setStatus(2);
		return tbGoodsMapper.updateByPrimaryKeySelective(goods);
	}

	@Override
	public int updateGoods(TbGoods goods) {
		return tbGoodsMapper.updateByPrimaryKeySelective(goods);
	}

	@Override
	public List<TbGoods> searchGoods(String key) {
		return tbGoodsMapper.searchGoods(key);
	}
}
