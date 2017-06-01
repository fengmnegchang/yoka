/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-1上午10:37:06
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.fragment;

import android.support.v4.app.Fragment;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.open.yoka.R;
import com.open.yoka.adapter.m.MMainListBoxAdapter;
import com.open.yoka.fragment.m.MAdFocusViewPagerFragment;
import com.open.yoka.fragment.m.MMainExpendGridFootFragment;
import com.open.yoka.fragment.m.MMainListBoxFragment;
import com.open.yoka.fragment.m.MMainTagFragment;
import com.open.yoka.json.m.MListBoxJson;
import com.open.yoka.jsoup.m.MMainListBoxService;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-6-1上午10:37:06
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class MainListFragment extends MMainListBoxFragment {
	
	public static MainListFragment newInstance(String url, boolean isVisibleToUser) {
		MainListFragment fragment = new MainListFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.fragment.BaseV4Fragment#initValues()
	 */
	@Override
	public void initValues() {
		mMMainListBoxAdapter = new MMainListBoxAdapter(getActivity(), list);
		mPullToRefreshListView.setAdapter(mMMainListBoxAdapter);
		mPullToRefreshListView.setMode(Mode.PULL_FROM_START);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.fragment.BaseV4Fragment#call()
	 */
	@Override
	public MListBoxJson call() throws Exception {
		// TODO Auto-generated method stub
		MListBoxJson mMListBoxJson = new MListBoxJson();
		//http://brandservice.yoka.com/v1/?_c=cmsbrandindex&_a=getCmsForZhuNew&_moduleId=29&channel=23&column=103&skip=45&limit=15&p=2&callback=jsonpCallbackFunctionNo14962850979074116
		mMListBoxJson.setList(MMainListBoxService.parseList(url,pageNo));
		return mMListBoxJson;
	}
}
