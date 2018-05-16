package org.rainbow.service.impl;

import org.rainbow.mapper.TbParameterMapper;
import org.rainbow.pojo.TbParameter;
import org.rainbow.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@Value("${ossUrl}")
	private String ossurl;
	@Value("${pageSize}")
	private Integer pageSize;
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

	@Override
	public Map getPara() {
		Map<String,Object> paras = new HashMap<>();
		TbParameter tbParameter = parameterMapper.selectByParameterName("ossurl");
		if (tbParameter != null) {
			String temp = tbParameter.getParametercontent();
			if (temp != null && !"".equals(temp)) {
				ossurl = temp;
			}
		}
		paras.put("ossUrl",ossurl);
		TbParameter tbParameter2 = parameterMapper.selectByParameterName("pageSize");
		if (tbParameter2 != null) {
			Integer temp = Integer.valueOf(tbParameter2.getParametercontent());
			if (temp>0) {
				pageSize = temp;
			}
		}
		paras.put("pageSize",pageSize);
		return paras;
	}

	@Override
	public List<TbParameter> selectAll() {
		return parameterMapper.selectAll();
	}

	@Override
	public String getTopImage() {
		TbParameter tbParameter = parameterMapper.selectByParameterName("indexTitleImage");
		if (tbParameter != null) {
			String temp = tbParameter.getParametercontent();
			if (temp != null && !"".equals(temp)) {
				bgImage = temp;
			}
		}
		return bgImage;
	}
}
