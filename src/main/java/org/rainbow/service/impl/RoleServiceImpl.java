package org.rainbow.service.impl;

import java.util.List;

import org.rainbow.mapper.TbRoleMapper;
import org.rainbow.pojo.TbRole;
import org.rainbow.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private TbRoleMapper tbRoleMapper;

	@Override
	public int addRole(TbRole role) {

		return tbRoleMapper.insertSelective(role);
	}

	@Override
	public TbRole getRoleById(int ID) {

		return tbRoleMapper.selectByPrimaryKey(ID);
	}

	@Override
	public List<TbRole> searchRole(String key) {

		return tbRoleMapper.searchRole(key);

	}

	@Override
	public List<TbRole> getAllRole() {
		return tbRoleMapper.selectAll();
	}

	@Override
	public int updateRole(TbRole Role) {
		return tbRoleMapper.updateByPrimaryKeySelective(Role);
	}

}
