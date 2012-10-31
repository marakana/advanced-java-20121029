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
		ANOTHER_THREE_TWO_ONE = ImmutableList.<Integer> nil().cons(1).cons(2).cons(3),
		FOUR_THREE_TWO = ImmutableList.<Integer> nil().cons(2).cons(3).cons(4);
	
	private static final ImmutableList<String>
		THREE_TWO_ONE_STRINGS = ImmutableList.<String> nil().cons("1").cons("2").cons("3");

	private static final Function<Integer, Integer> PLUS_ONE = new Function<Integer, Integer>() {
		@Override
		public Integer apply(Integer input) {
			return input + 1;
		}
	};

	private static final Function<Object, String> TO_STRING = new Function<Object, String>() {
		@Override
		public String apply(Object input) {
			return input.toString();
		}
	};

	@Test
	public void threeTwoOneMustContainTwoOne() {
		assertSame(THREE_TWO_ONE.tail(), TWO_ONE);
	}

	@Test
	public void equalListsMustBeEqual() {
		assertEquals(ANOTHER_THREE_TWO_ONE, THREE_TWO_ONE);
	}

	@Test
	public void threeTwoOnePlusOneMustEqualFourThreeTwo() {
		assertEquals(FOUR_THREE_TWO, THREE_TWO_ONE.map(PLUS_ONE));
	}

	@Test
	public void mapToStringShouldWork() {
		assertEquals(THREE_TWO_ONE_STRINGS, THREE_TWO_ONE.map(TO_STRING));
	}
}
