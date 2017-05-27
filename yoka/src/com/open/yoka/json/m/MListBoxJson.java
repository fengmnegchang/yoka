/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-27上午9:38:15
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.json.m;

import java.util.List;

import com.open.android.json.CommonJson;
import com.open.yoka.bean.m.MListBoxBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-27上午9:38:15
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MListBoxJson extends CommonJson {
	private List<MListBoxBean> list;

	public List<MListBoxBean> getList() {
		return list;
	}

	public void setList(List<MListBoxBean> list) {
		this.list = list;
	}
	

}
