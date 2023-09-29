
public class returnCharacter {
  
	public static String reChar(String line) {
		String y = "";
		String vSymbol =""; 
		for(int a=97; a<=122; a++)
		{
		String equation =line.substring(line.indexOf("="));
		char X =(char) a;
		vSymbol = vSymbol + X;
		if(equation.contains(vSymbol)) {
			
			y = vSymbol;
			break;
		}
		vSymbol = "";
		}	
		return y;
	}
}