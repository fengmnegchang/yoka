/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-1上午11:36:39
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.fragment;

import com.open.yoka.fragment.m.MMainTagFragment;
import com.open.yoka.json.m.MGridFootJson;
import com.open.yoka.jsoup.m.MMainGridFootService;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-1上午11:36:39
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MainFootTagFragment extends MMainTagFragment {
	
	public static MainFootTagFragment newInstance(String url, boolean isVisibleToUser) {
		MainFootTagFragment fragment = new MainFootTagFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.fragment.BaseV4Fragment#call()
	 */
	@Override
	public MGridFootJson call() throws Exception {
		// TODO Auto-generated method stub
		MGridFootJson mMGridFootJson = new MGridFootJson();
		mMGridFootJson.setList(MMainGridFootService.parsePCTag(url,pageNo));
		return mMGridFootJson;
	}
}
