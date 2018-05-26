package org.rainbow.service.impl;

import org.rainbow.mapper.TbAccountMapper;
import org.rainbow.mapper.TbStatusMapper;
import org.rainbow.pojo.TbAccount;
import org.rainbow.pojo.TbGoods;
import org.rainbow.pojo.TbStatus;
import org.rainbow.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private TbAccountMapper accountMapper;
	@Autowired
	private TbStatusMapper statusMapper;

	@Override
	public TbAccount loginByIdOrName(TbAccount account) {
		TbAccount rs = null;
		String name = account.getLoginname();
		TbAccount temp = accountMapper.selectByName(name);
		if (temp != null) {
			if (temp.getPassword().equals(account.getPassword())) {
				rs = temp;
				return rs;
			}
		}
		try {
			temp = accountMapper.selectByPrimaryKey(Long.valueOf(name));
			if (temp != null) {
				if (temp.getPassword().equals(account.getPassword())) {
					rs = temp;
				}
			}
		} catch (NumberFormatException e){
			return null;
		}
		return rs;
	}

	@Override
	public int insertNew(TbAccount account) {
		return accountMapper.insertSelective(account);
	}

	@Override
	public List<TbAccount> getAllAccount() {
		return accountMapper.selectAll();
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
	public TbAccount getAccountByID(long ID) {
		return accountMapper.selectByPrimaryKey(ID);
	}

	@Override
	public int updateAccount(TbAccount account) {
		return accountMapper.updateByPrimaryKeySelective(account);
	}

}
