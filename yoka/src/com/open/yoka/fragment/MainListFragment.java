/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-6-1上午10:37:06
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.yoka.fragment;

import android.support.v4.app.Fragment;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.open.yoka.R;
import com.open.yoka.adapter.m.MMainListBoxAdapter;
import com.open.yoka.fragment.m.MAdFocusViewPagerFragment;
import com.open.yoka.fragment.m.MMainExpendGridFootFragment;
import com.open.yoka.fragment.m.MMainListBoxFragment;
import com.open.yoka.fragment.m.MMainTagFragment;
import com.open.yoka.json.m.MListBoxJson;
import com.open.yoka.jsoup.m.MMainListBoxService;

/**
 ***************************************************************************************************************************************************************************** 
 * 
 * @author :fengguangjing
 * @createTime:2017-6-1上午10:37:06
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 ***************************************************************************************************************************************************************************** 
 */
public class MainListFragment extends MMainListBoxFragment {
	
	public static MainListFragment newInstance(String url, boolean isVisibleToUser) {
		MainListFragment fragment = new MainListFragment();
		fragment.setFragment(fragment);
		fragment.setUserVisibleHint(isVisibleToUser);
		fragment.url = url;
		return fragment;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.android.fragment.BaseV4Fragment#initValues()
	 */
	@Override
	public void initValues() {
		mMMainListBoxAdapter = new MMainListBoxAdapter(getActivity(), list);
		mPullToRefreshListView.setAdapter(mMMainListBoxAdapter);
		mPullToRefreshListView.setMode(Mode.PULL_FROM_START);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.open.enrz.fragment.BaseV4Fragment#call()
	 */
	@Override
	public MListBoxJson call() throws Exception {
		// TODO Auto-generated method stub
		MListBoxJson mMListBoxJson = new MListBoxJson();
		//http://brandservice.yoka.com/v1/?_c=cmsbrandindex&_a=getCmsForZhuNew&_moduleId=29&channel=23&column=103&skip=45&limit=15&p=2&callback=jsonpCallbackFunctionNo14962850979074116
		//jsonpCallbackFunctionNo14962852369915114({"count":"15","time":"2017-06-01 10:47:17","status":"true","restime":0,"context":[{"link":"http://www.yoka.com/fashion/edittj/2017/0313/50292801072402.shtml","title":"鞋柜需要升级了!春天到底是小白鞋时髦还是拖鞋好看?","picture":"http://p6.yokacdn.com/pic/YOKA/2017-03-13/U10018P1TS1489377007_38294.jpg"},{"link":"http://www.yoka.com/fashion/edittj/2017/0310/50285601072293.shtml","title":"垫肩外套2017年强势回归 入手一件来增加时髦气场吧","picture":"http://p1.yokacdn.com/pic/YOKA/2017-03-10/U10011P1TS1489133014_97007.jpg"},{"link":"http://www.yoka.com/fashion/edittj/2017/0310/50285401072288.shtml","title":"早春想时髦就得好色！快来认领让你一穿就美的流行色吧","picture":"http://p3.yokacdn.com/pic/YOKA/2017-03-10/U10011P1TS1489128648_31878.jpg"},{"link":"http://www.yoka.com/fashion/edittj/2017/0309/50275101072186.shtml","title":"看完刘雯用白衬衫搭印花半身裙，我也想马上来三条！","picture":"http://p7.yokacdn.com/pic/YOKA/2017-03-09/U10011P1TS1489046495_62915.jpg"},{"link":"http://www.yoka.com/fashion/edittj/2017/0309/50273901072169.shtml","title":"2017秋冬时装周趋势报告 为你严选8个时髦必get关键词","picture":"http://p5.yokacdn.com/pic/YOKA/2017-03-09/U10011P1TS1489030491_14959.jpg"},{"link":"http://www.yoka.com/fashion/edittj/2017/0306/pic50246901199799.shtml","title":"hold住鲜嫩又性感的桃色才是春天的打开方式！","picture":"http://p5.yokacdn.com/pic/YOKA/2017-03-06/U10011P1TS1488792516_80509.jpg"},{"link":"http://www.yoka.com/fashion/edittj/2017/0303/50226201071652.shtml","title":"都说春捂秋冻，要捂就学江疏影关晓彤用帅气皮夹克吧","picture":"http://p4.yokacdn.com/pic/YOKA/2017-03-03/U10011P1TS1488509448_53846.jpg"},{"link":"http://www.yoka.com/fashion/edittj/2017/0301/pic50204701196040.shtml","title":"杨幂唐嫣范冰冰女神标配，衬衫+半裙好搭又时髦","picture":"http://p5.yokacdn.com/pic/YOKA/2017-03-01/U10011P1TS1488337820_36373.jpg"},{"link":"http://www.yoka.com/fashion/edittj/2017/0301/pic50203601195720.shtml","title":"教你换季不吃土，最省钱的换季技巧全在这了！","picture":"http://p8.yokacdn.com/pic/YOKA/2017-03-01/U10011P1TS1488335575_32766.jpg"},{"link":"http://www.yoka.com/fashion/edittj/2017/0228/pic50194601195312.shtml","title":"2017开春最百搭单品！卫衣承包你的所有时髦搭配","picture":"http://p5.yokacdn.com/pic/YOKA/2017-02-28/U10011P1TS1488247697_14742.jpg"},{"link":"http://www.yoka.com/fashion/edittj/2017/0228/pic50193801195301.shtml","title":"长外套＋平底鞋，打造最简约高级的时髦混搭风！","picture":"http://p5.yokacdn.com/pic/YOKA/2017-02-28/U10011P1TS1488246309_26439.jpg"},{"link":"http://www.yoka.com/fashion/edittj/2017/0228/pic50193201195271.shtml","title":"春天来了，终于可以脱掉秋裤穿我爱的花裙子喽","picture":"http://p5.yokacdn.com/pic/YOKA/2017-02-28/U10011P1TS1488245810_99556.jpg"},{"link":"http://www.yoka.com/fashion/edittj/2017/0225/pic50176601192957.shtml","title":"2017秋冬米兰时装周Versace秀场","picture":"http://p5.yokacdn.com/pic/YOKA/2017-02-25/U10011P1TS1487993509_28197.jpg"},{"link":"http://www.yoka.com/fashion/edittj/2017/0222/pic50152301190456.shtml","title":"2017依然火炸天 让百变GIGI教你初春这样搭","picture":"http://p5.yokacdn.com/pic/YOKA/2017-02-22/U10011P1TS1487749329_58203.gif"},{"link":"http://www.yoka.com/fashion/edittj/2017/0222/pic50152101190445.shtml","title":"早春升温寒意未退，外套里搭件Slogan Tee最潮","picture":"http://p5.yokacdn.com/pic/YOKA/2017-02-22/U10011P1TS1487748887_64510.jpg"}],"isloading":1,"queryOffSet":"75"})
		mMListBoxJson.setList(MMainListBoxService.parseList(url,pageNo));
		return mMListBoxJson;
	}
}
