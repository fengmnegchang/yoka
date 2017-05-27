/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-27上午10:38:46
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.fragment.m;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.open.android.adapter.CommonFragmentPagerAdapter;
import com.open.android.fragment.BaseV4Fragment;
import com.open.indicator.TabPageIndicator;
import com.open.yoka.R;
import com.open.yoka.bean.m.MTabBean;
import com.open.yoka.json.m.MTabJson;
import com.open.yoka.jsoup.m.MTabService;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-27上午10:38:46
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MMainListBoxIndicatorFragment  extends BaseV4Fragment<MTabJson, MMainListBoxIndicatorFragment> {
	public ArrayList<MTabBean> list = new ArrayList<MTabBean>();
	public ViewPager viewpager;
	public TabPageIndicator indicator;
	public List<String> titleList = new ArrayList<String>();
	public List<Fragment> listRankFragment = new ArrayList<Fragment>();// view数组
	public CommonFragmentPagerAdapter mRankPagerAdapter;

	public static MMainListBoxIndicatorFragment newInstance(String url, boolean isVisibleToUser) {
		MMainListBoxIndicatorFragment fragment = new MMainListBoxIndicatorFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_common_indicator_viewpager, container, false);
		viewpager = (ViewPager) view.findViewById(R.id.viewpager);
		indicator = (TabPageIndicator) view.findViewById(R.id.indicator);
		return view;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.qianbailu.fragment.BaseV4Fragment#initValues()
	 */
	@Override
	public void initValues() {
		// TODO Auto-generated method stub
		super.initValues();
		mRankPagerAdapter = new CommonFragmentPagerAdapter(getChildFragmentManager(), listRankFragment, titleList);
		viewpager.setAdapter(mRankPagerAdapter);
		indicator.setViewPager(viewpager);
	}

	@Override
	public MTabJson call() throws Exception {
		// TODO Auto-generated method stub
		MTabJson mMTabJson = new MTabJson();
		mMTabJson.setList(MTabService.parseTab(url));
		return mMTabJson;
	}

	@Override
	public void onCallback(MTabJson result) {
		// TODO Auto-generated method stub
		super.onCallback(result);
		list.clear();
		list.addAll(result.getList());
		titleList.clear();

		Fragment fragment;
		for (int i=0;i< result.getList().size();i++) {
			MTabBean bean = result.getList().get(i);
			titleList.add(bean.getTitle());
			if(i==0){
				fragment = MMainListBoxFragment.newInstance(bean.getHref(),true);
			}else{
				fragment = MMainListBoxFragment.newInstance(bean.getHref(),false);
			}
			listRankFragment.add(fragment);
		}
		mRankPagerAdapter.notifyDataSetChanged();
		indicator.notifyDataSetChanged();
		
		 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.tencenttv.BaseV4Fragment#handlerMessage(android.os.Message)
	 */
	@Override
	public void handlerMessage(Message msg) {
		// TODO Auto-generated method stub
		switch (msg.what) {
		case MESSAGE_HANDLER:
			doAsync(this, this, this);
			break;
		default:
			break;
		}
	}
}
