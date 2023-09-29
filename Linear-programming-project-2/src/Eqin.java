
public class Eqin {

	public static String Eq(String line) {
		String j = "0";
		  if(!line.contains("<") && !line.contains(">") && line.contains("=")) {
	    	  
	    	  j = "0";
	      }
	      if(line.contains("<") && line.contains("=")) {
	    	 j = "-1";
	      }
	      if(line.contains(">") && line.contains("=")) {
	    	 j = "+1";
	      }
          if(!line.contains("<") && !line.contains(">") && !line.contains("=")) {
	    	  
	    	  j = "2";
	      }
		  
		return j;
		
	}
}
