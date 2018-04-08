package org.rainbow.service;

import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-04-08
 */
public interface Upload {

	String uploadPic2Tencent(InputStream file, String fileName, long fileLength);
}
