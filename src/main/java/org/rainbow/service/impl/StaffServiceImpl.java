package org.rainbow.service.impl;

import java.util.List;

import org.rainbow.mapper.TbStaffMapper;
import org.rainbow.pojo.TbStaff;
import org.rainbow.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;

public class StaffServiceImpl implements StaffService {

	@Autowired
	private TbStaffMapper tbStaffMapper;

	@Override
	public int addStaff(TbStaff staff) {

		return tbStaffMapper.insertSelective(staff);
	}

	@Override
	public List<TbStaff> getAllGoods() {

		return tbStaffMapper.selectAll();
	}

	@Override
	public TbStaff getStaffById(long ID) {

		return tbStaffMapper.selectByPrimaryKey(ID);
	}

	@Override
	public int updateGoods(TbStaff staff) {

		return tbStaffMapper.updateByPrimaryKeySelective(staff);
	}

	@Override
	public List<TbStaff> searchStaff(String key) {

		return tbStaffMapper.searchStaff(key);

	}

}
