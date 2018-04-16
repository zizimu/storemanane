package org.rainbow.service;

import java.util.List;

import org.rainbow.pojo.TbStaff;

public interface StaffService {
	
	int addStaff(TbStaff staff);
	
	List<TbStaff>getAllGoods();
	
	TbStaff getStaffById(long ID);
	
	int updateGoods(TbStaff staff);
	
	List<TbStaff> searchStaff(String key);

}
