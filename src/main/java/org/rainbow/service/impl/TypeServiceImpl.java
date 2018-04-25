package org.rainbow.service.impl;

import org.rainbow.mapper.TbGoodsTypeMapper;
import org.rainbow.pojo.TbGoodsType;
import org.rainbow.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public Map<Long, String> getAllTypeName() {
		Map<Long, String> result = new HashMap<>();
		List<TbGoodsType> types = typeMapper.getAllTypeName();
		for (TbGoodsType temp : types) {
			result.put(temp.getTypeId(), temp.getTypeName());
		}
		return result;
	}

	@Override
	public Map<Long, String> getAllUnits() {
		Map<Long, String> result = new HashMap<>();
		List<TbGoodsType> types = typeMapper.getAllTypeName();
		for (TbGoodsType temp : types) {
			result.put(temp.getTypeId(), temp.getUnits());
		}
		return result;
	}
}
