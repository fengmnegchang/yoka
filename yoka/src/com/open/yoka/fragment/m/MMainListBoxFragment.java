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

import android.util.Log;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
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

	public static MMainListBoxFragment newInstance(String url, boolean isVisibleToUser) {
		MMainListBoxFragment fragment = new MMainListBoxFragment();
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
		// TODO Auto-generated method stub
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
		mMListBoxJson.setList(MMainListBoxService.parseBox(url));
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
