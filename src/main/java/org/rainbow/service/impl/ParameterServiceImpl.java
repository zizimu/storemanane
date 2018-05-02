package org.rainbow.service.impl;

import org.rainbow.mapper.TbParameterMapper;
import org.rainbow.pojo.TbParameter;
import org.rainbow.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-05-02
 */
@Service
public class ParameterServiceImpl implements ParameterService {
	@Value("${backgroundImage}")
	private String bgImage;
	@Autowired
	private TbParameterMapper parameterMapper;

	@Override
	public String getLoginBGimage() {
		TbParameter tbParameter = parameterMapper.selectByParameterName("backgroundImage");
		if (tbParameter != null) {
			String temp = tbParameter.getParametercontent();
			if (temp != null && !"".equals(temp)) {
				bgImage = temp;
			}
		}
		return bgImage;
	}
}
