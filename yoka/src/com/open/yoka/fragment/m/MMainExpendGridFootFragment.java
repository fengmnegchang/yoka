/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-31上午10:43:50
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
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.open.android.fragment.BaseV4Fragment;
import com.open.android.view.ExpendGridView;
import com.open.yoka.R;
import com.open.yoka.adapter.m.MMainGridFootAdapter;
import com.open.yoka.bean.m.MGridFootBean;
import com.open.yoka.json.m.MGridFootJson;
import com.open.yoka.jsoup.m.MMainGridFootService;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-5-31上午10:43:50
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class MMainExpendGridFootFragment extends BaseV4Fragment<MGridFootJson, MMainExpendGridFootFragment> {
	public MMainGridFootAdapter mMMainGridFootAdapter;
	public List<MGridFootBean> list = new ArrayList<MGridFootBean>();
	public ExpendGridView mExpendGridView;

	public static MMainExpendGridFootFragment newInstance(String url, boolean isVisibleToUser) {
		MMainExpendGridFootFragment fragment = new MMainExpendGridFootFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_common_expend_gridview, container, false);
		mExpendGridView = (ExpendGridView) view.findViewById(R.id.pull_refresh_grid);
		return view;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.fragment.BaseV4Fragment#initValues()
	 */
	@Override
	public void initValues() {
		mMMainGridFootAdapter = new MMainGridFootAdapter(getActivity(), list);
		mExpendGridView.setAdapter(mMMainGridFootAdapter);
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
		mMGridFootJson.setList(MMainGridFootService.parseBox(url, pageNo));
		return mMGridFootJson;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.fragment.BaseV4Fragment#onCallback(java.lang.Object)
	 */
	@Override
	public void onCallback(MGridFootJson result) {
		// TODO Auto-generated method stub

		list.clear();
		list.addAll(result.getList());
		pageNo = 1;

		mMMainGridFootAdapter.notifyDataSetChanged();
		// Call onRefreshComplete when the list has been refreshed.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.open.enrz.fragment.BaseV4Fragment#handlerMessage(android.os.Message)
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
