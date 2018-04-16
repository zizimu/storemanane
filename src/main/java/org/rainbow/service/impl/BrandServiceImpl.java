package org.rainbow.service.impl;

import org.rainbow.mapper.TbBrandMapper;
import org.rainbow.pojo.TbBrand;
import org.rainbow.service.BrandService;
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
public class BrandServiceImpl implements BrandService {
	@Autowired
	private TbBrandMapper brandMapper;

	@Override
	public List<TbBrand> getAllBrand() {
		return brandMapper.selectAll();
	}

	@Override
	public int addBrand(TbBrand brand) {
		return brandMapper.insert(brand);
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
}
