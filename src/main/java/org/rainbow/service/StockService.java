package org.rainbow.service;

import org.rainbow.pojo.TbStock;
import org.rainbow.pojo.TbStockKey;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-04-17
 */
public interface StockService {

	List<TbStock> getAllStock();

	int addStock(TbStock stock);

	TbStock getStockByID(TbStockKey id);

	int updateStock(TbStock stock);

	List<TbStock> searchStock(String key);

	List<Long> getAllBatch();
}
