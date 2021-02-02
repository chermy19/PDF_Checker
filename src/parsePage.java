import java.io.IOException;
import java.util.Vector;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class parsePage {
	
	getSize findPDF = new getSize();
	
	public Vector<String> crawlingGoogle(String URL){

		Vector<String> Links = new Vector<String>();
		
		try {
			Connection conn = Jsoup.connect(URL);
			Document html = conn.get();
			Elements searchedHtml = html.getElementsByClass("yuRUbf");
			for(Element each : searchedHtml) {
				String findedLink = each.child(0).attr("href");
				Links.add(findedLink);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return Links;
	}
	
	
	public String crawlingSite(String Link) {
		
		boolean isHere = false;
		
		try {
			Connection conn = Jsoup.connect(Link);
			Document html = conn.get();
			Elements hrefs = html.getElementsByAttribute("href");
			for(Element each : hrefs) {
				String[] temp = Link.split("/");
				String hrefOfSite = temp[0]+"//"+temp[2]+"/"+each.attr("href");
				String extension = hrefOfSite.substring(hrefOfSite.lastIndexOf(".")+1);
				if(extension.equals("pdf")) {
					isHere=true;
					return findPDF.findSize(hrefOfSite);
				}		
			}

		}catch(IOException e) {
			e.printStackTrace();
		}
		
		if(isHere == false)
			return ", None";
		else
			return "";
	}
	
}
