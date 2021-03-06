package org.rainbow.service;

import org.rainbow.pojo.TbBrand;

import java.util.List;
import java.util.Map;


public interface BrandService {

	List<TbBrand> getAllBrand();

	int addBrand(TbBrand brand);

	TbBrand getBrandByID(long id);

	int updateBrand(TbBrand brand);

	List<TbBrand> searchBrand(String key);

	Map<Long,String> getAllBrandName();
	
	TbBrand getTbBrandByname(String name);
}
