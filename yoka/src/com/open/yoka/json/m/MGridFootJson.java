/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-31上午10:49:11
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.json.m;

import java.util.List;

import com.open.android.json.CommonJson;
import com.open.yoka.bean.m.MGridFootBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-31上午10:49:11
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MGridFootJson extends CommonJson{
	private List<MGridFootBean> list;

	public List<MGridFootBean> getList() {
		return list;
	}

	public void setList(List<MGridFootBean> list) {
		this.list = list;
	}
	

}
