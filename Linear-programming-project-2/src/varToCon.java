import java.util.ArrayList;

public class varToCon {
	
	public static void constraint(String maxormin,ArrayList<String> eqin2,ArrayList<String> dualConstraints) {
		
		if(maxormin.equals("min")) {
			 for(int i=0; i<eqin2.size(); i++) {	
				 if(eqin2.get(i).contains("+")) {
					 dualConstraints.add(">=");
				 }
				   //else if(eqin2.contains("0")) {}
				  else if(eqin2.get(i).contains("-")) {
					  dualConstraints.add("<="); 
				  }
				   else if(eqin2.get(i).contains("2")) {
					   dualConstraints.add("=");  
				   }
			
			
		}
	  }	
		else if(maxormin.equals("max")) {
			 for(int i=0; i<eqin2.size(); i++) {	
			   if(eqin2.get(i).contains("+")) {
				   dualConstraints.add("<="); 
			   }
			   //else if(eqin2.contains("0")) {}
			   else if(eqin2.get(i).contains("-")) {
				   dualConstraints.add(">=");
			   }
			   else if(eqin2.get(i).contains("2")) {
				   dualConstraints.add("=");
			   }
		}
	  }	
	}


}
