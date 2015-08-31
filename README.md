JSON fields
-------------

This is a proposed standard extension to Rest APIs that return JSON.

If and when the request contains a query parameter named "fields" with a blacklist or whitelist of the form

    (field1!(subfield1, subfield2),field2(subfield3, subfield4)

Then the returned JSON would contain only the fields "field1" and "field2", which in turn would contain the nested
properties "field2.subfield3", "field2.subfield4", and all fields from "field1" except "subfield1" and "subfield2".

The "grammar" sub-project contains the underlying [ANTLR4](http://www.antlr.org/) grammar, other projects may provide
 implementations of the grammar for different languages and environments.
