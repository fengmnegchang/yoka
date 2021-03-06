/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-24下午4:15:57
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.activity.m;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.open.yoka.R;
import com.open.yoka.activity.YokaCommonFragmentActivity;
import com.open.yoka.fragment.m.MAdFocusViewPagerFragment;
import com.open.yoka.utils.UrlUtils;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-24下午4:15:57
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MAdFocusViewPagerFragmentActivity extends YokaCommonFragmentActivity{
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.activity.CommonFragmentActivity#initValue()
	 */
	@Override
	protected void initValue() {
		// TODO Auto-generated method stub
		super.initValue();
		if (getIntent().getStringExtra("URL") != null) {
			url = getIntent().getStringExtra("URL");
		} else {
			url = UrlUtils.YOKA_M;
		}
		addfragment();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.activity.CommonFragmentActivity#addfragment()
	 */
	@Override
	public void addfragment() {
		// TODO Auto-generated method stub
		super.addfragment();
		Fragment fragment = MAdFocusViewPagerFragment.newInstance(url, true);
		getSupportFragmentManager().beginTransaction().replace(R.id.id_common_fragment, fragment).commit();
	}

	public static void startMAdFocusViewPagerFragmentActivity(Context context, String url) {
		Intent intent = new Intent();
		intent.putExtra("URL", url);
		intent.setClass(context, MAdFocusViewPagerFragmentActivity.class);
		context.startActivity(intent);
	}
}
