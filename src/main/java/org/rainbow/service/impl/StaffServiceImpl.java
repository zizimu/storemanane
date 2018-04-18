package org.rainbow.service.impl;

import java.util.List;

import org.rainbow.mapper.TbStaffMapper;
import org.rainbow.pojo.TbStaff;
import org.rainbow.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private TbStaffMapper tbStaffMapper;

	@Override
	public int addStaff(TbStaff staff) {

		return tbStaffMapper.insertSelective(staff);
	}

	@Override
	public TbStaff getStaffById(long ID) {

		return tbStaffMapper.selectByPrimaryKey(ID);
	}

	@Override
	public List<TbStaff> searchStaff(String key) {

		return tbStaffMapper.searchStaff(key);

	}

	@Override
	public List<TbStaff> getAllStaff() {
		return tbStaffMapper.selectAll();
	}

	@Override
	public int updateStaff(TbStaff staff) {
		return tbStaffMapper.updateByPrimaryKey(staff);
	}

}
