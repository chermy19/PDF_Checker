import java.io.IOException;
import java.util.Vector;

public class checkExtension {
	
	getSize checkSize = new getSize();
	parsePage checkSite = new parsePage();
	
	public void check(Vector<String> Links) throws IOException {
		for(int i=0; i<Links.size(); i++) {
			String Link = Links.get(i);
			String isPDF = Link.substring(Link.lastIndexOf(".")+1);
			if(isPDF.equals("pdf")) {
				System.out.println("pdf : "+Link+" "+checkSize.findSize(Link));
			}else {
				System.out.println("site : "+Link+" "+checkSite.crawlingSite(Link));
			}
		}
	}
}
