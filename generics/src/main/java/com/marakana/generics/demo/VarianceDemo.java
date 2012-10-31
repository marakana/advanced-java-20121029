package com.marakana.generics.demo;

public class VarianceDemo {

	static class A {}
	static class B extends A {}
	static class C extends B {}

	static class Box<T> {
		private T element;

		public Box(T element) {
			this.element = element;
		}

		public T getElement() {
			return element;
		}

		public void setElement(T element) {
			this.element = element;
		}
	}

	static void getFromABox(Box<? extends B> box) {
		B element = box.getElement();
		System.out.println(element);
	}

	static void putInABox(Box<? super B> box) {
		B element = new B();
		box.setElement(element);
	}

	static void getAndPut(Box<B> box) {
		getFromABox(box);
		putInABox(box);
	}

	static void covariance() {
		Box<C> box = new Box<C>(new C());
		getFromABox(box);
	}
	
	static void contravariance() {
		Box<A> box = new Box<A>(null);
		putInABox(box);
	}

	static void invariance() {
		Box<B> box = new Box<B>(new B());
		getAndPut(box);
	}

//	static void broken() {
//		getFromABox(new Box<A>(new A()));
//		putInABox(new Box<C>(new C()));
//	}
}
