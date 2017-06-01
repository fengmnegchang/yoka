/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-3-14下午5:50:51
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.adapter.weex;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Set;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXHttpAdapter;
import com.taobao.weex.common.WXRequest;
import com.taobao.weex.common.WXResponse;
import com.taobao.weex.utils.WXLogUtils;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-3-14下午5:50:51
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class WXHttpAdapter implements IWXHttpAdapter {

	@Override
	public void sendRequest(final WXRequest request, final OnHttpListener listener) {
		if (listener != null) {
			listener.onHttpStart();
		}
		Date data = new Date();
		// // 添加 header
		// request.paramMap.put("device-id", AuthUtil.getDeviceId());
		// request.paramMap.put("app-time", String.valueOf(data.getTime()));
		// request.paramMap.put("app-minorid", AuthUtil.getAppMinorId());
		// request.paramMap.put("app-id", AuthUtil.getAppId());
		// request.paramMap.put("user-agent", AuthUtil.getUserAgent());
          
		// 发起请求
		new Thread(new Runnable() {
			@Override
			public void run() {
				WXResponse response = new WXResponse();
				try {
					String charsetName = request.paramMap.get("charset");
					if(charsetName==null || charsetName.length()==0){
						charsetName="UTF-8";
					}
					HttpURLConnection connection = openConnection(request, listener);
					int responseCode = connection.getResponseCode();
					response.statusCode = String.valueOf(responseCode);
					if (responseCode == 200 || responseCode == 202) {
						response.originalData = readInputStream(connection.getInputStream(), charsetName,listener).getBytes();
					} else {
						response.errorMsg = readInputStream(connection.getErrorStream(), charsetName,listener);
					}
					if (listener != null) {
						listener.onHttpFinish(response);
					}
				} catch (IOException e) {
					e.printStackTrace();
					response.errorCode = "-1";
					response.errorMsg = e.getMessage();
					if (listener != null) {
						listener.onHttpFinish(response);
					}
				}
			}
		}).start();
	}

	private HttpURLConnection openConnection(WXRequest request, OnHttpListener listener) throws IOException {
		URL url = new URL(request.url);
		HttpURLConnection connection = createConnection(url);
		connection.setConnectTimeout(request.timeoutMs);
		connection.setReadTimeout(request.timeoutMs);
		connection.setUseCaches(false);
		connection.setDoInput(true);
		/* header */
		if (request.paramMap != null) {
			Set<String> keySets = request.paramMap.keySet();
			for (String key : keySets) {
				connection.addRequestProperty(key, request.paramMap.get(key).toString());
			}
		}

		/* method */
		String method = request.method;
		if (!TextUtils.isEmpty(method)) {
			connection.setRequestMethod(method);
			/* body */
			if (method.equals("POST")) {
				if (listener != null) {
					listener.onHttpUploadProgress(0);
				}
				DataOutputStream out = new DataOutputStream(connection.getOutputStream());
				out.write(request.body.getBytes());
				out.close();
				if (listener != null) {
					listener.onHttpUploadProgress(100);
				}
			}
		}
		return connection;
	}

	// 读取数据
	private String readInputStream(InputStream inputStream,String charsetName, OnHttpListener listener) {
		StringBuilder builder = new StringBuilder();
		try {
			if(charsetName==null || charsetName.length()==0){
				charsetName="UTF-8";
			}
			int fileLen = inputStream.available();
			BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(inputStream, charsetName));
			char[] data = new char[2048];
			int len;
			while ((len = localBufferedReader.read(data)) > 0) {
				builder.append(data, 0, len);
				if (listener != null && fileLen > 0) {
					listener.onHttpResponseProgress((builder.length() / fileLen) * 100);
				}
			}
			localBufferedReader.close();
			try {
				inputStream.close();
			} catch (IOException e) {
				WXLogUtils.e("DefaultWXHttpAdapter: " + WXLogUtils.getStackTrace(e));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String result = String.valueOf(builder);
		try {
			JSONObject jsonObject = JSON.parseObject(result);
			String data = jsonObject.getString("data");
			Log.d("result = ", jsonObject.toJSONString());
			return String.valueOf(jsonObject.toJSONString());
		} catch (Exception e) {
			Log.d("result = ", result);
			return result;
		}
	}

	protected HttpURLConnection createConnection(URL url) throws IOException {
		return (HttpURLConnection) url.openConnection();
	}

}
