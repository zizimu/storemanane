package org.rainbow.service;

import org.rainbow.pojo.TbAccount;

import java.util.List;
import java.util.Map;


public interface AccountService{

	TbAccount loginByIdOrName(TbAccount account);

	int insertNew(TbAccount account);

	List<TbAccount> getAllAccount();

	Map<Long,String> getAllStatus();

	TbAccount getAccountByID(long ID);

	int updateAccount(TbAccount account);
}
