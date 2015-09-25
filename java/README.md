Java Implementation
-------------------

This is the Java implementation of the JsonFields grammar.
It can be used as a basis for implementing the functionality in Java-based frameworks.
The key abstraction is the interface
[`FieldPredicate`](src/main/java/org/zalando/guild/api/json/fields/java/model/FieldPredicate.java),
which matches (or doesn't match) a field hierarchy.

You can get a `FieldPredicate` from a JsonFields expression through the
[`ParserFramework`](src/main/java/org/zalando/guild/api/json/fields/java/expression/ParserFramework.java)
class.

There is also the [`Main`](src/main/java/org/zalando/guild/api/json/fields/java/expression/Main.java)
class, an entry point for testing and evaluating field expressions on the command line.

This artifact is packaged as a jar-with-dependencies, shading ANTLR4.