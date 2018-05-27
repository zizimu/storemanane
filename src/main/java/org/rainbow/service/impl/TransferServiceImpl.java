package org.rainbow.service.impl;


import org.rainbow.mapper.TbStatusMapper;
import org.rainbow.mapper.TbTransferMapper;
import org.rainbow.pojo.TbStatus;
import org.rainbow.pojo.TbTransfer;
import org.rainbow.service.TransferService;
import org.rainbow.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcloud.cos.transfer.Transfer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TransferServiceImpl implements TransferService {
	@Autowired
	private TbTransferMapper transferMapper;
	@Autowired
	private TbStatusMapper statusMapper;
	@Override
	public int addTransfer(TbTransfer transfer) {
		return transferMapper.addTransfer(transfer);
	}
	@Override
	public List<TbTransfer> findAllCheckTransfer() {
		return transferMapper.findAllCheckTransfer();
	}
	@Override
	public TbTransfer findCheckTransfer(Long transfer_id) {
		return transferMapper.findCheckTransfer(transfer_id);
	}
	@Override
	public void updateTransfer(TbTransfer transfer) {
		transferMapper.updateTransfer(transfer);
	}


	/*@Override
	public int insertNew(TbTransfer account) {
		return transferMapper.insertSelective(account);
	}

	@Override
	public List<TbTransfer> getAllTransfer() {
		return transferMapper.selectAll();
	}

	@Override
	public Map<Long, String> getAllStatus() {
		Map<Long, String> result = new HashMap<>();
		List<TbStatus> statuses = statusMapper.selectAll();
		for (TbStatus temp : statuses) {
			result.put(temp.getStatusNum(), temp.getPowerName());
		}
		return result;
	}

	@Override
	public TbTransfer getTransferByID(long ID) {
		return transferMapper.selectByPrimaryKey(ID);
	}

	@Override
	public int updateTransfer(TbTransfer account) {
		return transferMapper.updateByPrimaryKeySelective(account);
	}*/

}
