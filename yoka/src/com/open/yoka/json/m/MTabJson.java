/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-27上午10:41:52
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.json.m;

import java.util.List;

import com.open.android.json.CommonJson;
import com.open.yoka.bean.m.MTabBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-27上午10:41:52
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MTabJson extends CommonJson {
	private List<MTabBean> list;

	public List<MTabBean> getList() {
		return list;
	}

	public void setList(List<MTabBean> list) {
		this.list = list;
	}
	
	

}
