package org.rainbow.service.impl;

import org.rainbow.mapper.TbGoodsMapper;
import org.rainbow.mapper.TbGoodsTypeMapper;
import org.rainbow.pojo.TbGoodsType;
import org.rainbow.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-04-16
 */
@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TbGoodsTypeMapper typeMapper;


	@Override
	public List<TbGoodsType> getAllType() {
		return typeMapper.selectAll();
	}

	@Override
	public int addType(TbGoodsType goodsType) {
		return typeMapper.insertSelective(goodsType);
	}

	@Override
	public TbGoodsType getTypeByID(long id) {
		return typeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateType(TbGoodsType goodsType) {
		return typeMapper.updateByPrimaryKeySelective(goodsType);
	}

	@Override
	public List<TbGoodsType> searchType(String key) {
		return typeMapper.searchType(key);
	}
}