package org.rainbow.service.impl;

import org.rainbow.mapper.TbBrandMapper;
import org.rainbow.pojo.TbBrand;
import org.rainbow.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class BrandServiceImpl implements BrandService {
	@Autowired
	private TbBrandMapper brandMapper;

	@Override
	public List<TbBrand> getAllBrand() {
		return brandMapper.selectAll();
	}

	@Override
	public int addBrand(TbBrand brand) {
		return brandMapper.insertSelective(brand);
	}

	@Override
	public TbBrand getBrandByID(long id) {
		return brandMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateBrand(TbBrand brand) {
		return brandMapper.updateByPrimaryKeySelective(brand);
	}

	@Override
	public List<TbBrand> searchBrand(String key) {
		return brandMapper.searchBrand(key);
	}

	@Override
	public Map<Long, String> getAllBrandName() {
		Map<Long, String> result = new HashMap<>();
		List<TbBrand> brands = brandMapper.getAllBrandName();
		for (TbBrand temp : brands) {
			result.put(temp.getBrandId(), temp.getBrandName());
		}
		return result;
	}

	@Override
	public TbBrand getTbBrandByname(String name) {
		return brandMapper.getTbBrandByname(name);
	}
}
