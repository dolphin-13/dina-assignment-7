package com.coderscampus.arralist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomArrayListTest {
	// Test-Driven Development Methodology
	// Step 1 - write a failing test
	// Step 2 - write the business logic to make the test pass
	// Step 3 - refactor your code

	@Test
	void should_add_one_item_to_list() {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();

		// Act
		sut.add(10);
		Integer expectedItem = sut.get(0);
		Integer expectedSize = sut.getSize();

		// Assert
		assertEquals(10, expectedItem);
		assertEquals(1, expectedSize);
	}

	@Test
	void should_add_12_items_to_list() {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();

		// Act
		for (int i = 1; i <= 12; i++) {
			sut.add(i);
		}

		// Assert
		for (int i = 0; i < 11; i++) {
			assertEquals(i + 1, sut.get(i));
		}
		Integer expectedSize = sut.getSize();
		assertEquals(12, expectedSize);
	}

	@Test
	void should_add_one_item_at_specified_index() {
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 1; i < 5; i++) {
			sut.add(i);
		}

		Integer expectedSizeBefore = sut.getSize();

		sut.add(3, 8);

		Integer expectedAddedItem = sut.get(3);
		Integer expectedSizeAfter = sut.getSize();

		assertEquals(4, expectedSizeBefore);
		assertEquals(8, expectedAddedItem);
		assertEquals(5, expectedSizeAfter);
	}

	@Test
	void should_add_one_item_to_list_at_specified_index_when_size_reached_max_array_length() {
		// Arrange
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 1; i <= 10; i++) {
			sut.add(i);
		}
		Integer expectedSize = sut.getSize();
		assertEquals(10, expectedSize);

		// Act
		sut.add(10, 100);

		// Assert
		expectedSize = sut.getSize();		
		assertEquals(11, expectedSize);

	}

	@Test
	void should_add_one_item_when_index_equals_size() {
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 1; i < 5; i++) {
			sut.add(i);
		}

		Integer expectedSizeBefore = sut.getSize();

		sut.add(4, 6);

		Integer expectedAddedItem = sut.get(4);
		Integer expectedSizeAfter = sut.getSize();

		assertEquals(4, expectedSizeBefore);
		assertEquals(6, expectedAddedItem);
		assertEquals(5, expectedSizeAfter);
	}

	@Test
	void should_throw_exception_when_index_negative() {
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 1; i < 5; i++) {
			sut.add(i);
		}

		Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			sut.add(-1, 6);
		});

		String expectedMessage = "Index: -1 is not positive";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

	}

	@Test
	void should_throw_exception_when_index_greater_than_size() {
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 1; i < 5; i++) {
			sut.add(i);
		}

		Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			sut.add(5, 3);
		});

		String expectedMessage = "Index: 5, Size: 4";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void should_add_one_item_at_zero_index() {
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 1; i < 5; i++) {
			sut.add(i);
		}

		Integer expectedSizeBefore = sut.getSize();

		sut.add(0, 7);

		Integer expectedAddedItem = sut.get(0);
		Integer expectedSizeAfter = sut.getSize();

		assertEquals(4, expectedSizeBefore);
		assertEquals(7, expectedAddedItem);
		assertEquals(5, expectedSizeAfter);
	}

	@Test
	void should_remove_one_item_at_specified_index() {
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 1; i < 5; i++) {
			sut.add(i);
		}

		Integer expectedSizeBefore = sut.getSize();
		Integer expectedItemAtIndex = sut.remove(2);

		Integer expectedNewItemAtIndex = sut.get(2);
		Integer expectedSizeAfter = sut.getSize();

		assertEquals(4, expectedSizeBefore);
		assertEquals(3, expectedItemAtIndex);
		assertEquals(4, expectedNewItemAtIndex);
		assertEquals(3, expectedSizeAfter);
	}

	@Test
	void should_remove_one_item_at_index_zero() {
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 1; i < 5; i++) {
			sut.add(i);
		}

		Integer expectedSizeBefore = sut.getSize();
		Integer expectedItemAtIndex = sut.remove(0);

		Integer expectedNewItemAtIndex = sut.get(0);
		Integer expectedSizeAfter = sut.getSize();

		assertEquals(4, expectedSizeBefore);
		assertEquals(1, expectedItemAtIndex);
		assertEquals(2, expectedNewItemAtIndex);
		assertEquals(3, expectedSizeAfter);
	}

	@Test
	void should_throw_exception_when_remove_one_item_at_index_equals_size() {
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 1; i < 5; i++) {
			sut.add(i);
		}

		Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			sut.remove(4);
		});

		String expectedMessage = "Index: 4, Size: 4";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void should_throw_exception_when_remove_one_item_at_index_negative() {
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 1; i < 5; i++) {
			sut.add(i);
		}

		Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			sut.remove(-1);
		});

		String expectedMessage = "Index: -1 is not positive";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void should_throw_exception_when_remove_one_item_at_index_greater_than_size() {
		CustomList<Integer> sut = new CustomArrayList<>();
		for (int i = 1; i < 5; i++) {
			sut.add(i);
		}

		Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			sut.remove(5);
		});

		String expectedMessage = "Index: 5, Size: 4";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

}
