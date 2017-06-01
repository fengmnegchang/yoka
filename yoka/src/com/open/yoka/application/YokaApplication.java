/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-4-12下午3:32:17
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.application;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.open.yoka.adapter.weex.DefaultWebSocketAdapterFactory;
import com.open.yoka.adapter.weex.ImageAdapter;
import com.open.yoka.adapter.weex.WXHttpAdapter;
import com.taobao.weex.InitConfig;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-4-12下午3:32:17
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class YokaApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //创建默认的ImageLoader配置参数
        ImageLoaderConfiguration configuration =   new ImageLoaderConfiguration.Builder(this).threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator()).diskCacheSize(50 * 1024 * 1024) // 50 Mb
                .tasksProcessingOrder(QueueProcessingType.LIFO).writeDebugLogs() // Remove for release app
                .build();
        //Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(configuration);
        
        InitConfig config=new InitConfig.Builder().setHttpAdapter(new WXHttpAdapter()).setImgAdapter(new ImageAdapter()).setWebSocketAdapterFactory(new DefaultWebSocketAdapterFactory()).build();
        WXSDKEngine.initialize(this,config);
        try {
//			WXSDKEngine.registerModule("weexModule", WeexModule.class);
//			WXSDKEngine.registerModule("weexModalUIModule", WeexModalUIModule.class);
//			WXSDKEngine.registerModule("myModule", WXEventModule.class);
//			WXSDKEngine.registerModule("actionSheet", WXActionSheetModule.class);
//			 // 注册 webview module
//			WXSDKEngine.registerModule("mywebview", WeeXWebViewModule.class);
//	        // 注册 webview 组件
//			WXSDKEngine.registerComponent("web", WeeXWeb.class);
//			
//			WXSDKEngine.registerComponent("myinput", MyInput.class);
//			WXSDKEngine.registerComponent("myrichtext",RichText.class);
//			WXSDKEngine.registerComponent(
//				        new SimpleComponentHolder(
//				          WeeXSlider.class,
//				          new WeeXSlider.Creator()
//				        ),
//				        true,
//				       "mypager"
//				      );
//			WXSDKEngine.registerComponent(
//			        new SimpleComponentHolder(
//			        		WeeXText.class,
//			                new WeeXText.Creator()
//			              ),
//			              false,
//			              "mystockview"
//			            );
//			WXSDKEngine.registerDomObject("mystockview", WeeXTextDomObject.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}