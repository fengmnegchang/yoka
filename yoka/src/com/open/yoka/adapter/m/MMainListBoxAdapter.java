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
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.open.android.adapter.CommonAdapter;
import com.open.yoka.R;
import com.open.yoka.activity.YokaWebViewActivity;
import com.open.yoka.bean.m.MListBoxBean;
import com.open.yoka.widget.OpenClickableSpan;

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
public class MMainListBoxAdapter extends CommonAdapter<MListBoxBean> {

	public MMainListBoxAdapter(Context mContext, List<MListBoxBean> list) {
		super(mContext, list);
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.adapter_m_main_list_box, parent, false);
			viewHolder.text_title = (TextView) convertView.findViewById(R.id.text_title);
			viewHolder.text_camLiDes = (TextView) convertView.findViewById(R.id.text_camLiDes);
			viewHolder.imageview = (ImageView) convertView.findViewById(R.id.imageview);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		final MListBoxBean bean = (MListBoxBean) getItem(position);
		if (bean != null) {
			if(bean.getTxt()!=null && bean.getTxt().length()>0){
				viewHolder.text_camLiDes.setText(Html.fromHtml(bean.getTxt()));
				viewHolder.text_camLiDes.setMovementMethod(LinkMovementMethod.getInstance());   
				CharSequence text = viewHolder.text_camLiDes.getText();   
		        if(text instanceof Spannable){   
		            int end = text.length();   
		            Spannable sp = (Spannable)viewHolder.text_camLiDes.getText();   
		            URLSpan[] urls=sp.getSpans(0, end, URLSpan.class);    
		            SpannableStringBuilder style=new SpannableStringBuilder(text);   
		            style.clearSpans();//should clear old spans   
		            for(URLSpan url : urls){   
		            	OpenClickableSpan openClickableSpan = new OpenClickableSpan(mContext,url.getURL());   
		                style.setSpan(openClickableSpan,sp.getSpanStart(url),sp.getSpanEnd(url),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);   
		            }   
		            viewHolder.text_camLiDes.setText(style);   
		        }
			}
			
			viewHolder.text_title.setText(bean.getAlt());
			if (bean.getSrc() != null && bean.getSrc().length() > 0) {
				DisplayImageOptions options = new DisplayImageOptions.Builder().showStubImage(R.drawable.default_img).showImageForEmptyUri(R.drawable.default_img).showImageOnFail(R.drawable.default_img)
						.cacheInMemory().cacheOnDisc().build();
				ImageLoader.getInstance().displayImage(bean.getSrc(), viewHolder.imageview, options, getImageLoadingListener());
			}

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
		TextView text_title,text_camLiDes;
		ImageView imageview;
	}

}
