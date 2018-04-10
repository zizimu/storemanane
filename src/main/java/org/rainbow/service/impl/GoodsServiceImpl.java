package org.rainbow.service.impl;

import org.rainbow.mapper.TbGoodsMapper;
import org.rainbow.pojo.TbGoods;
import org.rainbow.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
