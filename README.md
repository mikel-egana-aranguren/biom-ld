biom-ld
=======

Summary
-------

This is a first step towards a full mapping of the BIOM format to a more Linked Data friendly format, JSON-LD. 

Rationale
---------

The [Biological Observation Matrix (BIOM) format](http://biom-format.org/) is a [JSON](http://en.wikipedia.org/wiki/JSON) based specification to represent biological observation tables. For example, it is used in the [Earth Microbiome Project](http://www.earthmicrobiome.org/) for storing environmental metagenomics data in a common an efficient format. On the other hand, [JSON-LD](http://json-ld.org/) is also a JSON based representation of [Linked Data](http://en.wikipedia.org/wiki/Linked_data) resources. Thus, one can map the BIOM format to BIOM-LD (from plain JSON to JSON-LD) and obtain a Linked Data representation that can be directly plugged to the web of data.  







advantages of using JSON-LD over JSON (Or, even better, to convert BIOM to RDF triples in a triple store):

- linking, specially if URIs ar used for metadata (in and out linking)
- explicit eschema (ontology): 
  reasoning can be used to check vaidity: ICV, http://www.w3.org/TR/vocab-data-cube/#wf-rules, ...
  data integration
- standrad vocabulary for statistics: see advantages of http://www.w3.org/TR/vocab-data-cube/#intro-rdf
- plug new vocabularies seamlessly, eg. Gene Ontology, taxa, envo, ...
- data integration through triples
- RDF based or JSON-LD based (still JSON!) syntax


obviosuly rather inefficient but we would have to check
direct triple injection is not inefficient, then queries are all right

The mapping
-----------


files:

* ontology: one can use this to parse any biom file and load it into the triple, by-passing JSON-LD. The onotlogy is a semantic representation of the same spceification, with acvantages: resolve, explciti, 

Future steps
------------

Write a conversor that can generate biom-ld from biom files, or pure RDF/XML representation. Test it by adding the data from http://www.earthmicrobiome.org/ to a triple store and publishing the dataset as Linked Data.

See issues in this repo for more technical items to do.

