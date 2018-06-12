package lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import frame.Entry;

/*
 * Implements a Hash-Table structure as introduced in the 
 * lecture to store the information read by the RFID 
 * readers in the library.
 *	
 * Make sure that you have tested all the given test cases
 * given on the homepage before you submit your solution.
 *
 */

public class HashTable {

	private String hashFunc;
	private String collisionRes;
	private int capacity;
	private Entry[] newHashtable;

	/**
	 * The constructor
	 * 
	 * @param initialCapacity
	 *            represents the initial size of the Hash Table.
	 * @param hashFunction
	 *            can have the following values: division folding mid_square
	 * @param collisionResolution
	 *            can have the following values: linear_probing quadratic_probing
	 * 
	 *            The Hash-Table itself should be implemented as an array of entries
	 *            (Entry[] in Java) and no other implementation will be accepted.
	 *            When the load factor exceeds 75%, the capacity of the Hash-Table
	 *            should be increased as described in the method rehash below. We
	 *            assume a bucket factor of 1.
	 */
	public HashTable(int k, String hashFunction, String collisionResolution) {

		this.hashFunc = hashFunction;
		this.collisionRes = collisionResolution;
		this.capacity = k;
		this.newHashtable = new Entry[k];

	}

	/**
	 * This method takes as input the name of a file containing a sequence of
	 * entries that should be inserted into the Hash-Table in the order they appear
	 * in the file. You cannot make any assumptions on the order of the entries nor
	 * is it allowed to change the order given in the file. You can assume that the
	 * file is located in the same directory as the executable program. The input
	 * file is similar to the input file for lab 1. The return value is the number
	 * of entries successfully inserted into the Hash-Table.
	 * 
	 * @param filename
	 *            name of the file containing the entries
	 * @return returns the number of entries successfully inserted in the
	 *         Hash-Table.
	 */
	public int loadFromFile(String filename) {
		/**
		 * Add your code here
		 */
		int counter = 0;
		String[] para = new String[3];
		Entry data;
		FileReader file;
		BufferedReader br;
		String line;
		try {
			file = new FileReader(filename);
			br = new BufferedReader(file);

			while ((line = br.readLine()) != null) {
				para = line.split(";");
				data = new Entry(para[0], para[1], para[2]);
				insert(data);
				counter++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return counter;

	}

	/**
	 * This method inserts the entry insertEntry into the Hash-Table. Note that you
	 * have to deal with collisions if you want to insert an entry into a slot which
	 * is not empty. This method returns true if the insertion of the entry
	 * insertEntry is successful and false if the key of this entry already exists
	 * in the Hash-Table (the existing key/value pair is left unchanged).
	 * 
	 * @param insertEntry
	 *            entry to insert into the Hash-table
	 * @return returns true if the entry insertEntry is successfully inserted false
	 *         if the entry already exists in the Hash-Table
	 */
	public boolean insert(Entry insertEntry) {
		/**
		 * Add your code here
		 */
		if (hashFunc.equals("division")) {
			int[] divisionValueInt = new int[5];
			char[] divisionValueChar = insertEntry.getKey().substring(0, 5).toCharArray();
			long divisionValueLong;
			int finalValue; 
			for (int i = 0; i <= 4; i++) {
				divisionValueInt[i] = divisionValueChar[i];
				
			}
			

			divisionValueLong = intArrayToInt(divisionValueInt) % capacity;

			finalValue = (int) divisionValueLong; 
			
			

			// newKey = Integer.valueOf(insertEntry.getKey().substring(0,5));

		}
		if (hashFunc.equals("folding")) {

		}
		if (hashFunc.equals("mid_square")) {

		}

		for (int i = 0; i < newHashtable.length; i++) {
			if (newHashtable[i] == null) {
				newHashtable[i] = insertEntry;
				return true;
			}
		}

		return false;
	}

	/**
	 * This method deletes the entry from the Hash-Table, having deleteKey as key
	 * This method returns the entry, having deleteKey as key if the deletion is
	 * successful and null if the key deleteKey is not found in the Hash-Table.
	 * 
	 * @param deleteKey
	 *            key of the entry to delete from the Hash-Table
	 * @return returns the deleted entry if the deletion ends successfully null if
	 *         the entry is not found in the Hash-Table
	 */
	public Entry delete(String deleteKey) {
		/**
		 * Add your code here
		 */
		return null;
	}

	/**
	 * This method searches in the Hash-Table for the entry with key searchKey. It
	 * returns the entry, having searchKey as key if such an entry is found, null
	 * otherwise.
	 * 
	 * @param searchKey
	 *            key of the entry to find in the Hash-table
	 * @return returns the entry having searchKey as key if such an entry exists
	 *         null if the entry is not found in the Hash-Table
	 */
	public Entry find(String searchKey) {
		/**
		 * Add your code here
		 */
		return null;
	}

	/**
	 * This method returns a ArrayList<String> containing the output Hash-Table. The
	 * output should be directly interpretable dot code. Each item in the ArrayList
	 * corresponds to one line of the output Hash-Table. The nodes of the output
	 * Hash-Table should contain the keys of the entries and also the data.
	 * 
	 * @return returns the output Hash-Table in directly interpretable dot code
	 */
	public ArrayList<String> getHashTable() {
		/**
		 * Add your code here
		 */
		return null;
	}

	/**
	 * This method increases the capacity of the Hash-Table and reorganizes it, in
	 * order to accommodate and access its entries more efficiently. This method is
	 * called automatically when the load factor exceeds 75%. To increase the size
	 * of the Hash-Table, you multiply the actual capacity by 10 and search for the
	 * closest primary number less than the result of this multiplication. For
	 * example if the actual capacity of the Hash-Table is 101, the capacity will be
	 * increased to 1009, which is the closest primary number less than (101*10).
	 */
	private void rehash() {
		/**
		 * Add your code here
		 */
	}

	private boolean isEmpty() {
		for (int i = 0; i <= newHashtable.length; i++)
			if (newHashtable[i] != null)
				return false;
		return true;
	}
	
	private long intArrayToInt(int[] array) {
		StringBuilder s = new StringBuilder(); 
		for(int i = 0; i < array.length; i++) {
			s.append(array[i]);
		}
		
		return Long.parseLong(s.toString());
		
	}
}
