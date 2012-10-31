package com.marakana.generics;

import java.util.NoSuchElementException;

public abstract class ImmutableList<E> {

	public abstract E head();
	public abstract ImmutableList<E> tail();

	public <F> ImmutableList<F> map(Function<E, F> fn) {
		return null; // TODO
	}

	public ImmutableList<E> cons(final E head) {
		return new Cons<E>(head, this);
	}

	public static <E> ImmutableList<E> nil() {
		return new Nil<E>();
	}

	private static final class Cons<E> extends ImmutableList<E> {
		private final E head;
		private final ImmutableList<E> tail;

		public Cons(E head, ImmutableList<E> tail) {
			this.head = head;
			this.tail = tail;
		}

		@Override
		public E head() {
			return head;
		}

		@Override
		public ImmutableList<E> tail() {
			return tail;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + head.hashCode();
			result = prime * result + tail.hashCode();
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;

			@SuppressWarnings("unchecked")
			Cons<E> other = (Cons<E>) obj;
			if (!head.equals(other.head))
				return false;
			if (!tail.equals(other.tail))
				return false;
			return true;
		}

	}

	private static final class Nil<E> extends ImmutableList<E> {
		@Override
		public E head() {
			throw new NoSuchElementException();
		}

		@Override
		public ImmutableList<E> tail() {
			throw new NoSuchElementException();
		}

		@Override
		public int hashCode() {
			return 0;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			return getClass() == obj.getClass();
		}
	}

}
