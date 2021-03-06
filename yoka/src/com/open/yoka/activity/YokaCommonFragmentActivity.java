/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-24下午4:28:39
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.open.android.activity.CommonFragmentActivity;
import com.open.android.fragment.CommonV4Fragment;
import com.open.yoka.R;
import com.open.yoka.utils.UrlUtils;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-24下午4:28:39
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class YokaCommonFragmentActivity extends CommonFragmentActivity {
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.open.enrz.activity.CommonFragmentActivity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yoka_common_f);
		init();
	}

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
		Fragment fragment = CommonV4Fragment.newInstance(url, true);
		getSupportFragmentManager().beginTransaction().replace(R.id.id_common_fragment, fragment).commit();
	}

	public static void startYokaCommonFragmentActivity(Context context, String url) {
		Intent intent = new Intent();
		intent.putExtra("URL", url);
		intent.setClass(context, YokaCommonFragmentActivity.class);
		context.startActivity(intent);
	}
}