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
import com.open.yoka.bean.m.MListBoxBean;
import com.open.yoka.utils.UrlUtils;

public class MMainListBoxService extends CommonService {
	public static final String TAG = MMainListBoxService.class.getSimpleName();

	public static List<MListBoxBean> parseBox(String href) {
		List<MListBoxBean> list = new ArrayList<MListBoxBean>();
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
				Elements moduleElements = doc.select("dl.mListBox");
				if (moduleElements != null && moduleElements.size() > 0) {
					for (int i = 0; i < moduleElements.size(); i++) {
						MListBoxBean sbean = new MListBoxBean();
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
							
							try {
								Element imgElement = moduleElements.get(i).select("dd").first();
								if (imgElement != null) {
									String txt = imgElement.toString();
									Log.i(TAG, "i==" + i + ";txt==" + txt);
									sbean.setTxt(txt);
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
