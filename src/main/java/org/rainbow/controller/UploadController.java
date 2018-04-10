package org.rainbow.controller;

import com.google.gson.Gson;
import org.rainbow.service.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@Value("https://1213-1251943624.cos.ap-shanghai.myqcloud.com/")
	private String imageUrl;

	@Autowired
	private Upload upload;

	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	@ResponseBody
	public Map uploadFile(MultipartFile file){
		Map<String,Object> result = new HashMap<>();
		if(file.getSize()>0) {
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
			String filename = "store-manage/" + dateStr + "/" + newFileName;
			try {
				upload.uploadPic2Tencent(file.getInputStream(), filename, file.getSize());
				result.put("success", 0);
				result.put("url", imageUrl + filename);
			} catch (IOException e) {
				e.printStackTrace();
				result.put("error", 1);
				result.put("message", "上传失败！请重试！");
			}
		}
		return result;
	}

}
