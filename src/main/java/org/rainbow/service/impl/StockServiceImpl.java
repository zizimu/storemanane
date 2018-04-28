package org.rainbow.service.impl;

import org.rainbow.mapper.TbStockMapper;
import org.rainbow.pojo.TbStock;
import org.rainbow.pojo.TbStockKey;
import org.rainbow.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-04-17
 */
@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private TbStockMapper stockMapper;

	@Override
	public List<TbStock> getAllStock() {
		return stockMapper.selectAll();
	}

	@Override
	public int addStock(TbStock stock) {
		return stockMapper.insertSelective(stock);
	}

	@Override
	public TbStock getStockByID(TbStockKey id) {
		return stockMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateStock(TbStock stock) {
		return stockMapper.updateByPrimaryKeySelective(stock);
	}

	@Override
	public int deleteStock(TbStockKey id) {
		return stockMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<TbStock> searchStock(String key) {
		return stockMapper.searchStock(key);
	}

	@Override
	public List<Long> getAllBatch() {
		return stockMapper.getAllBatch();
	}

	@Override
	public boolean isGoodsByBatch(String batchId, String goodsId) {
		boolean rs = false;
		try {
			Long batch = Long.parseLong(batchId);
			Long goods = Long.parseLong(goodsId);
			TbStockKey temp = new TbStockKey();
			temp.setGoodsId(goods);
			temp.setBatchId(batch);
			if (getStockByID(temp) == null) {
				rs = true;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return rs;
		}
		return rs;
	}
}
