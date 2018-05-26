package org.rainbow.service.impl;

import java.util.List;

import org.rainbow.mapper.TbOrderMapper;
import org.rainbow.pojo.TbOrder;
import org.rainbow.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private TbOrderMapper tbOrderMapper;

	@Override
	public int addOrder(TbOrder order) {

		return tbOrderMapper.insertSelective(order);
	}

	@Override
	public TbOrder getOrderById(long ID) {

		return tbOrderMapper.selectByPrimaryKey(ID);
	}

	@Override
	public List<TbOrder> searchOrder(String key) {

		return tbOrderMapper.searchOrder(key);

	}

	@Override
	public List<TbOrder> getAllOrder() {
		return tbOrderMapper.selectAll();
	}


	@Override
	public int updateOrder(TbOrder order) {
		return tbOrderMapper.updateByPrimaryKeySelective(order);
	}

	@Override
	public List<TbOrder> findOrderBystoreid(Long store_id) {
		return tbOrderMapper.findOrderBystoreid(store_id);
	}

}
