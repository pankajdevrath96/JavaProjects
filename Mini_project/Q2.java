package Assignment_11;

import java.io.*;
import java.util.*;
class myList{
	 ArrayList<File> found(String str)throws IOException
	 {
		 ArrayList<File> f1=new ArrayList<>();
		 File dir=new File(str);
		 File listOfDirectory[]=dir.listFiles();
		 if(listOfDirectory==null)
			 System.out.print("files not present");
		 else
		 {
			 for(File e: listOfDirectory)
				 if(e.isDirectory())
				 {
					  ArrayList<File> f2=new ArrayList<>(found(e.toString()));
					 for(int i=0;i<f2.size();i++)
                         f1.add(f2.get(i));
				}
				 else if(e.isFile())
					 f1.add(e);		 
		 }	 
		return f1;
	}
 }
 class myCSV extends myList {
	 	
	 void csvFile(ArrayList<File> str) throws IOException {
	       
	            FileWriter f3 = new FileWriter(new File("file.csv"), true);
	            String str1 = "File Name,File Path\n";
	            for(int i=0;i<str.size();i++)
	                str1+=str.get(i).getName()+","+str.get(i).toString() +"\n"; 
	            for (int i = 0; i < str1.length(); i++)
	                f3.append(str1.charAt(i));
	            f3.close();
	            System.out.println("File is Created."); 
	        
	    }

		
}
 class showFile extends myCSV{
	  String currentLine;
	    BufferedReader br; 

	     void readFile(String fileName) throws IOException { 
	         br = new BufferedReader(new FileReader(fileName));
	         while ((currentLine = br.readLine()) != null) { 
	           String [] lineAfterSplit = currentLine.split(",");
	           System.out.println("Directory Name   :-->   "+  lineAfterSplit[0] + "   File Name  :-->    " + lineAfterSplit[1]);
	         } 
	     }
	    
	 
 }

public class Q2 {


	    public static void main(String[] args) throws IOException {
	        
	            Scanner sc = new Scanner(System.in);
	            File file = new File("abc.txt");
	            if(!file.exists())
	                file.createNewFile();
	            FileOutputStream fout = new FileOutputStream(file);
	            System.out.print("Enter the number of paths you want to traverse : ");
	            int n = sc.nextInt(); 
	            String str = "";
	            while(n>0){
	            	n--;
	                str+=sc.next();
	                str+="\n";
	        
	            } 
	            for(int i=0;i<str.length();i++)
	                fout.write(str.charAt(i));
	            String S;
	             
	            
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            
	            myCSV obj=new myCSV();
	            
	            while ((S = br.readLine()) != null)
	                obj.csvFile(obj.found(S));
	            System.out.println("Press--> 1 : To show the content of the file.\nPress--> 0 : to terminate.");
	            int x;
	            x=sc.nextInt();
	            if(x==0)
	            	System.out.println("Thanks, you terminated the program sucessfully.");
	            else
	            {
	            	showFile obj1=new showFile();
	            	 
	            //obj2.ReadCsvFile r1 = new obj2.ReadCsvFile();
	            String fileName = "/Users/macbook/eclipse-workspace/IntroToJavaCore/file.csv";
	             

	            try {
	                obj1.readFile(fileName);
	            } catch (IOException e) {
	                System.out.println("file not found");
	            }
	            }
	        
	    }

}
