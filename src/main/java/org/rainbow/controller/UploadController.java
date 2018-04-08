package org.rainbow.controller;

import org.rainbow.service.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-04-08
 */
@Controller
public class UploadController {
	@Value("https://1213-1251943624.cos.ap-shanghai.myqcloud.com/store-manage/")
	private String imageUrl;

	@Autowired
	private Upload upload;

	@RequestMapping(value = "/upload/pic",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String uploadFile(MultipartFile file){
		Map<String,Object> result = new HashMap<>();
		String partFileName = file.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String newFileName;
		int idx = partFileName.lastIndexOf(".");
		if (idx != -1) {
			newFileName = uuid.toString() + partFileName.substring(idx);
		} else {
			newFileName = uuid.toString();
		}
		String dateStr = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String filename = "/store-manage"+dateStr+"/"+newFileName;
		try {
			upload.uploadPic2Tencent(file.getInputStream(),filename,file.getSize());
		} catch (IOException e) {
			e.printStackTrace();
			result.put("error",0);
		}
		return "";
	}

}