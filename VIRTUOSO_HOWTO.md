Install virtuoso [Ubuntu instructions](http://virtuoso.openlinksw.com/dataspace/doc/dav/wiki/Main/VOSUbuntuNotes): 

Load RDF in Virtuoso:

* User dba, passwd dba (???!!!)
* WebDAV browser: DAV/home/dba/rdf_sink
* Upload RDF dump

Query at (http://localhost:8890/sparql):

* Default graph: http://localhost:8890/DAV/home/dba/rdf_sink/

* Obtain the values of a concrete cell:

```
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX biom_res: <http://www.biom-format.org/resource/>
SELECT ?value 
WHERE { 
?cell biom_res:BIOM_000026 <http://genomic-resources.eu/biom_table_1/GG_OTU_1> .
?cell biom_res:BIOM_000025 <http://genomic-resources.eu/biom_table_1/Sample2>  .
?cell biom_res:BIOM_000027 ?value  
}
```