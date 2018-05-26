package org.rainbow.service;

import org.rainbow.pojo.TbParameter;

import java.util.List;
import java.util.Map;


public interface ParameterService {

	String getLoginBGimage();

	Map getPara();

	List<TbParameter> selectAll();

	String getTopImage();
}
