package com.marakana.generics;

import static com.marakana.generics.ImmutableList.nil;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class ImmutableListTest {

	private static final ImmutableList<Integer>
		EMPTY = nil(),
		ONE = EMPTY.cons(1),
		TWO_ONE = ONE.cons(2),
		THREE_TWO_ONE = TWO_ONE.cons(3),
		ANOTHER_THREE_TWO_ONE = ImmutableList.<Integer> nil().cons(1).cons(2).cons(3);

	@Test
	public void threeTwoOneMustContainTwoOne() {
		assertSame(THREE_TWO_ONE.tail(), TWO_ONE);
	}

	@Test
	public void equalListsMustBeEqual() {
		assertEquals(ANOTHER_THREE_TWO_ONE, THREE_TWO_ONE);
	}
}
