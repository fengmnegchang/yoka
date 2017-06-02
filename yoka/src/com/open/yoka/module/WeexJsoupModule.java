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
import com.open.andenginetask.CallEarliest;
import com.open.andenginetask.Callable;
import com.open.andenginetask.Callback;
import com.open.yoka.json.m.MGridFootJson;
import com.open.yoka.json.m.MSwiperJson;
import com.open.yoka.json.m.MTabJson;
import com.open.yoka.jsoup.m.MMainGridFootService;
import com.open.yoka.jsoup.m.MSwiperService;
import com.open.yoka.jsoup.m.MTabService;
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
// public class WeexJsoupModule extends WXModule {
public class WeexJsoupModule extends WeexBaseJsoupModule {
	public String TAG = WeexBaseJsoupModule.class.getSimpleName();

	@SuppressWarnings("unchecked")
	@WXModuleAnno(moduleMethod = true, runOnUIThread = true)
	public void focuspager(final String params, final String callback) {
		Log.d(TAG, "focuspager ========" + params);
		try {
			doAsync(new CallEarliest<MSwiperJson>() {
				@Override
				public void onCallEarliest() throws Exception {
				}
			}, new Callable<MSwiperJson>() {
				@Override
				public MSwiperJson call() throws Exception {
					MSwiperJson mIndexFocusJson = new MSwiperJson();
					mIndexFocusJson.setList(MSwiperService.parsePCFocus(params));
					return mIndexFocusJson;
				}
			}, new Callback<MSwiperJson>() {
				@Override
				public void onCallback(MSwiperJson result) {
					Gson gson = new Gson();
					WXBridgeManager.getInstance().callback(mWXSDKInstance.getInstanceId(), callback, gson.toJson(result));
				}
			});
			// 发起请求
			// new Thread(new Runnable() {
			// @Override
			// public void run() {
			// MSwiperJson mIndexFocusJson = new MSwiperJson();
			// mIndexFocusJson.setList(MSwiperService.parsePCFocus(params));
			// Gson gson = new Gson();
			// WXBridgeManager.getInstance().callback(mWXSDKInstance.getInstanceId(),
			// callback, gson.toJson(mIndexFocusJson));
			// }
			// }).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@WXModuleAnno(moduleMethod = true, runOnUIThread = true)
	public void foottag(final String params, final String callback) {
		Log.d(TAG, "foottag ========" + params);
		try {
			doAsync(new CallEarliest<MGridFootJson>() {
				@Override
				public void onCallEarliest() throws Exception {
				}
			}, new Callable<MGridFootJson>() {
				@Override
				public MGridFootJson call() throws Exception {
					MGridFootJson mMGridFootJson = new MGridFootJson();
					mMGridFootJson.setList(MMainGridFootService.parsePCTag(params,1));
					return mMGridFootJson;
				}
			}, new Callback<MGridFootJson>() {
				@Override
				public void onCallback(MGridFootJson result) {
					Gson gson = new Gson();
					WXBridgeManager.getInstance().callback(mWXSDKInstance.getInstanceId(), callback, gson.toJson(result));
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@WXModuleAnno(moduleMethod = true, runOnUIThread = true)
	public void tagtab(final String params, final String callback) {
		Log.d(TAG, "tagtab ========" + params);
		try {
			doAsync(new CallEarliest<MTabJson>() {
				@Override
				public void onCallEarliest() throws Exception {
				}
			}, new Callable<MTabJson>() {
				@Override
				public MTabJson call() throws Exception {
					MTabJson mMTabJson = new MTabJson();
					mMTabJson.setList(MTabService.parsePCTab(params));
					return mMTabJson;
				}
			}, new Callback<MTabJson>() {
				@Override
				public void onCallback(MTabJson result) {
					Gson gson = new Gson();
					WXBridgeManager.getInstance().callback(mWXSDKInstance.getInstanceId(), callback, gson.toJson(result));
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
