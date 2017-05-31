/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-27上午9:47:11
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.fragment.m;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.open.yoka.R;
import com.open.yoka.adapter.m.MMainListBoxAdapter;
import com.open.yoka.bean.m.MListBoxBean;
import com.open.yoka.json.m.MListBoxJson;
import com.open.yoka.jsoup.m.MMainListBoxService;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-5-27上午9:47:11
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class MMainListBoxFragment extends CommonPullToRefreshListFragment<MListBoxBean, MListBoxJson> {
	public MMainListBoxAdapter mMMainListBoxAdapter;
	public View headview;
	public View footview;
	
	public static MMainListBoxFragment newInstance(String url, boolean isVisibleToUser) {
		MMainListBoxFragment fragment = new MMainListBoxFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_common_pulllistview, container, false);
		mPullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pull_refresh_list);
		headview = LayoutInflater.from(getActivity()).inflate(R.layout.layout_m_box_head, null);
		footview = LayoutInflater.from(getActivity()).inflate(R.layout.layout_m_box_foot, null);
		return view;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.fragment.BaseV4Fragment#initValues()
	 */
	@Override
	public void initValues() {
		// TODO Auto-generated method stub
		mPullToRefreshListView.getRefreshableView().addHeaderView(headview);
		mPullToRefreshListView.getRefreshableView().addFooterView(footview);
		Fragment fragment = MAdFocusViewPagerFragment.newInstance(url, true);
		getChildFragmentManager().beginTransaction().replace(R.id.id_m_box_head, fragment).commit();
		
		Fragment ffragment = MMainExpendGridFootFragment.newInstance(url, true);
		getChildFragmentManager().beginTransaction().replace(R.id.id_m_box_foot_grid, ffragment).commit();
		
		Fragment tfragment = MMainTagFragment.newInstance(url, true);
		getChildFragmentManager().beginTransaction().replace(R.id.id_m_box_foot_tag, tfragment).commit();
		
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
		mMListBoxJson.setList(MMainListBoxService.parseBox(url,pageNo));
		return mMListBoxJson;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.fragment.BaseV4Fragment#onCallback(java.lang.Object)
	 */
	@Override
	public void onCallback(MListBoxJson result) {
		// TODO Auto-generated method stub
		Log.i(TAG, "getMode ===" + mPullToRefreshListView.getCurrentMode());
		if (mPullToRefreshListView.getCurrentMode() == Mode.PULL_FROM_START) {
			list.clear();
			list.addAll(result.getList());
			pageNo = 1;
		} else {
			if (result.getList() != null && result.getList().size() > 0) {
				list.addAll(result.getList());
			}
		}
		mMMainListBoxAdapter.notifyDataSetChanged();
		// Call onRefreshComplete when the list has been refreshed.
		mPullToRefreshListView.onRefreshComplete();
	}
}
