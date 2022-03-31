/**
 * @author Malaka Walpola 
 * @Email malaka.walpola@ufv.ca
 * Updated By:
 *@author Jon Steele
 *@Email jonwhsteele@gmail.com
 */
package intlist;


public interface SimpleIntegerListADT {
	
	/**
	 * Inserts the value into the end of the list. 
	 * @param value - value to be inserted.
	 * @return whether the operation was a success.
	 */
	public boolean add(int value);
	
	/**
	 * 
	 * @param index - Index the value to be placed. 
	 * @param value - value to be inserted.
	 * @return  whether the operation was a success.
	 * @throws IndexOutOfBoundsException if specified index is <0 OR > size().
	 */
	public boolean add(int index, int value) throws IndexOutOfBoundsException;
	
	/**
	 * Removes the specified value from the list (if exists).
	 * @param value - value to be removed.
	 * @return  whether the operation was a success.
	 */
	public boolean remove(int value);
	
	/**
	 * Removes and returns the value at the index (if exists).
	 * @param index - index of the item to be removed.
	 * @return the value removed from the list.
	 * @throws IndexOutOfBoundsException if index is less than 0 Or larger than the actual maximum index (size()-1).
	 */
	public int removeAt(int index) throws IndexOutOfBoundsException;
	
	
	/**
	 * Returns the value at the index (if exists).
	 * @param index - index of the item to be returned.
	 * @return the value at the specified index.
	 * @throws IndexOutOfBoundsException if index is less than 0 Or larger than the actual maximum index (size()-1). 
	 */
	public int get(int index) throws IndexOutOfBoundsException;
	
	/**
	 * 
	 * @param index - index of the item to be updated.
	 * @param value - new value.
	 * @return whether the operation was a success.
	 * @throws IndexOutOfBoundsException if index is less than 0 Or larger than the actual maximum index (size()-1).
	 */
	public boolean set(int index, int value) throws IndexOutOfBoundsException;
	
	/**
	 * Returns first index where given value is found in list (if exist).
	 * @param value - value to be searched.
	 * @return first index of the value or -1 if value does not exist.
	 */
	public int indexOf(int value);
	
	/**
	 * Returns whether the given value exists in the list.
	 * @param value - value to be searched.
	 * @return true if specified value is present in the list, false otherwise.
	 */
	public boolean contains(int value);
	
	/**
	 * Returns the number of elements in the list.
	 * @return the number of elements in the list.
	 */
	public int size();
	
	/**
	 * Removes all elements of the list.
	 */
	public void clear();
	
	/**
	 * Returns a string with all the values in the list (comma separated).
	 * @return a string with all the values in the list (comma separated).
	 */
	public String toString();
	
}
