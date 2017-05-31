package com.open.yoka.jsoup.m;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

import com.open.android.jsoup.CommonService;
import com.open.yoka.bean.m.MGridFootBean;
import com.open.yoka.utils.UrlUtils;

public class MMainGridFootService extends CommonService {
	public static final String TAG = MMainGridFootService.class.getSimpleName();

	public static List<MGridFootBean> parseBox(String href,int pageNo) {
		List<MGridFootBean> list = new ArrayList<MGridFootBean>();
		try {
//			href = makeURL(href, new HashMap<String, Object>() {
//				{
//				}
//			});
			if(pageNo>1){
				href =href+"p"+pageNo;
			}
			Log.i(TAG, "url = " + href);

			Document doc = Jsoup.connect(href).userAgent(UrlUtils.yokaAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("div.imgNav").first();
				Elements moduleElements = globalnavElement.select("li");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						MGridFootBean sbean = new MGridFootBean();
						try {
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									String hrefa = UrlUtils.YOKA+aElement.attr("href");
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
									if(src==null || src.length()==0){
										src = imgElement.attr("_src");
									}
									Log.i(TAG, "i==" + i + ";src==" + src);
									sbean.setSrc(src);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

							try {
								Element imgElement = moduleElements.get(i).select("img").first();
								if (imgElement != null) {
									String alt = imgElement.attr("alt");
									Log.i(TAG, "i==" + i + ";alt==" + alt);
									sbean.setAlt(alt);
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
	
	public static List<MGridFootBean> parseTag(String href,int pageNo) {
		List<MGridFootBean> list = new ArrayList<MGridFootBean>();
		try {
//			href = makeURL(href, new HashMap<String, Object>() {
//				{
//				}
//			});
			 
			Document doc = Jsoup.connect(href).userAgent(UrlUtils.yokaAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("div.hotRecommends").first();
				Elements moduleElements = globalnavElement.select("div.tag").first().select("a");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						MGridFootBean sbean = new MGridFootBean();
						try {
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									String hrefa = UrlUtils.YOKA+aElement.attr("href");
									Log.i(TAG, "i==" + i + ";hrefa==" + hrefa);
									sbean.setHref(hrefa);
								}
							} catch (Exception e) {
								e.printStackTrace();
							}

							try {
								Element imgElement = moduleElements.get(i).select("a").first();
								if (imgElement != null) {
									String alt = imgElement.text();
									Log.i(TAG, "i==" + i + ";alt==" + alt);
									sbean.setAlt(alt);
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
