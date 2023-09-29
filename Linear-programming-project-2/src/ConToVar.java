import java.util.ArrayList;

public class ConToVar {

public static void variable(String maxormin,ArrayList<String> eqin,ArrayList<String> dualVariable) {

	if(maxormin.equals("min")) {
		 for(int i=0; i<eqin.size(); i++) {	
			 if(eqin.get(i).contains("+")) {
				 dualVariable.add("<=0");
			 }
			   else if(eqin.get(i).contains("0")) {
				   dualVariable.add("unrestricted");
			   }
			   else if(eqin.get(i).contains("-")) {
				   dualVariable.add(">=0");
			   }
			   //else if(eqin.contains("2")) {}
		
		
	}
  }	
	else if(maxormin.equals("max")) {
		 for(int i=0; i<eqin.size(); i++) {	
		   if(eqin.get(i).contains("+")) {
			   dualVariable.add(">=0");
		   }
		   else if(eqin.get(i).contains("0")) {
			   dualVariable.add("unrestricted");
		   }
		   else if(eqin.get(i).contains("-")) {
			   dualVariable.add("<=0");
		   }
		   //else if(eqin.contains("2")) {}
	}
  }	
		
}
}
