package org.rainbow.service.impl;

import org.rainbow.mapper.TbGoodsMapper;
import org.rainbow.pojo.TbBrand;
import org.rainbow.pojo.TbGoods;
import org.rainbow.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

	@Override
	public Map<Long, String> getAllGoodsIdName() {
		Map<Long, String> result = new HashMap<>();
		List<TbGoods> goods = tbGoodsMapper.getAllGoodsIdName();
		for (TbGoods temp : goods) {
			result.put(temp.getGoodsId(), temp.getGoodsName());
		}
		return result;
	}

}
