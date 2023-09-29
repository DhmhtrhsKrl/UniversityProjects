import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> Lines = new ArrayList<String>();
		String maxormin = "";
		String vS = "";
		char dL ='0';
		String l = "";
		ArrayList<String> c = new ArrayList<String>();
		ArrayList<String> b = new ArrayList<String>();
		ArrayList<String> eqin= new ArrayList<String>();
		ArrayList<String> eqin2= new ArrayList<String>();
		ArrayList<String> dualConstraints= new ArrayList<String>();
		ArrayList<String> dualVariables= new ArrayList<String>();
		
		int numOfX = 0;
		int numOfV = 0;
		// TODO Auto-generated method stub
		try (BufferedReader br = new BufferedReader(new FileReader("File2.txt"))) {
		    String line;
		    int i=0;
		    while ((line = br.readLine()) != null ) {
		      Lines.add(line);
		      i++;
		      }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(Lines.get(0).contains("max")) {
			
			maxormin = "min";
			}
        if(Lines.get(0).contains("min")) {
			
			maxormin = "max";
			}
        for(int i=2; i<Lines.size()-1; i++)
		{
			eqin.add(Eqin.Eq(Lines.get(i)));
                 
		}
        String lineo[]=Lines.get(0).split("=");
        String line = Lines.get(0);
		vS = returnCharacter.reChar(line);
		
		char variableLetter = vS.toCharArray()[0];
        
		  int nocfirstline = numberOf.numOf(lineo[1],variableLetter);
		
		    l = Lines.get(0).replace("x1",vS);
		    for(int y=2; y<=nocfirstline; y++) {
			    String ln = vS + y;
			    l = l.replace(ln,vS);
			    
			   }
		    c.addAll(ExtractReal.parse(l));
		    numOfV = numberOf.numOf(Lines.get(2),variableLetter);
		    for(int k=3; k<Lines.size()-1; k++) {
		    	numOfX = numberOf.numOf(Lines.get(k),variableLetter);
		    	if(numOfV<numOfX) {
		    		numOfV=numOfX;
		    	}
		    }
		    
		    String[][] array = new String[Lines.size() - 3][numOfV];
		    String[][] arraytr = new String[numOfV][Lines.size() - 3];
		    ArrayList<Integer> zeroPosition = new ArrayList<Integer>();
		    ArrayList<Integer> nonZeroPosition = new ArrayList<Integer>();
		 for(int i=2; i<Lines.size()-1; i++) {
			 
			 
			 b.add(Lines.get(i).substring(Lines.get(i).lastIndexOf("=") + 1));
			 if(Lines.get(i).contains("+") ||  Lines.get(i).contains("-") ) {
				 nocfirstline = numberOf.numOf(Lines.get(i),variableLetter);
	        	   l = Lines.get(i).replace(vS+"1",vS);
	        	   String[] t = Lines.get(i).split("=");
	        	   String vt = t[0];
	        	   l=vt;
	        	   for(int y=1; y<=nocfirstline /*+ 1*/; y++) {
				    String ln = vS + y;
				    if(!Lines.get(i).contains(ln)) {
				    	zeroPosition.add(y);
				    }
				    else {
				    	nonZeroPosition.add(y);
				    }
				    l = l.replace(ln,vS);
				    } 
	        	   String grammh[] = l.split(vS);
	        	   int z = 0;
	        	   while( z<grammh.length-1) {
	        	     if(numOfV!=grammh.length - 1) {
	        	        for(int s=0; s<zeroPosition.size(); s++) {
	        	            array[i][zeroPosition.get(s)-1] ="0";
	        	        }
	        	        for(int s=0; s<nonZeroPosition.size(); s++) {
	        	        	grammh[z]=grammh[z].trim();
	        	        	if(grammh[z] =="+"+vS && grammh[z] =="+ "+vS) {
	        	        		array[i-2][nonZeroPosition.get(s)-1] = " ";
		        	            z++;
	        	        	}
	        	        	else if(grammh[z] =="-"+vS && grammh[z] =="- "+vS ) {
	        	        		array[i-2][nonZeroPosition.get(s)-1] = "-";
		        	            z++;
	        	        	}	
	        	        	else {	
	        	            array[i-2][nonZeroPosition.get(s)-1] = grammh[z];
	        	            z++;
	        	        	}
	        	        }
	        	     }
	        	     else {
	        	    	 grammh[z]=grammh[z].trim();
	        	        	if(grammh[z] =="+"+vS && grammh[z] =="+ "+vS) {
	        	        		array[i-2][z] = "";
		        	            z++;
	        	        	}
	        	        	else if(grammh[z] =="-"+vS && grammh[z] =="- "+vS) {
	        	        		array[i-2][z] = "-";
		        	            z++;
	        	        	}	
	        	        	else {	
	        	            array[i-2][z] = grammh[z];
	        	            z++;
	        	        	}
	        	    	
	        	     }
	        	}
				
	        }
			 zeroPosition.removeAll(zeroPosition);
			    nonZeroPosition.removeAll(nonZeroPosition);
			 
		 } 
		 transpose.tranp(array,arraytr, numOfV); 
		 
		 String[] lastLine = Lines.get(Lines.size()-1).split(",");
		 for(int r=0; r<lastLine.length; r++) {
			 eqin2.add(Eqin.Eq(lastLine[r]));
			 
		 }
		 
		 varToCon.constraint(maxormin,eqin2,dualConstraints);
		 ConToVar.variable(maxormin, eqin, dualVariables);
		 String dualForm = "";
		 dL = (char) (vS.charAt(0) + 1);
		 dualForm += maxormin + "z=";
		 dualForm +=b.get(0)+dL+(1)+" ";  
			
			 
		 
		 for(int q=1; q<b.size();q++) {
			if(b.get(q).contains("0")) {
				
			}
			else if(b.get(q).contains("-")){
				dualForm+=b.get(q)+dL+(q+1)+" ";  
			}
			else if(!b.get(q).contains("-")){
				dualForm+= " + "+b.get(q)+dL+(q+1)+" ";  
			}
			
			 
		 }
		 dualForm +="\n"+"st"+"\n";
		 ArrayList<String> tranp = new ArrayList<String>();
		 String helpert =""; 
		for(int z=0; z<arraytr.length; z++) { 
			for(int t=0; t< arraytr[z].length; t++) {
				if(Lines.get(z+2).contains(vS+(z+1))) {
					if(t==0){
					 helpert+=arraytr[z][t] + dL + (t+1);
					 
					}
					else if(t!=0 && arraytr[z][t].contains("-") ) {
						helpert += arraytr[z][t] + dL + (t+1);
						 	
						
					}
					else if(t!=0 && !arraytr[z][t].contains("-") && !arraytr[z][t].contains("+") ) {
						helpert+=" + " + arraytr[z][t] + dL + (t+1);
						
						
					}
					else if(t!=0 && arraytr[z][t].contains("+") ) {
						helpert+= " " + arraytr[z][t] + dL + (t+1);
					}
					
				}
				else {
					helpert+="   "; 	
				}
		         
				 }
			tranp.add(helpert);
			helpert = "";
		}
		int v=0;
		int m=0;
		String helper = "";
		for(int w=0; w<tranp.size(); w++) {
			if(Lines.get(0).contains(vS+(w+1))) {
			   helper = tranp.get(w);
			   helper += dualConstraints.get(v) + c.get(m);
			   tranp.set(w,helper); 
			   v++;
			   m++;
			}
			else {
				
				   helper = tranp.get(w);
				   helper += dualConstraints.get(v) + "0";
				   tranp.set(w, helper); 
				   v++;
				   m++;
				
			}
		}
		String varLine="";
		for(int o=0 ; o<dualVariables.size(); o++) {
		     if(!dualVariables.get(o).contains("unrestricted")) {
		    	
		    	 varLine+= String.valueOf(dL) + (o+1) + dualVariables.get(o) + " ";
		    	}
		    }		    	 
		   
			
		
		
		Writer writer = null;

		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("filename.txt"), "utf-8"));
		    writer.write(dualForm + "\n");
		    for(int r=0; r<tranp.size(); r++) {
		    	writer.write(tranp.get(r) +"\n");	
		    }
		    writer.write(varLine);
		} catch (IOException ex) {
		    // Report
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
	}

}
