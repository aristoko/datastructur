package com.datstruct;

public class HashTable {
	DataItem[] dataItems = new DataItem[20];
	static int SIZE = 20;

	public static void main(String[] args) {
		HashTable hashTable = new HashTable();
		hashTable.insert(1, 20);
		hashTable.insert(2, 70);
		hashTable.insert(42, 80);
		hashTable.insert(4, 25);
		hashTable.insert(12, 44);
		hashTable.insert(14, 32);
		hashTable.insert(17, 11);
		hashTable.insert(13, 78);
		hashTable.insert(37, 97);

		DataItem dataItem = hashTable.search(12);
		if (dataItem != null) {
			System.out.println(dataItem.key + " " + dataItem.data);
		} else {
			System.out.println("Not found");
		}

	}

	HashTable.DataItem search(int key) {
		int hashIndex = hashCode(key);
		while (dataItems[hashIndex] != null) {
			DataItem dataItem = dataItems[hashIndex];

			if (dataItem.key == key) {
				return dataItem;
			}

			++hashIndex;
			hashIndex %= SIZE;

		}
		return null;
	}

	void insert(int key, int data) {
		DataItem dataItem = new DataItem();
		dataItem.key = key;
		dataItem.data = data;
		int hashIndex = hashCode(key);

		while (dataItems[hashIndex] != null && dataItems[hashIndex].key != -1) {
			++hashIndex;
			hashIndex %= SIZE;
		}
		dataItems[hashIndex] = dataItem;

	}

	static int hashCode(int key) {
		return key % SIZE;
	}

	class DataItem {
		int data;
		int key;
	}
}
