package org.rainbow.service;

import org.rainbow.pojo.TbActivity;

import java.util.List;
import java.util.Map;

public interface ActivityService {

	List<TbActivity> getAllActivity();

	int addActivity(TbActivity activity);

	TbActivity getActivityByID(int id);

	int updateActivity(TbActivity activity);

	List<TbActivity> searchActivity(String key);

}
