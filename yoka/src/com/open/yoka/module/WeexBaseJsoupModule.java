/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-3-16下午4:04:12
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.module;

import android.content.Context;

import com.open.andenginetask.AsyncTaskUtils;
import com.open.andenginetask.CallEarliest;
import com.open.andenginetask.Callable;
import com.open.andenginetask.Callback;
import com.open.andenginetask.ProgressCallable;
import com.taobao.weex.common.WXModule;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-3-16下午4:04:12
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class WeexBaseJsoupModule<T> extends WXModule {
	
	/**
	 * 封装的asynctask方法，此方法没有进度框.
	 * 
	 * @param pCallEarliest
	 *            运行于主线程，最先执行此方法.
	 * @param mCallable
	 *            运行于异步线程,第二执行此方法.
	 * @param mCallback
	 *            运行于主线程,最后执行此方法.
	 */
	public <T> void doAsync(final CallEarliest<T> pCallEarliest, final Callable<T> mCallable, final Callback<T> mCallback) {
		AsyncTaskUtils.doAsync(pCallEarliest, mCallable, mCallback);
	}

	/**
	 * 封装的asynctask方法，此方法拥有进度对话框，并支持定义样式.
	 * 
	 * @param pContext
	 *            上下文
	 * @param styleID
	 *            对话框样式
	 *            ProgressDialog.STYLE_HORIZONTAL|ProgressDialog.STYLE_SPINNER
	 * @param pTitle
	 *            标题
	 * @param pMessage
	 *            内容
	 * @param pCallEarliest
	 *            运行于主线程，最先执行此方法.
	 * @param progressCallable
	 *            运行于异步线程,用于传递对话框进度.
	 * @param pCallback
	 *            运行于主线程,最后执行此方法.
	 */
	public <T> void doProgressAsync(final Context pContext, final int styleID, final String pTitleResID, final String pMessageResID, final CallEarliest<T> pCallEarliest,
			final ProgressCallable<T> pCallable, final Callback<T> pCallback) {

		AsyncTaskUtils.doProgressAsync(pContext, styleID, pTitleResID, pMessageResID, pCallEarliest, pCallable, pCallback);
	}

	/**
	 * 封装的asynctask方法，此方法拥有进度对话框，并支持定义样式.
	 * 
	 * @param pContext
	 *            上下文
	 * @param styleID
	 *            对话框样式
	 *            ProgressDialog.STYLE_HORIZONTAL|ProgressDialog.STYLE_SPINNER
	 * @param pTitle
	 *            标题,资源id
	 * @param pMessage
	 *            内容,资源id
	 * @param pCallEarliest
	 *            运行于主线程，最先执行此方法.
	 * @param progressCallable
	 *            运行于异步线程,用于传递对话框进度.
	 * @param pCallback
	 *            运行于主线程,最后执行此方法.
	 */
	public <T> void doProgressAsync(final Context pContext, final int styleID, final int pTitleResID, final int pMessageResID, final CallEarliest<T> pCallEarliest,
			final ProgressCallable<T> pCallable, final Callback<T> pCallback) {

		AsyncTaskUtils.doProgressAsync(pContext, styleID, pTitleResID, pMessageResID, pCallEarliest, pCallable, pCallback);
	}
	 
}
