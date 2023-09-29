
public class numberOf {

	static int numOf(String line,char someChar) {
		
		int count = 0;
		
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
		    if (c == someChar) {
		        count++;
		    }
		}
		return count;
	}
}
