/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-1下午3:24:01
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.activity.weex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-1下午3:24:01
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class WeexNavigatorActivity  extends  FragmentActivity implements IWXRenderListener {

	public WXSDKInstance mWXSDKInstance;
	private Map<String, Object> options = new HashMap<String, Object>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWXSDKInstance = new WXSDKInstance(this);
        mWXSDKInstance.registerRenderListener(this);
        /**
         * Intent { act=android.intent.action.VIEW 
         * cat=[com.taobao.android.intent.category.WEEX] 
         * dat=http://192.168.1.15:8080/... (has extras) }
         */
        String action = getIntent().getAction();
        if(Intent.ACTION_VIEW.equals(action)){
        	String data = getIntent().getDataString();
        	String weoptions = null;
        	if (getIntent().getExtras() != null) {
				weoptions = getIntent().getExtras().getString("options");
				try {
					if (weoptions != null && weoptions.length() > 0) {
						Log.d("weoptions", weoptions);
						JSONObject jsonObject;
						jsonObject = new JSONObject(weoptions);
						if (jsonObject != null) {
							Iterator<String> iterator = jsonObject.keys();
							while (iterator.hasNext()) {
								String key = (String) iterator.next();
								String value = jsonObject.getString(key);
								options.put(key, value);
							}
						}
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
            mWXSDKInstance.renderByUrl("MyApplication",data,options, null, -1, -1, WXRenderStrategy.APPEND_ASYNC);
        }
    }

    @Override
    public void onViewCreated(WXSDKInstance instance, View view) {
        setContentView(view);
    }

    @Override
    public void onRenderSuccess(WXSDKInstance instance, int width, int height) {

    }

    @Override
    public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {

    }

    @Override
    public void onException(WXSDKInstance instance, String errCode, String msg) {

    }


    @Override
    protected void onResume() {
        super.onResume();
        if (mWXSDKInstance != null) {
            mWXSDKInstance.onActivityResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mWXSDKInstance != null) {
            mWXSDKInstance.onActivityPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mWXSDKInstance != null) {
            mWXSDKInstance.onActivityStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mWXSDKInstance != null) {
            mWXSDKInstance.onActivityDestroy();
        }
    }
}