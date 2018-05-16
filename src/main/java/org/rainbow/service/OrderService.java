package org.rainbow.service;

import java.util.List;

import org.rainbow.pojo.TbOrder;

public interface OrderService {
	int addOrder(TbOrder order);

	List<TbOrder> getAllOrder();

	TbOrder getOrderById(long ID);

	int updateOrder(TbOrder order);

	List<TbOrder> searchOrder(String key);

}
