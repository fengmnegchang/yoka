/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-31下午1:53:05
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
import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView.OnTagClickListener;

import com.open.android.fragment.BaseV4Fragment;
import com.open.yoka.R;
import com.open.yoka.activity.YokaWebViewActivity;
import com.open.yoka.bean.m.MGridFootBean;
import com.open.yoka.json.m.MGridFootJson;
import com.open.yoka.jsoup.m.MMainGridFootService;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-5-31下午1:53:05
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class MMainTagFragment extends BaseV4Fragment<MGridFootJson, MMainTagFragment> {
	public TagContainerLayout mTagContainerLayout;
	public List<MGridFootBean> list  = new ArrayList<MGridFootBean>();
	
	public static MMainTagFragment newInstance(String url, boolean isVisibleToUser) {
		MMainTagFragment fragment = new MMainTagFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_main_tag, container, false);
		mTagContainerLayout = (TagContainerLayout) view.findViewById(R.id.tagcontainerLayout);
		return view;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.fragment.BaseV4Fragment#initValues()
	 */
	@Override
	public void initValues() {
		mTagContainerLayout.setOnTagClickListener(new OnTagClickListener() {
			
			@Override
			public void onTagLongClick(int position, String text) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onTagCrossClick(int position) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onTagClick(int position, String text) {
				// TODO Auto-generated method stub
				YokaWebViewActivity.startYokaWebViewActivity(getActivity(), list.get(position).getHref());
			}
		});
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
		mMGridFootJson.setList(MMainGridFootService.parseTag(url,pageNo));
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
		ArrayList<String> tags = new ArrayList<String>();
		for(MGridFootBean bean:result.getList()){
			tags.add(bean.getAlt());
		}
		mTagContainerLayout.setTags(tags);
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
