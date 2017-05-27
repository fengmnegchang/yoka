package com.open.yoka.jsoup.m;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.util.Log;

import com.open.android.jsoup.CommonService;
import com.open.yoka.bean.m.MTabBean;
import com.open.yoka.utils.UrlUtils;

public class MTabService extends CommonService {
	public static final String TAG = MTabService.class.getSimpleName();

	public static List<MTabBean> parseTab(String href) {
		List<MTabBean> list = new ArrayList<MTabBean>();
		try {
			 
			Log.i(TAG, "url = " + href);

			Document doc = Jsoup.connect(href).userAgent(UrlUtils.yokaAgent).timeout(10000).get();
			// System.out.println(doc.toString());
			try {
				Element globalnavElement = doc.select("div.navBox").first();
				Elements moduleElements = globalnavElement.select("a");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						MTabBean sbean = new MTabBean();
						try {
							/**
							 */
							try {
								Element aElement = moduleElements.get(i).select("a").first();
								if (aElement != null) {
									String hrefa = aElement.attr("href");
									Log.i(TAG, "i==" + i + ";hrefa==" + hrefa);
									if(!hrefa.contains(UrlUtils.YOKA)){
										hrefa = UrlUtils.YOKA+hrefa;
									}
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
