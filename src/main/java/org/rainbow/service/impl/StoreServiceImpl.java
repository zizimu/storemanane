package org.rainbow.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.rainbow.mapper.TbStoreMapper;
import org.rainbow.pojo.TbGoods;
import org.rainbow.pojo.TbStore;
import org.rainbow.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private TbStoreMapper tbStoreMapper;

	@Override
	public int addStore(TbStore store) {

		return tbStoreMapper.insertSelective(store);
	}

	@Override
	public TbStore getStoreById(long ID) {

		return tbStoreMapper.selectByPrimaryKey(ID);
	}

	@Override
	public List<TbStore> searchStore(String key) {

		return tbStoreMapper.searchStore(key);

	}

	@Override
	public Map<Long, String> getAllStores() {
		Map<Long, String> result = new HashMap<>();
		List<TbStore> goods = tbStoreMapper.selectAllWithoutStatus();
		for (TbStore temp : goods) {
			result.put(temp.getStoreId(), temp.getStoreName());
		}
		return result;
	}

	@Override
	public List<TbStore> getAllStore() {
		return tbStoreMapper.selectAll();
	}

	@Override
	public int updateStore(TbStore store) {
		return tbStoreMapper.updateByPrimaryKeySelective(store);
	}

}
