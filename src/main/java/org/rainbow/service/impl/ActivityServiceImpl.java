package org.rainbow.service.impl;

import java.util.List;

import org.rainbow.mapper.TbActivityMapper;
import org.rainbow.pojo.TbActivity;
import org.rainbow.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	private TbActivityMapper tbActivityMapper;

	@Override
	public int addActivity(TbActivity activity) {

		return tbActivityMapper.insertSelective(activity);
	}

	@Override
	public List<TbActivity> searchActivity(String key) {

		return tbActivityMapper.searchActivity(key);

	}

	@Override
	public List<TbActivity> getAllActivity() {
		return tbActivityMapper.selectAll();
	}

	@Override
	public int updateActivity(TbActivity activity) {
		return tbActivityMapper.updateByPrimaryKeySelective(activity);
	}

	@Override
	public TbActivity getActivityByID(int ID) {
		return tbActivityMapper.selectByPrimaryKey(ID);
	}

}
