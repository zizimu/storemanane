package org.rainbow.service;

import java.util.List;

import org.rainbow.pojo.TbStaff;

public interface StaffService {

	int addStaff(TbStaff staff);

	List<TbStaff> getAllStaff();

	List<TbStaff> getAllStaffInStore(Long storeID);

	TbStaff getStaffById(long ID);

	int updateStaff(TbStaff staff);

	List<TbStaff> searchStaff(String key);

	List<TbStaff> searchStaffInStore(String key,Long storeID);

}
