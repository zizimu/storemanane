package org.rainbow.controller;

import org.rainbow.service.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@SessionAttributes("ossUrl")
public class UploadController {
	@Value("${ossUrl}")
	private String imageUrl1;

	@Autowired
	private Upload upload;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public Map uploadFile(MultipartFile file,@ModelAttribute("ossUrl")String imageUrl) {
		Map<String, Object> result = new HashMap<>();
		if (file != null && file.getSize() > 0) {
			String partFileName = file.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			String newFileName;
			int idx = partFileName.lastIndexOf(".");
			if (idx != -1) {
				newFileName = uuid.toString() + partFileName.substring(idx);
			} else {
				newFileName = uuid.toString();
			}
			String yearNmouth = new SimpleDateFormat("yyyyMM").format(new Date());
			String day = new SimpleDateFormat("dd").format(new Date());
			String filename = "store-manage/" + yearNmouth + "/" + day + "/" + newFileName;
			try {
				upload.uploadPic2Tencent(file.getInputStream(), filename, file.getSize());
				result.put("stat", 200);
				result.put("url", imageUrl + filename);
			} catch (IOException e) {
				e.printStackTrace();
				result.put("stat", 500);
				result.put("message", "上传失败！请重试！");
			}
		}else {
			result.put("stat",400);
			result.put("message","没有文件！");
		}
		return result;
	}

}
