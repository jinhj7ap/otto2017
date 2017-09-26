import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class AnalyzeKeyword {
	public static void main(String args[]) throws IOException {
		
		int Emergency = 0;
		
		//Input Keyword
		FileReader KeyFR = new FileReader("keyword.txt");
		BufferedReader KeyBR = new BufferedReader(KeyFR);
		
		String KeyStr[] = new String[100];
		
		try {
			int i = 0;
			while((KeyStr[i++] = KeyBR.readLine()) != null) {
				//System.out.println(KeyStr[i]);
			}
		} catch(Exception e) {}
		
		KeyBR.close();
		KeyFR.close();
		
		//Input RAW and anlyze keyword
		FileReader RawFR = new FileReader("RAW_1");
		BufferedReader RawBR = new BufferedReader(RawFR);
		
		String OriginRawStr = RawBR.readLine();
		String TokenRawStr[] = new String[100];
		
		StringTokenizer st = new StringTokenizer(OriginRawStr," ");
		int countTokens = st.countTokens();
		for(int i = 0; i < countTokens; i++) {
			TokenRawStr[i] = st.nextToken();
			//Compare Raw with Keyword
			for (int j = 0; KeyStr[j] != null; j++) {
				if(TokenRawStr[i].equals(KeyStr[j]) == true) {
					Emergency = 1;
					break;
				}
			}
			if(Emergency == 1) {
				break;
			}
		}

		RawBR.close();
		RawFR.close();
		
		//Sort out Emergency and Normal
		if (Emergency == 1) {
			//Emergency Situation is Here!
			System.out.println("Emergency situation !!");
			//
		}
		else {
			//General Situation is Here!
			System.out.println("Normal situation !!");
			//
		}
	}
}