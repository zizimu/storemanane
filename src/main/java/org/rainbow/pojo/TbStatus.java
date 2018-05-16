package org.rainbow.pojo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author ross
 * @date 2018-05-16
 */
public class TbStatus implements Serializable {
	private static final long serialVersionUID = 6621279960224027988L;

	private Long statusNum;
	private String powerName;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getStatusNum() {
		return statusNum;
	}

	public void setStatusNum(Long statusNum) {
		this.statusNum = statusNum;
	}

	public String getPowerName() {
		return powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}
}
