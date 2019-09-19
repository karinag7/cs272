
public class IntNodeTest {

	public static void main(String[] args) {
		IntNode loser = new IntNode(5, null);
	
		System.out.println("Intial Test:" +loser.toString());
		loser.addNodeAfterThis(15);
		System.out.println("Added 15:" + loser.toString());
		System.out.println("The length with addition:" 
				+ IntNode.listLength(loser));   
		loser.removeNodeAfterThis();
		System.out.println("Removed 15:" + loser.toString());
		
		System.out.println("The length after removal:" 
		+ IntNode.listLength(loser));
		System.out.println("Search 5:" + IntNode.search(loser, 5));
		System.out.println("Search 7:" + IntNode.search(loser, 7));
	}// end main 

}// end class
