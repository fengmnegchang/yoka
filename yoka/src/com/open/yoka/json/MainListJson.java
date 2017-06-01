/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-1上午10:55:24
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.json;

import java.util.List;

import com.open.android.json.CommonJson;
import com.open.yoka.bean.MainListBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-1上午10:55:24
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MainListJson extends CommonJson {
	private int count;//":"15",
	private String time;//":"2017-06-01 10:47:54",
	private String status;//":"true",
    private int restime;//":0,
    private List<MainListBean> context;//":Array[15],
    private int isloading;//":1,
	private int queryOffSet;//":"90"
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getRestime() {
		return restime;
	}
	public void setRestime(int restime) {
		this.restime = restime;
	}
	public List<MainListBean> getContext() {
		return context;
	}
	public void setContext(List<MainListBean> context) {
		this.context = context;
	}
	public int getIsloading() {
		return isloading;
	}
	public void setIsloading(int isloading) {
		this.isloading = isloading;
	}
	public int getQueryOffSet() {
		return queryOffSet;
	}
	public void setQueryOffSet(int queryOffSet) {
		this.queryOffSet = queryOffSet;
	}
	
	
}
