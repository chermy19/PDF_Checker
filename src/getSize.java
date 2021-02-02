import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class getSize {
	
	public String findSize(String link) throws IOException {
		
		URL url= new URL(link);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("HEAD");
		conn.setConnectTimeout(5000);
		conn.setReadTimeout(5000);
		
		double MegaBytes = (double) conn.getContentLength()/1048576;
		
		String display = ", size of pdf : "+ String.format("%.2f", MegaBytes) + "MBs";
		
		return display;
		
	}

}
