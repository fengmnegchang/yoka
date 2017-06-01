package com.open.yoka.jsoup.m;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

import com.open.android.jsoup.CommonService;
import com.open.yoka.bean.m.MSwiperBean;
import com.open.yoka.utils.UrlUtils;

public class MSwiperService extends CommonService {
	public static final String TAG = MSwiperService.class.getSimpleName();

	public static List<MSwiperBean> parseIndexFocus(String href) {
		List<MSwiperBean> list = new ArrayList<MSwiperBean>();
		try {
			href = makeURL(href, new HashMap<String, Object>() {
				{
				}
			});
			Log.i(TAG, "url = " + href);

			Document doc = Jsoup.connect(href).userAgent(UrlUtils.yokaAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
//				Element globalnavElement = doc.select("div.adFocusHtml").first();
				Elements moduleElements = doc.select("div.swiper-slide");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						MSwiperBean sbean = new MSwiperBean();
						try {
							/**
							 *<div class="swiper-slide">
						         <a href="http://www.yoka.com/dna/m/d398249?shouye">
							 <img src="http://www.yoka.com/dna/pics/ba17a519/d3d3a7e3ecec375aaa.jpg">
							<em class="b"></em>
							<strong class="tit">休闲装我拒绝俗套路人感！</strong>
									<strong class="txt">这样穿让你舒服自在有腔调</strong>
							   </a>
						</div>

							 */
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									String hrefa = aElement.attr("href");
									Log.i(TAG, "i==" + i + ";hrefa==" + hrefa);
									sbean.setHref(hrefa);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

							try {
								Element imgElement = moduleElements.get(i).select("img").first();
								if (imgElement != null) {
									String src = imgElement.attr("src");
									Log.i(TAG, "i==" + i + ";src==" + src);
									sbean.setSrc(src);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

							try {
								Element imgElement = moduleElements.get(i).select("a").first();
								if (imgElement != null) {
									String alt = imgElement.text();
									Log.i(TAG, "i==" + i + ";alt==" + alt);
									sbean.setTitle(alt);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

						} catch (Exception e) {
							e.printStackTrace();
						}

						list.add(sbean);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//editPushs
			try {
				Element globalnavElement = doc.select("div.editPushs").first();
				Elements moduleElements = globalnavElement.select("li");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						MSwiperBean sbean = new MSwiperBean();
						try {
							/**
							<li><a href="http://www.yoka.com/dna/m/d397490">
            <img src="http://www.yoka.com/dna/pics/ba17a5a5/1/d3db9597c7ba7e1b5a.jpg">  
        <h1><strong>带货女王杨幂met gala翻车</strong></h1></a></li>
							 */
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									String hrefa = aElement.attr("href");
									Log.i(TAG, "i==" + i + ";hrefa==" + hrefa);
									sbean.setHref(hrefa);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

							try {
								Element imgElement = moduleElements.get(i).select("img").first();
								if (imgElement != null) {
									String src = imgElement.attr("src");
									Log.i(TAG, "i==" + i + ";src==" + src);
									sbean.setSrc(src);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

							try {
								Element imgElement = moduleElements.get(i).select("strong").first();
								if (imgElement != null) {
									String alt = imgElement.text();
									Log.i(TAG, "i==" + i + ";alt==" + alt);
									sbean.setTitle(alt);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

						} catch (Exception e) {
							e.printStackTrace();
						}

						list.add(sbean);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static List<MSwiperBean> parsePCFocus(String href) {
		List<MSwiperBean> list = new ArrayList<MSwiperBean>();
		try {
			href = makeURL(href, new HashMap<String, Object>() {
				{
				}
			});
			Log.i(TAG, "url = " + href);

			Document doc = Jsoup.connect(href).userAgent(UrlUtils.yokaAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("div.fFocus").first();
				Elements moduleElements = globalnavElement.select("div.item");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						MSwiperBean sbean = new MSwiperBean();
						try {
							/**
							 <div class="item on">
                <a href="http://www.yoka.com/fashion/windows/2017/0424/50569801076039.shtml">
                <img src="http://p2.yokacdn.com/pic/YOKA/2017-04-25/U10015P1TS1493118167_67067.jpg" alt="Slip Dress吊带裙太美了"></a>
                <a href="http://www.yoka.com/fashion/windows/2017/0424/50569801076039.shtml">
                  <dl class="tit">
                    <dt>Slip Dress吊带裙太美了</dt>
                    <dd> 难怪凯特-莫斯靠它一举成名</dd>
                  </dl>  
                </a>
              </div>
			<!-- AdSame ShowCode: YOKA女网 2017 / YOKA女网 街拍 / 街拍首页焦点图1 Begin -->
<script type="text/javascript" src="http://dolphin.yoka.com/s?z=yoka&c=874"  charset="gbk" ></script>
<!-- AdSame ShowCode: YOKA女网 2017 / YOKA女网 街拍 / 街拍首页焦点图1 End -->
							 */
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									String hrefa = aElement.attr("href");
									Log.i(TAG, "i==" + i + ";hrefa==" + hrefa);
									sbean.setHref(hrefa);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

							try {
								Element imgElement = moduleElements.get(i).select("img").first();
								if (imgElement != null) {
									String src = imgElement.attr("src");
									Log.i(TAG, "i==" + i + ";src==" + src);
									sbean.setSrc(src);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

							try {
								Element imgElement = moduleElements.get(i).select("dl.tit").first();
								if (imgElement != null) {
									String alt = imgElement.text();
									Log.i(TAG, "i==" + i + ";alt==" + alt);
									sbean.setTitle(alt);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

						} catch (Exception e) {
							e.printStackTrace();
						}

						list.add(sbean);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	 
}
