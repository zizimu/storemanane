package org.rainbow.service;

import java.util.List;
import java.util.Map;

import org.rainbow.pojo.TbStore;

public interface StoreService {

	int addStore(TbStore store);

	List<TbStore> getAllStore();

	TbStore getStoreById(long ID);

	int updateStore(TbStore store);

	List<TbStore> searchStore(String key);

	Map<Long,String> getAllStores();

}
