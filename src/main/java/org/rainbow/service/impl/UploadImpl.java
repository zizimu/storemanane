package org.rainbow.service.impl;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import org.rainbow.service.Upload;
import org.springframework.stereotype.Service;

import javax.servlet.http.Part;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-04-08
 */
@Service
public class UploadImpl implements Upload {
	@Override
	public String uploadPic2Tencent(InputStream file, String fileName, long fileLength) {
		// 1 初始化用户身份信息(secretId, secretKey)
		COSCredentials cred = new BasicCOSCredentials("AKIDlJcljRrBBvPdayizc08F9oDPM3Vi8PtA",
				"CAtNbaJm2B5vVqvmOltmOk37yaw2rPhX");
		// 2 设置bucket的区域, COS地域的简称请参照
		// https://cloud.tencent.com/document/product/436/6224
		ClientConfig clientConfig = new ClientConfig(new Region("ap-shanghai"));
		// 3 生成cos客户端
		COSClient cosClient = new COSClient(cred, clientConfig);
		// bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
		String bucketName = "1213-1251943624";
		// 创建上传Object的Metadata
		ObjectMetadata meta = new ObjectMetadata();
		// 必须设置ContentLength
		meta.setContentLength(fileLength);
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, file, meta);
		PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
		cosClient.shutdown();
		return putObjectResult.getContentMd5();
	}

}
