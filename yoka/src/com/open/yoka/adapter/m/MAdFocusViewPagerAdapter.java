/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-24下午4:36:35
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.adapter.m;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.open.android.adapter.CommonPagerAdapter;
import com.open.yoka.R;
import com.open.yoka.activity.YokaWebViewActivity;
import com.open.yoka.bean.m.MSwiperBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-24下午4:36:35
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MAdFocusViewPagerAdapter extends CommonPagerAdapter<MSwiperBean> {

	public MAdFocusViewPagerAdapter(Context mContext, List<MSwiperBean> list) {
		super(mContext, list);
	}
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		final MSwiperBean bean = (MSwiperBean) getItem(position);
		final ViewHolder mViewHolder = new ViewHolder();
		View convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_m_viewpager, null);
		mViewHolder.imageview = (ImageView) convertView.findViewById(R.id.imageview);
		mViewHolder.txt_alt = (TextView) convertView.findViewById(R.id.txt_alt);
		if (bean != null) {
			if (bean.getSrc() != null && bean.getSrc().length() > 0) {
				DisplayImageOptions options = new DisplayImageOptions.Builder().showStubImage(R.drawable.default_img).showImageForEmptyUri(R.drawable.default_img).showImageOnFail(R.drawable.default_img)
						.cacheInMemory().cacheOnDisc().build();
				ImageLoader.getInstance().displayImage(bean.getSrc(), mViewHolder.imageview, options, null);
			}
			mViewHolder.txt_alt.setText(bean.getTitle());
			convertView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					YokaWebViewActivity.startYokaWebViewActivity(mContext, bean.getHref());
				}
			});
		}
		container.addView(convertView);
		return convertView;
	}

	private class ViewHolder {
		ImageView imageview;
		TextView txt_alt;
	}
}
