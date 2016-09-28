package spam;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;

public class SpamHam {
	
	public static void main(String [] args){
		
		 Map<String,String> spam=new ConcurrentHashMap<String,String>();
		 
		int spamfiles=0,hamfiles=0,spamwords=0,hamwords=0,mailwords=0;
		String sCurrentLine = null;
		try{
			
		  File f = new File("E:\\easy_ham_2");
          String a[];
          a=f.list(); 
          spamfiles=a.length;
          for (int i = 0; i <a.length; i++) {
				//System.out.println(a[i]);
				sCurrentLine= a[i];
				String fpath="E:\\easy_ham_2/"+sCurrentLine;
				
				 FileReader in = new FileReader(fpath);
				 BufferedReader brr = new BufferedReader(in);
				 String line = brr.readLine();
				 String[] linewords=null;
				
				  while (line!=null) {
				       // System.out.println(line);
				        linewords=line.split(" ");
				        int length = linewords.length;
				        for(int j=0;j<length;j++)
				        {
				        	String temp = null;
				        	int slength= spam.size();
				        	boolean containsNum = false;
				        	boolean containsonlyLetter = false;
				            if(linewords[j] != null && !linewords[j].isEmpty()){
				                for(char c : linewords[j].toCharArray()){
				                	
				                    if(containsNum = Character.isDigit(c)){
				                        break;
				                    }
				                    
				                }
				                for(char c : linewords[j].toCharArray()){
				                	
				                    if(containsonlyLetter = Character.isLetter(c)){
				                        
				                    }
				                    else{
				                    	containsonlyLetter=false;
				                    	break;
				                    }
				                    
				                }
				            }
				           
				            if(linewords[j].length()>2&& containsNum==false&&containsonlyLetter==true)
				        	{
				        	if(slength>0)
				        	{
				        		boolean isexisting=false;
				        		Iterator<String> it1=spam.keySet().iterator();
				                while(it1.hasNext()){
				                    String key = it1.next();
				                   // System.out.println(key); 
				                    //System.out.println(linewords[j]);
				        		if(linewords[j].equals(key))
				        		{
				        			
				        			isexisting=true;
				        			//system.out.println("if equal ");
				        			int count=Integer.parseInt(spam.get(key));
				        			//system.out.println(count);
				        			count++;
				        			//System.out.println(count);
				        			String incount=Integer.toString(count);
				        			spam.put(key, incount);
				        			//system.out.println(spam);
				        			
				        		}
				        			
				                	
				                }	
				        			
				        										
				        		
				        		if(isexisting==false)
				        		{
				        			//system.out.println(" not equal");
				        			temp=linewords[j].toLowerCase();
				        			spam.put(temp, "1");
				        			isexisting=false;
				        			//System.out.println(spam);
				        		}
				        		
				                }
				        	
				        
				        	 else
						        {
				        		 //system.out.println("starting only once");
						        	temp=linewords[j].toLowerCase();
				        			spam.put(temp, "1");
						        }
				        	}
				        }
				       //System.out.println(spam.size());
				        
				        line = brr.readLine();
				    }
				    in.close();
				    //System.out.println(spam.size());
				   // System.out.println(spam);
				
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		spamwords=spam.size();
		Map<String,String> ham=new ConcurrentHashMap<String,String>();
		
		try{
			
			  File f = new File("E:\\spam_2");
	          String a[];
	          a=f.list(); 
	          hamfiles=a.length;
	          for (int i = 0; i <a.length; i++) {
					//System.out.println(a[i]);
					sCurrentLine= a[i];
					String fpath="E:\\spam_2/"+sCurrentLine;
					
					 FileReader in = new FileReader(fpath);
					 BufferedReader brr = new BufferedReader(in);
					 String line = brr.readLine();
					 String[] linewords=null;
					
					  while (line!=null) {
					       // System.out.println(line);
					        linewords=line.split(" ");
					        int length = linewords.length;
					        for(int j=0;j<length;j++)
					        {
					        	String temp = null;
					        	int slength= ham.size();
					        	boolean containsNum = false;
					        	boolean containsonlyLetter = false;
					            if(linewords[j] != null && !linewords[j].isEmpty()){
					                for(char c : linewords[j].toCharArray()){
					                	
					                    if(containsNum = Character.isDigit(c)){
					                        break;
					                    }
					                    
					                }
					                for(char c : linewords[j].toCharArray()){
					                	
					                    if(containsonlyLetter = Character.isLetter(c)){
					                        
					                    }
					                    else{
					                    	containsonlyLetter=false;
					                    	break;
					                    }
					                    
					                }
					            }
					           
					            if(linewords[j].length()>2&& containsNum==false&&containsonlyLetter==true)
					        	{
					        	if(slength>0)
					        	{
					        		boolean isexisting=false;
					        		Iterator<String> it1=ham.keySet().iterator();
					                while(it1.hasNext()){
					                    String key = it1.next();
					                   // System.out.println(key); 
					                    //System.out.println(linewords[j]);
					        		if(linewords[j].equals(key))
					        		{
					        			
					        			isexisting=true;
					        			//system.out.println("if equal ");
					        			int count=Integer.parseInt(ham.get(key));
					        			//system.out.println(count);
					        			count++;
					        			//System.out.println(count);
					        			String incount=Integer.toString(count);
					        			ham.put(key, incount);
					        			//system.out.println(ham);
					        			
					        		}
					        			
					                	
					                }	
					        			
					        										
					        		
					        		if(isexisting==false)
					        		{
					        			//system.out.println(" not equal");
					        			temp=linewords[j].toLowerCase();
					        			ham.put(temp, "1");
					        			isexisting=false;
					        			//System.out.println(spam);
					        		}
					        		
					                }
					        	
					        
					        	 else
							        {
					        		 //system.out.println("starting only once");
							        	temp=linewords[j].toLowerCase();
					        			ham.put(temp, "1");
							        }
					        	}
					        }
					       //System.out.println(spam.size());
					        
					        line = brr.readLine();
					    }
					    in.close();
					    //System.out.println(spam.size());
					   // System.out.println(spam);
					
				}
	 
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		hamwords=ham.size();
		
		ArrayList<String> mylist = new ArrayList<String>();
		Iterator<String> it1=spam.keySet().iterator();
		 Iterator<String> it2=ham.keySet().iterator();
		 int hamcount=totalwordcount(ham);
		 int spamcount=totalwordcount(spam);
		 DecimalFormat df2 = new DecimalFormat("###.#####");
        while(it1.hasNext()){
        	boolean isexisting= false;
            String key1 = it1.next();
        while(it2.hasNext()){
            String key2 = it2.next();
            if(key1.equals(key2))
            {
            	int val=Integer.parseInt(spam.get(key1));
            	double spamfre=val+0.5;
            	
            	double spampro=Double.valueOf(df2.format(spamfre/((spamwords*0.5)+spamcount)));
            	int val2=Integer.parseInt(ham.get(key2));
            	double hamfre=val2+0.5;
            	
            	double hampro=Double.valueOf(df2.format( hamfre/((hamwords*0.5)+hamcount)));
            	
            String line=key1+"   "+spamfre+"   "+spampro+"   "+hamfre+"   "+hampro+"\n";
            mylist.add(line);
            ham.remove(key2);
            isexisting=true;
            }
        }
            if(isexisting==false){
            	int val=Integer.parseInt(spam.get(key1));
            	double spamfre=val+0.5;
            	
            	double spampro=Double.valueOf(df2.format(spamfre/((spamwords*0.5)+spamcount)));
            	int val2=0;
            	double hamfre=val2+0.5;
            	
            	double hampro=Double.valueOf(df2.format( hamfre/((hamwords*0.5)+hamcount)));
            	
            String line=key1+"   "+spamfre+"   "+spampro+"   "+hamfre+"   "+hampro+"\n";
            mylist.add(line);
            }
            
        
        }
        if (ham.size()>0)
        {
        	 Iterator<String> it2f=ham.keySet().iterator();
        	 while(it2f.hasNext()){
                 String key2 = it2f.next();
                 int val=0;
             	double spamfre=val+0.5;
             	
             	double spampro=Double.valueOf(df2.format(spamfre/((spamwords*0.5)+spamcount)));
             	int val2=Integer.parseInt(ham.get(key2));
             	double hamfre=val2+0.5;
             	
             	double hampro=Double.valueOf(df2.format( hamfre/((hamwords*0.5)+hamcount)));
             	
             String line=key2+"   "+spamfre+"   "+spampro+"   "+hamfre+"   "+hampro+"\n";
             mylist.add(line);
        	 }
        	 
        }
        
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileWriter("model.txt"));
            for (String text : mylist) {
                out.write(text);
            }             
        } catch (IOException e) {
            System.err.println("Caught IOException: " +  e.getMessage());

        }
        
	out.close();
	}
	public static int totalwordcount(Map<String,String> text){
		int count = 0;
		 Iterator<String> it=text.keySet().iterator();
	        while(it.hasNext()){
	            String key1 = it.next();
	            count=count+Integer.parseInt(text.get(key1));
	        }
		return count;
		
	}
	
	}
