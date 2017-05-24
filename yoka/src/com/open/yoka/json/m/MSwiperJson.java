/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-24下午4:35:09
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.json.m;

import java.util.List;

import com.open.android.json.CommonJson;
import com.open.yoka.bean.m.MSwiperBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-24下午4:35:09
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MSwiperJson extends CommonJson {
	private List<MSwiperBean> list;

	public List<MSwiperBean> getList() {
		return list;
	}

	public void setList(List<MSwiperBean> list) {
		this.list = list;
	}
	

}
