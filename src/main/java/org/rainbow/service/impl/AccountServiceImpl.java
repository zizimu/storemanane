package org.rainbow.service.impl;

import org.rainbow.mapper.TbAccountMapper;
import org.rainbow.pojo.TbAccount;
import org.rainbow.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-05-02
 */
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private TbAccountMapper accountMapper;

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
		temp = accountMapper.selectByPrimaryKey(Long.valueOf(name));
		if (temp != null) {
			if (temp.getPassword().equals(account.getPassword())) {
				rs = temp;
			}
		}
		return rs;
	}

	@Override
	public int insertNew(TbAccount account) {
		return accountMapper.insertSelective(account);
	}

	@Override
	public List<TbAccount> getAllAccount() {
		return null;
	}
}
