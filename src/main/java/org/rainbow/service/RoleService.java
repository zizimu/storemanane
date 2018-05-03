package org.rainbow.service;

import java.util.List;

import org.rainbow.pojo.TbRole;


public interface RoleService{

	int addRole(TbRole role);

	List<TbRole> getAllRole();

	TbRole getRoleById(int ID);

	int updateRole(TbRole role);

	List<TbRole> searchRole(String key);

}
