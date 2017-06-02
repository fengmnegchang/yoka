/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-2上午9:42:43
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.module;

import android.util.Log;

import com.google.gson.Gson;
import com.open.yoka.json.m.MSwiperJson;
import com.open.yoka.jsoup.m.MSwiperService;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.WXModuleAnno;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-2上午9:42:43
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class WeexJsoupModule extends WeexBaseJsoupModule<MSwiperJson> {
	public String TAG = WeexBaseJsoupModule.class.getSimpleName();
	private String callback;
	private String params;
	
	@WXModuleAnno(moduleMethod = true, runOnUIThread = true)
	public void focuspager(String params, String callback){
		Log.d(TAG, "focuspager ========" + params);
		try {
			 setCallback(callback);
			 setParams(params);
			 doAsync(this, this, this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see com.open.yoka.module.WeexBaseJsoupModule#call()
	 */
	@Override
	public MSwiperJson call() throws Exception {
		// TODO Auto-generated method stub
		String url = getParams();
		MSwiperJson mIndexFocusJson = new MSwiperJson();
		mIndexFocusJson.setList(MSwiperService.parsePCFocus(url));
		return mIndexFocusJson;
	}

	/* (non-Javadoc)
	 * @see com.open.yoka.module.WeexBaseJsoupModule#onCallback(java.lang.Object)
	 */
	@Override
	public void onCallback(MSwiperJson result) {
		// TODO Auto-generated method stub
		super.onCallback(result);
		Gson gson = new Gson();
		WXBridgeManager.getInstance().callback(mWXSDKInstance.getInstanceId(), getCallback(), gson.toJson(result));
	}

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}
	
	
}
