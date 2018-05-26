package org.rainbow.service;

import org.rainbow.pojo.TbStock;
import org.rainbow.pojo.TbStockKey;

import java.util.List;

public interface StockService {

	List<TbStock> getAllStock();

	List<TbStock> getAllStockByStoreID(Long storeId);

	int addStock(TbStock stock);

	TbStock getStockByID(Long goodid);

	int updateStock(TbStock stock);

	int deleteStock(TbStockKey id);

	List<TbStock> searchStock(String key);

	List<TbStock> searchStockInStore(String key,Long storeID);

	List<Long> getAllBatch();
	
	TbStock findStockBygoodid(Long goodid,Long storeId);
	
	 void updateStockBygoodsid(TbStock tbStock);

	/**
	 *
	 * @param batchId
	 * @param goodsId
	 * Description:是否[batchID]下存在[goodsId]
	 * @return
	 */
	//boolean isGoodsByBatch(String batchId ,String goodsId);
}
