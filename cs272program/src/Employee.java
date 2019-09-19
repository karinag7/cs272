import java.util.*;

public class Employee {

	// instance variables
	private String name;
	private int no;
	private int age;
	private String state;
	private int zip;
	private int[] advisors;

	// default constructor
	public Employee() {
		name = null;
		no = 0;
		age = 0;
		state = null;
		zip = 0;
		advisors = null;

	}// end constructor

	// copy constructor
	public Employee(Object obj) {
		if (obj == null)
			return;
		if (obj instanceof Employee) {
			Employee em = (Employee) obj;
			this.name = new String(em.name);
			this.no = em.no;
			this.age = em.age;
			this.state = new String(em.state);
			this.zip = em.zip;
			this.advisors = em.advisors;
		} else {
			return;
		} // end else

	}// end of copy constructor

	// accessors for variables
	public String getName() {
		return name;
	}

	public int getNo() {
		return no;
	}

	public int getAge() {
		return age;
	}

	public String getState() {
		return state;
	}

	public int getZip() {
		return zip;
	}

	public int[] getAdvisors() {
		return advisors;
	}

	// mutators for variables
	public void setName(String nombre) {
		name = nombre;
	}

	public void setNo(int num) {
		if (num >= 0)
			no = num;
	}

	public void setAge(int year) {
		if (year >= 0)
			age = year;
	}

	public void setState(String where) {
		state = where;
	}

	public void setZip(int code) {
		if (code >= 0)
			zip = code;
	}

	public void setAdvisors(int[] list) {
		advisors = list;
	}

	// toString method
	public String toString() {
		return "Employee information: " + name + ", " + no + ", " + age + ", "
	+ state + ", " + zip + ", " + Arrays.toString(advisors) + ".";
	}// end toString

	// equals method
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		if (no != other.no)
			return false;
		return true;
	}// end equals method

	// bubble sort for advisors list
	public static void bubbleSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] < arr[j + 1]) {
					// swap arr[j+1] and arr[i]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				} // end if
	}// end bubble

	// static method
	public static int[] getAllAdvisors(Employee e1, Employee e2) {
		int[] total = new int[e1.getAdvisors().length + e2.getAdvisors().length];
		int[] grandTotal = new int[total.length];
		int k = 0;
		if (e1.advisors != null && e2.advisors != null) {

			for (int i = 0; i < e1.advisors.length; i++) {
				total[k] = e1.advisors[i];
				k++;
			} // end for loop

			for (int i = 0; i < e2.advisors.length; i++) {
				total[k] = e2.advisors[i];
				k++;
			} // end for loop

			// sort the array
			Arrays.sort(total);
			int a = total[total.length - 1];

			// remove the duplicates
			for (int hey = 0; hey < total.length - 1; hey++) {
				if (total[hey] == total[hey + 1]) {
					total[hey] = 0;

				} // end if

				// implement last element back to original.
				grandTotal[total.length - 1] = a;
				grandTotal[hey] = total[hey];
			} // end for statement

			// to only print the numbers != 0
			bubbleSort(grandTotal);

		} // end if null statement

		return grandTotal;

	}// end getAllAdvisors method

	public static void printAdvisors(int[] KO) {
		System.out.print("All Advisors: ");
		for (int j = 0; j < KO.length; j++) {
			if (KO[j] != 0)
				System.out.print(KO[j] + ", ");

		} // end for loop
		System.out.println(" ");
	}// end printAdviors

	// main method
	public static void main(String[] args) {
		Employee em1 = new Employee();
		Employee em2 = new Employee();
		int[] hey1 = { 1, 2, 3 };
		int[] hey2 = { 3, 4 };
		int[] hey3 = { 1, 2, 3 };

		// test mutators

		em1.setName("Karina Gonzalez");
		em1.setNo(799);
		em1.setAge(19);
		em1.setState("NM");
		em1.setZip(88011);
		em1.setAdvisors(hey1);

		em2.setName("Cassandra Mendez");
		em2.setNo(900);
		em2.setAge(18);
		em2.setState("TX");
		em2.setZip(79903);
		em2.setAdvisors(hey2);

		// test copy constructor
		Employee em3 = new Employee(em2);

		// toString test
		System.out.println("First Two Employees:");
		System.out.println(em1.toString());
		System.out.println(em2.toString());

		// static method test
		printAdvisors(Employee.getAllAdvisors(em1, em2));

		System.out.println("Testing the copy constructor:");
		System.out.println(em3.toString());

		// changing em2 to further test the constructor
		em2.setName("Mary Jane");
		em2.setNo(420);
		em2.setAge(21);
		em2.setState("CA");
		em2.setZip(7852);
		em2.setAdvisors(hey3);

		// print to see if em3 is changed also
		System.out.println(em2.toString());
		System.out.println(em3.toString());

		// test equals method
		System.out.println("Test the eqaul method:");
		System.out.print("Employee 1 & 2:");
		System.out.println(em1.equals(em2));

		// set new employee to test the true
		Employee lastEm = new Employee(em3);
		System.out.print("Employee 3 & 4:");
		System.out.println(em3.equals(lastEm));

	}// end main

}// end class
