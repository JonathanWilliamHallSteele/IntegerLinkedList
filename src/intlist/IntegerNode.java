/**
 * @author Malaka Walpola 
 * @Email malaka.walpola@ufv.ca
 * * Updated By:
 *@author Jon Steele
 *@Email jonwhsteele@gmail.com
 */
package intlist;

public class IntegerNode {
	//Instance variables
	private int value;
	private IntegerNode next;
	
	//Accessors and Mutators
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public IntegerNode getNext() {
		return next;
	}
	public void setNext(IntegerNode next) {
		this.next = next;
	}
	
	//Constructors
	public IntegerNode(int value, IntegerNode next) {
		super();
		this.value = value;
		this.next = next;
	}
	public IntegerNode(int value) {
		super();
		this.value = value;
		this.next = null;
	}
	public IntegerNode() {
		super();
		this.next = null;
	}
}

