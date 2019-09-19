import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class EmployeeSet {

		// instance variables
		Employee [] gente;
		int size;
		
		//default constructor 
		public EmployeeSet() {
			gente = new Employee [10];
			size = 0;
		}
		
		//copy constructor 
		public EmployeeSet(Object obj) {
			if (obj == null)
				return;
			if (obj instanceof EmployeeSet) {
				EmployeeSet em = (EmployeeSet) obj;
				this.gente = new Employee [em.gente.length];
				System.arraycopy(em.gente, 0,this.gente,0, em.size);
				this.size = em.size;
				
			} else {
				return;
			} // end else
		}// end copy 
		
		public int size() {
			return size;
		}// end size
		
		public int capacity() {
			return gente.length;
		}//end capacity
		
		public void add(Employee a) {
			ensureCapacity(size+1);
			gente[size++] = a;
		}// end of add
		
		public boolean contain(Employee a) {
			if (a == null)
				return false;
			for (int i =0; i < size; i++) {
				if (gente[i].equals(a))
				return true;
			}// end for
			return false;
			
		}// end contains
		
		public boolean remove(int eno) {
			for (int boo = 0; boo < size; boo++) {
				if (this.gente[boo].getNo() == eno) {
					this.gente[boo] = this.gente[--size];
					return true;
				}// end if 
			}// end for
			return false;
		}// end remove
		
		private void ensureCapacity(int miniumCapacity) {
			Employee [] masGente;
			if (gente.length < miniumCapacity) {
				masGente = new Employee[gente.length * 2];
				System.arraycopy(gente, 0, masGente, 0, size);
				gente = masGente;
			}// end if 
		}// end ensure
		
		public void noSorter() {
			Employee [] temp = new Employee[1];
			int n = size; 
	        for (int i = 0; i < n-1; i++) {
			for (int k=0; k < size-i-1; k++) {
				
				if(this.gente[k].getNo() > this.gente[k+1].getNo()) {
					temp[0] = this.gente[k];
					this.gente[k] = this.gente[k+1];
					this.gente[k+1] = temp[0];
				                
				    }//end if  
				}// end for
				}// end for 
			 
		}// sort 

		public void slideToTheRight(int ind, Employee [] loser, int loco) {
			ensureCapacity(size +1 );
			for (int i = loco-1; i>(loco-1) - ind; i--) {
				loser[i+1] = loser[i];
			}//end for loop
		}
		
		public void addOrdered(Employee a) {

			noSorter();
			for (int bug = 0; bug < size; bug++) {
				if (gente[bug].getNo() > a.getNo()) {
					slideToTheRight(bug, gente, size);
			
					ensureCapacity(size+1);
					size++;
					gente[bug] = a;
					return;
				}// end if
			}//end for
			add(a);
		}// end addOrdered
		
		
		public String toString() {
			Employee[] printArray = new Employee[size];
			System.arraycopy(this.gente, 0, printArray, 0, size);
			return "EmployeeSet: " + Arrays.toString(printArray);
		}

		public static void main(String [] args)  throws IOException {
			EmployeeSet workers = new EmployeeSet(); 
			EmployeeSet workers2 = new EmployeeSet();
			
			
			Employee juan = new Employee();
			Employee juan2 = new Employee();
			Employee juan3 = new Employee();
			
			

			juan.setName("Ziad Arafat");
			juan.setNo(698);
			juan.setAge(21);
			juan.setState("NM");
			juan.setZip(46128);
			
			juan2.setName("Keanu Reeves");
			juan2.setNo(964);
			juan2.setAge(55);
			juan2.setState("HI");
			juan2.setZip(96701);
			
			juan3.setName("Gabriel Herrera");
			juan3.setNo(200);
			juan3.setAge(19);
			juan3.setState("NM");
			juan3.setZip(88021);
			
			// test add method 
			workers.add(juan);
			workers.add(juan2);
			workers.add(juan3);
			
			//test sorter
			workers.noSorter();
			System.out.println("First Set: ");
			System.out.println(workers.toString());
			System.out.println(" ");
			
			//copy constructor 
			EmployeeSet workers3 = new EmployeeSet(workers);
			System.out.println("Second Set from  Copy: ");
			System.out.println(workers3.toString());
			System.out.println(" ");
			
			
			//new employee to test addOrdered 
			Employee addHer = new Employee();
			addHer.setName("Karina Gonzalez");
			addHer.setNo(799);
			addHer.setAge(19);
			addHer.setState("NM");
			addHer.setZip(87901);
			
			//test contain 
		System.out.println("Is Keanu Reeves in the first list?: " + 
			workers.contain(juan2));
			// test contain false
			System.out.println("Is Karina Gonzalez in the first list?: " + 
			workers.contain(addHer));
			System.out.println(" ");
			
			// test addOrdered
			workers.addOrdered(addHer);
			System.out.println("Set with added employee: ");
			System.out.println(workers.toString());
			System.out.println(" ");
			
			//test remove
			workers.remove(799);
			System.out.println("Set with a removed employee by num: ");
			System.out.println(workers.toString());
			System.out.println(" ");

		
			
			boolean firstLine = true;
			String row;
			BufferedReader csvReader = new BufferedReader(new FileReader
					("core_dataset.csv"));
			while ((row = csvReader.readLine()) != null) {
				Employee temp = new Employee();
			    String[] data = row.split(",");
			    //skip first line because of headers
			    if (firstLine) {
			    	firstLine = false;
			    	continue;
			    }// end if statement
			   
			    temp.setName(new String(data[0] + data[1]));
			    temp.setNo(Integer.parseInt(data[2]));
			    temp.setState(new String(data[3]));
			    temp.setZip(Integer.parseInt(data[4]));
			    temp.setAge(Integer.parseInt(data[6]));
			  workers2.add(temp);	
			   
			}// end while 
			csvReader.close();
			
			//test reader 
			System.out.println("Set Three: ");
			System.out.println(workers2.toString());
			System.out.println(" ");
			System.out.println("Size of Set Three: " + workers2.size());
			workers2.noSorter();
			System.out.println(" ");
			System.out.println("Set Three Sorted: ");
			System.out.println(workers2.toString());
			
			
			
		}// end of main 	
	
} // end of class 
