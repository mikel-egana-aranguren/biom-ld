#!/bin/sh


############## BIOM HDF5 TO RDF CONVERTER


ROOT="/home/mikel/UPV-EHU/Eclipse_Workspace/biom-ld"


############## CONVERT ONE FILE

# Input biom file
# BIOM_FILE=$ROOT"/data/rich_sparse_otu_table_hdf5.biom" 
BIOM_FILE=$ROOT"/biom-format/tests/bench_tables/10x10x0.100_bench_hdf5.biom.gz" 


# biom ontology
BIOM_ONT=$ROOT"/ontology/biom.owl" 

# new biom table URI
BIOM_URI="http://genomic-resources.eu/biom_table_1" 

# rdf dump path
RDF_OUT=$ROOT"/result/10x10x0.100_bench_hdf5.biom.gz.rdf" 

# hdf5 libraries path
HDF5_LIB=$ROOT"/lib/hdf-java-2.10" 

# java -jar -Djava.library.path=$HDF5_LIB BIOMhdf52rdf.jar $BIOM_FILE $BIOM_ONT $BIOM_URI $RDF_OUT


############## CONVERT VARIOUS FILES

# Input biom files dir
BIOM_FILE_DIR=$ROOT"/biom-format/tests/bench_tables/"

# Regexp for getting all the files in the dir
LIST=$BIOM_FILE_DIR"*_hdf5.biom.gz"

# index for incrementally adding URIs
i=0

for FILE in $LIST
do

java -jar -Djava.library.path=$HDF5_LIB BIOMhdf52rdf.jar $FILE $BIOM_ONT "http://genomic-resources.eu/biom_bench_table_"$i $FILE".rdf"

# echo "----"
# echo $HDF5_LIB 
# echo $FILE 
# echo $BIOM_ONT 
# echo "http://genomic-resources.eu/biom_bench_table_"$i
# echo $FILE".rdf"
i=`expr $i + 1`
done





