package org.rainbow.service;

import java.io.InputStream;

public interface Upload {

	String uploadPic2Tencent(InputStream file, String fileName, long fileLength);
}
