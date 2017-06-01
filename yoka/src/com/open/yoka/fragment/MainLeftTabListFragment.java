/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-1下午2:04:32
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.fragment;

import android.view.View;
import android.widget.AdapterView;

import com.open.yoka.activity.MainListIndicatorFragmentActivity;
import com.open.yoka.activity.YokaWebViewActivity;
import com.open.yoka.fragment.m.MMainLeftTabListFragment;
import com.open.yoka.json.m.MTabJson;
import com.open.yoka.jsoup.m.MTabService;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-1下午2:04:32
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MainLeftTabListFragment extends MMainLeftTabListFragment {
	public static MainLeftTabListFragment newInstance(String url, boolean isVisibleToUser) {
		MainLeftTabListFragment fragment = new MainLeftTabListFragment();
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
	public MTabJson call() throws Exception {
		// TODO Auto-generated method stub
		MTabJson mMTabJson = new MTabJson();
		mMTabJson.setList(MTabService.parsePCMenuTab(url));
		return mMTabJson;
	}

	/* (non-Javadoc)
	 * @see com.open.yoka.fragment.m.CommonPullToRefreshListFragment#onItemClick(android.widget.AdapterView, android.view.View, int, long)
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
//		super.onItemClick(parent, view, position, id);
		if(id!=-1 && list!=null && list.get((int)id)!=null){
//			YokaWebViewActivity.startYokaWebViewActivity(getActivity(), list.get((int)id).getHref());
			MainListIndicatorFragmentActivity.startMainListIndicatorFragmentActivity(getActivity(),  list.get((int)id).getHref());
		}
	}
}
