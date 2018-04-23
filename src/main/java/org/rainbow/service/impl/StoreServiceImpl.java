package org.rainbow.service.impl;

import java.util.List;

import org.rainbow.mapper.TbStoreMapper;
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
	public List<TbStore> getAllStore() {
		return tbStoreMapper.selectAll();
	}

	@Override
	public int updateStore(TbStore store) {
		return tbStoreMapper.updateByPrimaryKeySelective(store);
	}

}
