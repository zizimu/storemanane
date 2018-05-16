package org.rainbow.service;

import org.rainbow.pojo.TbParameter;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-05-02
 */
public interface ParameterService {

	String getLoginBGimage();

	Map getPara();

	List<TbParameter> selectAll();

	String getTopImage();
}
