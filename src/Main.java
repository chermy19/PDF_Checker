import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		parsePage loadPages = new parsePage();
		checkExtension findExtension = new checkExtension();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Insert Google URL below");
		String URL = sc.next();
		Vector<String> Links = loadPages.crawlingGoogle(URL);
		findExtension.check(Links);
	}

}
