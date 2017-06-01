/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-1下午1:34:36
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.fragment;

import com.open.yoka.fragment.m.CommonPagerFragment;
import com.open.yoka.fragment.m.MAdFocusViewPagerFragment;
import com.open.yoka.json.m.MSwiperJson;
import com.open.yoka.jsoup.m.MSwiperService;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-1下午1:34:36
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class FocusViewPagerFragment extends CommonPagerFragment {
	
	public static FocusViewPagerFragment newInstance(String url, boolean isVisibleToUser) {
		FocusViewPagerFragment fragment = new FocusViewPagerFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	
	/* (non-Javadoc)
	 * @see com.open.enrz.fragment.BaseV4Fragment#call()
	 */
	@Override
	public MSwiperJson call() throws Exception {
		// TODO Auto-generated method stub
		MSwiperJson mIndexFocusJson = new MSwiperJson();
		mIndexFocusJson.setList(MSwiperService.parsePCFocus(url));
		return mIndexFocusJson;
	}
}