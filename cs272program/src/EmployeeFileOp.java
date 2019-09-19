
import java.io.*;

public class EmployeeFileOp {
	public static void main(String []args) throws IOException { 
		String Fname = "core_dataset.csv";
		read(Fname);
		String filePath = "young_employee.csv";
		write(Fname, filePath);
	}// end main 
	
	public static void read(String Fname) { 
		String line = "";
		String cvsSplitBy = ",";
		String FirstLine = "Employee Name, Employee Number, State, Zip, Age, and Sex";
				
		try { FileReader fileReader = new FileReader(Fname);
		
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		bufferedReader.readLine();
		System.out.println(FirstLine);
		while ((line = bufferedReader.readLine()) != null) {
			String[] country = line.split(cvsSplitBy);
			if (country.length > 0) { 
			
			//if (Integer.parseInt(country[6]) <= 30)
			//If statement above would only print out the employees < 30 years on console. 
			//Could not implement in writer. 
			
			System.out.println(country[0] + country[1] + " "+ country[2]+ " " + country[3] + " " +
					country[4] + " " + country[6] + " " + country[7]);
			} //end if  
			     			
		} // end while 
		
		bufferedReader.close(); 
		} //end try 
		
		catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" +  Fname + "'");                
        }//end catch 
		catch(IOException ex) {
            System.out.println("Error reading file '" + Fname + "'");                  
        }//end catch 
		System.out.println("Finish reading pairs from file "+ Fname);
	}// end read 
	
	public static void write(String Fname, String filePath) throws IOException {
		BufferedReader inputStream = null; 
		PrintWriter outputStream = null;
		String FirstLine = "Employee Name, Employee Number, State, Zip, Age, and Sex";
	
		try { FileReader fileReader = new FileReader(Fname);
				File file = new File(filePath);
				
				inputStream = new BufferedReader(new FileReader(Fname));
				outputStream = new PrintWriter(new FileWriter(filePath)); 
		
			String line; 	
			while ((line = inputStream.readLine()) != null  ) {
				
			outputStream.println(line);
		}// end while 
		
		} finally {
		   if (inputStream != null) {
			inputStream.close();   
		}// end if 
		   if(outputStream != null) {
			   outputStream.close();
		 }// end if 
				
			
		System.out.println("Finish writing pairs to file "+ filePath);	
		inputStream.close();
		outputStream.close();
		}// end try 
		
	} //end write 
			
				      			
} // end class  

