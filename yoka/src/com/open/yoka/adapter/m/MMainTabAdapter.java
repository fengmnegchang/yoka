/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-27上午9:39:10
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.adapter.m;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.open.android.adapter.CommonAdapter;
import com.open.yoka.R;
import com.open.yoka.activity.YokaWebViewActivity;
import com.open.yoka.bean.m.MTabBean;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-5-27上午9:39:10
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class MMainTabAdapter extends CommonAdapter<MTabBean> {

	public MMainTabAdapter(Context mContext, List<MTabBean> list) {
		super(mContext, list);
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.adapter_m_tab, parent, false);
			viewHolder.text_title = (TextView) convertView.findViewById(R.id.text_title);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		final MTabBean bean = (MTabBean) getItem(position);
		if (bean != null) {
			viewHolder.text_title.setText(bean.getTitle());
			convertView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					YokaWebViewActivity.startYokaWebViewActivity(mContext, bean.getHref());
				}
			});

		}
		return convertView;
	}

	class ViewHolder {
		TextView text_title;
	}

}
