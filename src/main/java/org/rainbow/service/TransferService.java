package org.rainbow.service;

import org.rainbow.pojo.TbGoods;
import org.rainbow.pojo.TbTransfer;

import java.util.List;
import java.util.Map;


public interface TransferService{
	
	int addTransfer(TbTransfer transfer);
	
	 List<TbTransfer> findAllCheckTransfer();
	 
	 TbTransfer findCheckTransfer(Long transfer_id);
	 
	 void updateTransfer(TbTransfer transfer);

	/*int insertNew(TbTransfer transfer);

	List<TbTransfer> getAllTransfer();

	Map<Long,String> getAllStatus();

	TbTransfer getTransferByID(long ID);//更新需要

	int updateTransfer(TbTransfer transfer);*/

}
