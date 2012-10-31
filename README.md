Advanced Java, October 29-31 2012
=================================

Class Videos
------------

Day 1:

  - https://mrkn.s3.amazonaws.com/recordings/advanced-java-sfdc-20121029/1.1.mov
  - https://mrkn.s3.amazonaws.com/recordings/advanced-java-sfdc-20121029/1.2.mov
  - https://mrkn.s3.amazonaws.com/recordings/advanced-java-sfdc-20121029/1.3.mov
  - https://mrkn.s3.amazonaws.com/recordings/advanced-java-sfdc-20121029/1.4.mov

Day 2:

  - https://mrkn.s3.amazonaws.com/recordings/advanced-java-sfdc-20121029/2.1.mov
  - https://mrkn.s3.amazonaws.com/recordings/advanced-java-sfdc-20121029/2.2.mov
  - https://mrkn.s3.amazonaws.com/recordings/advanced-java-sfdc-20121029/2.3.mov
  - https://mrkn.s3.amazonaws.com/recordings/advanced-java-sfdc-20121029/2.4.mov


Contracts and Inheritance
-------------------------

Liskov Substitutability Principle (LSP)

  - Given a Base and Derived class, a program that works with the Base class should also work with the Derived class.

Specification-based testing

  - establish invariants (contracts) and assert that those invariants hold for *all* possible arbitrary sample data

Value Classes vs. Service Classes
---------------------------------

  - Value classes have structural identity, final fields, getters. They shouldn't have anything else (no other methods), otherwise you end up with unnecessary coupling in your architecture.
  - Service classes usually only have reference identity, and mutable state.

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
  - Stable object identity
  - Obviates need for synchronization, resulting in correct, high performance concurrent code
  - Encourages sharing (memory efficiency. See Okasaki, "Purely Functional Data Structures." e.g. finger trees, hash array mapped tries)

Design Patterns
---------------

  - Composite: multiple implementations of a common interface, some of which may recursively contain instances of the interface. Example: expressions with sub-expressions in a parse tree.

  - Visitor: avoid polluting a composite (above) data structure with orthogonal concerns. Define a "Visitor" interface with visit() methods for each composite implementation case, and define an accept() method in the composite interface which takes a visitor. Example: multiple serializers and evaluators for expressions.

  - Producer-Consumer: implement concurrent programs as a set of producers which push messages to a queue, and consumers which pop messages from the queue. Use java.util.concurrent.BlockingQueue to implement this cleanly, and avoid explicit synchronization.

  - Builder: start with an empty "builder" object, and chain method calls to append/set properties on it.