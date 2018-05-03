package org.rainbow.service;

import org.rainbow.pojo.TbAccount;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-05-02
 */
public interface AccountService{

	TbAccount loginByIdOrName(TbAccount account);

	int insertNew(TbAccount account);
}