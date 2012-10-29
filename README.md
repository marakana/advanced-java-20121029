Advanced Java, October 29-31 2012
=================================

Contracts and Inheritance
-------------------------

Liskov Substitutability Principle (LSP)

  - Given a Base and Derived class, a program that works with the Base class should also work with the Derived class.

Specification-based testing

  - establish invariants (contracts) and assert that those invariants hold for *all* possible arbitrary sample data

Object Identity
---------------

  - Referential Identity: determined uniquely by address in memory, e.g. a == b
  - Structural Identity (or "Value" Identity): determined by an object's properties, e.g. a.equals(b)
  - Only use immutable fields to determine structural identity

Immutability
------------

Benefits

  - Fewer tests
  - Less code
  - Correct code
  - Safe inheritance (code reuse)
  - Stable object identtiy