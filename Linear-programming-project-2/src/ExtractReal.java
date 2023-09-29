
import java.util.ArrayList;

public class ExtractReal {
	public static ArrayList<String>  parse(String line) {
        
        ArrayList<String> arr = new ArrayList<String>();
       
        int i=0;
        String input1="";
        for(int x=0;x<(line.length()-2);x++){
            char ch=line.charAt(x);
            char c2 =line.charAt(x + 2);
            char c1 =line.charAt(x + 1);
            String l = String.valueOf(ch);
            if(ch=='-'&&(c2>=48&&c2<=57)){
                input1 += String.valueOf(ch) + String.valueOf(c2);
                arr.add(input1);
            }
            else if(ch=='-' && (c1>=48&&c1<=57)){
            	//input1 += String.valueOf(c2); 
            	arr.add(String.valueOf(c1)); 
           }
            else if(ch=='+' && (c2>=48&&c2<=57)){
            	//input1 += String.valueOf(c2); 
            	arr.add(String.valueOf(c2)); 
           }
            else if(ch=='='&& ((c2>=65&&c2<=90)||(c2>=97&&c2<=122))) {
            	
            	//input1 += "1";
            	arr.add("1");
            }
            else if(ch=='='&& (c2>=48&&c2<=57)) {
            	
            	//input1 += "1";
            	arr.add(String.valueOf(c2));
            }
            else if(ch=='+' && !(ch>=48&&ch<=57) &&  ((c2>=65&&c2<=90)||(c2>=97&&c2<=122))) {
            	arr.add("1");
            }
            else if(ch=='-' && !(ch>=48&&ch<=57) &&  ((c2>=65&&c2<=90)||(c2>=97&&c2<=122))) {
            	arr.add("-1");
            }
            else if((ch>=48&&ch<=57) && (c1>=48&&c1<=57)) {
            	 
            	 input1 += String.valueOf(c1);
                 arr.add(input1);
            }
            
            }

            
       // if(!input1.equals("")){
           // arr.add(input1);
        //}
  

        return arr;
    }
}