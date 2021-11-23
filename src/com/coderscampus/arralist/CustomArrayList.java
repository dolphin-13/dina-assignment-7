package com.coderscampus.arralist;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	int size = 0;

	@Override
	public boolean add(T item) {
		if (items.length == size) {
			growBackingObjectArray();
		}
		items[size++] = item;
		return true;
	}

	private void growBackingObjectArray() {
		Object[] oldArray = items;
		items = new Object[size * 2];
		for (int i = 0; i < oldArray.length; i++) {
			items[i] = oldArray[i];
		}

	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		if (index <= size && index >= 0) {
			// shift one by one all elements from the end to right by 1 position while i >
			// index
			for (int i = size-1; i > index; i--)
				items[i] = items[i - 1];
			// add item with the index
			items[index] = item;
		} else if (index < 0)
			throw new IndexOutOfBoundsException("Index: " + index + " is not positive");
		else
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		size++;
		return true;
	}

	@Override
	public int getSize() {
		return size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		return (T) items[index];
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		T element;
		if (index < size && index >= 0) {
			element = (T) get(index);
			for (int i = index; i <= size; i++)
				items[i] = items[i + 1];
		} else if (index < 0)
			throw new IndexOutOfBoundsException("Index: " + index + " is not positive");
		else
			throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		size--;
		return element;
	}

}
