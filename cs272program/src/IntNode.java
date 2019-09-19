import java.util.*;

public class IntNode {

	// instant variables
	private int data;
	private IntNode link;

	/**
	 * default constructor method makes an new object with initial values 0 and
	 * null.
	 */
	public IntNode() {
		data = 0;
		link = null;
	}// end constructor

	/**
	 * constructor method makes a new object with set data and link values.
	 * 
	 * @param data - the initial data
	 * @param link - the initial link
	 * 
	 */
	public IntNode(int data, IntNode link) {
		this.data = data;
		this.link = link;
	}// end constructor

	/**
	 * getData method gets the data within the object
	 * 
	 * @return data
	 */
	public int getData() {
		return data;
	}// end getData

	/**
	 * getLink method gets the link from the object
	 * 
	 * @return link
	 */
	public IntNode getLink() {
		return link;
	}// end getLink

	/**
	 * setData method sets the data within the object
	 * 
	 * @param newdata -the new data implemented
	 */
	public void setData(int newdata) {
		data = newdata;
	}

	/**
	 * setLink method sets the link within the object
	 * 
	 * @param newLink- the new Link implemented
	 */

	public void setLink(IntNode newLink) {
		link = newLink;
	}// end setLink

	/**
	 * toString method convert integer values to a string reference
	 * 
	 * @return sb - sb is the String of data.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder(" ");
		for (IntNode cursor = this; cursor != null; cursor = cursor.link) {
			sb.append(Integer.toString(cursor.data) + " -> ");

		} // end for loop
		return sb.toString();
	}// end toString

	/**
	 * addNodeAfterThis adds a node after the head of the object
	 * 
	 * @param newdata -
	 */
	public void addNodeAfterThis(int newdata) {
		link = new IntNode(newdata, link);
	}// addNodeAfterThis

	/**
	 * removeNodeAfterThis removes a node after the head of the object
	 */
	public void removeNodeAfterThis() {
		link = link.link;
	}// removeNodeAfterThis

	/**
	 * listLength retrieves the full size of the object
	 * 
	 * @param head
	 * @return total - the length.
	 */
	public static int listLength(IntNode head) {
		int total = 0;

		for (IntNode cursor = head; cursor != null; cursor = cursor.link) {
			total++;
		} // end for
		return total;
	}// end listLength

	/**
	 * search looks for specific variables within the object
	 * 
	 * @param head
	 * @param data
	 * @return true - when the item does exist in the data.
	 * @return false - when the item does not exist in the data.
	 * @precondition head is not null.
	 */
	public static boolean search(IntNode head, int data) {

		for (IntNode cursor = head; cursor != null; cursor = cursor.link) {
			if (cursor.getData() == data)

				return true;
		} // end for loop
		return false;
	}// end search

}// end class
