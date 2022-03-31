/**
 * @author Malaka Walpola 
 * @Email malaka.walpola@ufv.ca
 * Updated By:
 *@author Jon Steele
 *@Email jonwhsteele@gmail.com
 */
package intlist;

public class LinkedIntegerList implements SimpleIntegerListADT {

	//Instance variables
	private IntegerNode head;
	private int itemCount;

	/**
	 * Default constructor.
	 */
	public LinkedIntegerList() {
		super();
		this.head = null;
		this.itemCount = 0;
	}

	@Override
	public boolean add(int value) {
		IntegerNode newNode = new IntegerNode(value);
		if(null == this.head) { //Adding to empty list
			this.head = newNode; //Set new node as head
			this.itemCount = 1; //Set item count to 1
			return true;
		}
		else {
			//Find the last node.
			IntegerNode currNode = this.head;
			//Last node does not have a next node (null). Therefore, update the currNode to current nodes' next while it is not null.
			while(null != currNode.getNext()) 
				currNode = currNode.getNext();
			//Set next of last node to new node.
			currNode.setNext(newNode);
			//Increment item count
			this.itemCount++;
			return true;
		}
	}

	@Override
	public boolean add(int index, int value) throws IndexOutOfBoundsException {
		//Check the validity of index.
		if(index < 0 || index > itemCount)
			throw new IndexOutOfBoundsException("The specified index (" + index + ") is not not valid. Index should be between 0 and " + this.itemCount);
		else if(0 == index){ //Add new value as the first (head) element
			IntegerNode newNode = new IntegerNode(value);
			//Update the next node of new node as the current head node
			newNode.setNext(this.head); 
			//Update the head to point to this node
			this.head = newNode;
			//Increment item count
			this.itemCount++;
			return true;
		}
		else {
			IntegerNode newNode = new IntegerNode(value);
			//Find the node at location index-1
			IntegerNode currNode = this.head;
			for(int i=1; i<index; i++) //Note here i goes from 1 to index-1
				currNode = currNode.getNext();
			//Update the new node to point to the next node of the current node.
			newNode.setNext(currNode.getNext());
			//Update the current node to point to the new node.
			currNode.setNext(newNode);
			//Increment item count
			this.itemCount++;
			return true;
		}
	}

	/**
	 * This method removes the desired value from the linked list.
	 * @author Jon Steele
	 * @email jonwhsteele@gmail.com
	 */
	@Override
	public boolean remove(int value) {

		IntegerNode currNode = this.head; //<---- currNode and prevNode are used to locate the removal node
		IntegerNode prevNode = null;

			//if the head is equal to the value, it will delete the head, and assign the new
			//head to the next Node in the list, "deleting" the removal value
			if (currNode.getValue() == value) {
				head = currNode.getNext();
				itemCount--;
				return true;
			}
			
			//I iterate through each node until I find the node to be removed, and record it,
			//along with the previous node.
			while (currNode.getNext() != null) {
				prevNode = currNode;
				currNode = currNode.getNext();
				if (currNode.getValue() == value)
					break;
			}
			
			//If the value is found, and the item to delete is not the last item in list
			if (currNode.getNext() != null && currNode.getValue() == value) {
			prevNode.setNext(currNode.getNext());
			itemCount--;
			return true;
			}
			
			//if the value is found, and the item to delete is the last item
			if (currNode.getNext() == null && currNode.getValue() == value) {
			prevNode.setNext(null);//<------ here we "delete" the final item by removing it from the chain
			itemCount--;
			return true;
			}
			
			//if the method gets this far, the value was not found, and returns false.
			System.out.println("Value: " + value +" was not found in linked list, and therefore could not be removed");
			return false;
	}
	/**
	 * This method will accept an index relating to the linked list, and will remove the 
	 * node that exists at that index
	 * 
	 * @author Jon Steele
	 * @email jonwhsteele@gmail.com
	 */
	@Override
	public int removeAt(int index) throws IndexOutOfBoundsException {
		
		//Check the validity of index.
		if( index < 0 || index >= this.itemCount) 
			throw new IndexOutOfBoundsException("The specified index (" + index + ") is not present in the list. Number of items present in the list is " + this.itemCount);
		
		IntegerNode currNode = this.head;
		IntegerNode prevNode = null;
		IntegerNode returnNode = null; 
		
		//if the linked list is empty, returns 0
		if (currNode == null)
			return 0;
		
		//if index is 0, and there is a next value
		if (index == 0) {
			head = head.getNext();
			itemCount--;
			return currNode.getValue();
		}
		
		//iterates until currNode is equal to the node at index, and prevNode is the
		//node behind it in the list
		for (int i = 0; i < (index-1); i++) {
			prevNode = currNode;
			currNode = currNode.getNext();	
		}
		
		returnNode = currNode;
		
		//This will remove the node at the index
		prevNode.setNext(currNode.getNext());
		itemCount--;
		
		return returnNode.getValue();
	}

	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		
		//Check the validity of index.
		if( index < 0 || index >= this.itemCount) 
			throw new IndexOutOfBoundsException("The specified index (" + index + ") is not present in the list. Number of items present in the list is " + this.itemCount);
		
		//Get the Node at the index.
		IntegerNode currNode = this.head;
		for(int i=0; i<index; i++) //Note here i goes from 0 to index-1
			currNode = currNode.getNext();
		
		//return the value of the node.
		return currNode.getValue();
	}

	/**
	 * This method will accept an index and value, and then insert the value at the desired index
	 * @author Jon Steele
	 * @email jonwhsteele@gmail.com
	 */
	@Override
	public boolean set(int index, int value) throws IndexOutOfBoundsException {
		
		//Check the validity of index.
		if( index < 0 || index > (this.itemCount)) 
			throw new IndexOutOfBoundsException("The specified index (" + index + ") is not present in the list. Number of items present in the list is " + this.itemCount);
		
		IntegerNode currNode = this.head;
		IntegerNode prevNode = null;
		IntegerNode insertion = new IntegerNode(value, null);
		
		//if the linked list is empty, and index  = 0, makes a new head equal to the value
		if (index == 0 && itemCount == 0) {
			head = insertion;
			itemCount++;
			return true;
		}
		
		//if index is 0, and there is one or more nodes in the list
		if (index == 0 && itemCount >= 1) {
			head = insertion;//<--- New head becomes the inserted node
			head.setNext(currNode);//<--- old head becomes the next node
			itemCount++;
			return true;
		}
		
		//if the index is greater than 0, and index is not the last element in list
		if (index < itemCount && index > 0) {
			
			//iterates until currNode is equal to the node at index, and prevNode is the
			//node behind it in the list
			for (int i = 0; i < (index); i++) {
				prevNode = currNode;
				currNode = currNode.getNext();	
			}
			
			//Once we have the nodes that come before and at the index we want to insert at,
			//we can create a new node and link it to the adjacent nodes
			prevNode.setNext(insertion);
			insertion.setNext(currNode);
			itemCount++;
			return true;
		}
		
		//This is for when user inserts at the end of the list ie index == itemCount
		if (index == itemCount && index > 0) {
			
			//iterating until we find the last node
			for (int i = 0; i < (index-1); i++) {
				currNode = currNode.getNext();	
			}
			currNode.setNext(insertion);
			itemCount++;
			return true;
		}
		
		return false;
	}

	/**
	 * This method accepts a value, and will return the index of the value if it exists inside
	 * of the linked list. If not, it will return 0 and print a message saying it wasn't found
	 * @author Jon Steele
	 * @email jonwhsteele@gmail.com
	 */
	@Override
	public int indexOf(int value) {
	
		IntegerNode currNode = this.head;
		boolean valueFound = false;
		int index = 0;
		
		//iterates through nodes until the value is found. It then returns the value's index
		for (int i = 0; i < itemCount; i++) {
		
			if (currNode.getValue() == value) {
				valueFound = true;
				return index;
			}
			currNode = currNode.getNext();
			index++;
		}
		
		if (valueFound == false){
			System.out.println("Value: "+value+" was not found in the linked list.");
			return 0;
		}
		return 0;
	}

	@Override
	public boolean contains(int value) {
		//Search using the indexOf method.
		if(this.indexOf(value) >= 0)
			return true;
		//Item not found.
		return false;
	}

	@Override
	public int size() {
		return this.itemCount;
	}

	@Override
	public void clear() {
		this.head = null;
		this.itemCount = 0;
	}

	@Override
	public String toString() {
		if(null == this.head || 0 == this.itemCount)
			return "List is empty!";
		String retVal = "List Items (Count: " + this.itemCount + "): ";
		IntegerNode currNode = this.head;
		while(null != currNode) {
			retVal += currNode.getValue() + ", ";
			currNode = currNode.getNext();
		}
		return retVal.substring(0, retVal.length()-2);
	}
}
