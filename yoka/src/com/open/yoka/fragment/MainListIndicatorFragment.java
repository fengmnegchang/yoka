/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-1下午1:43:46
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.fragment;

import android.support.v4.app.Fragment;

import com.open.yoka.bean.m.MTabBean;
import com.open.yoka.fragment.m.MMainListBoxFragment;
import com.open.yoka.fragment.m.MMainListBoxIndicatorFragment;
import com.open.yoka.json.m.MTabJson;
import com.open.yoka.jsoup.m.MTabService;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-6-1下午1:43:46
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class MainListIndicatorFragment extends MMainListBoxIndicatorFragment {
	public static MainListIndicatorFragment newInstance(String url, boolean isVisibleToUser) {
		MainListIndicatorFragment fragment = new MainListIndicatorFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	
	@Override
	public MTabJson call() throws Exception {
		// TODO Auto-generated method stub
		MTabJson mMTabJson = new MTabJson();
		mMTabJson.setList(MTabService.parsePCTab(url));
		return mMTabJson;
	}

	@Override
	public void onCallback(MTabJson result) {
		// TODO Auto-generated method stub
		list.clear();
		list.addAll(result.getList());
		titleList.clear();

		Fragment fragment;
		for (int i=0;i< result.getList().size();i++) {
			MTabBean bean = result.getList().get(i);
			titleList.add(bean.getTitle());
			if(i==0){
				fragment = MainListFragment.newInstance(bean.getHref(),true);
			}else{
				fragment = MainListFragment.newInstance(bean.getHref(),false);
			}
			listRankFragment.add(fragment);
		}
		mRankPagerAdapter.notifyDataSetChanged();
		indicator.notifyDataSetChanged();
		
		 
	}
}
