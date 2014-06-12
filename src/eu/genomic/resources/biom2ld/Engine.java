/**
 *  Copyright (c) 2014 Mikel Egaña Aranguren
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *  
 */
package eu.genomic.resources.biom2ld;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import eu.genomic.resources.biom2ld.HDF5.HDF5AttributeTypeParser;
import eu.genomic.resources.biom2ld.HDF5.HDF5File;
import eu.genomic.resources.biom2ld.HDF5.HDF5HObjectParser;
import eu.genomic.resources.biom2ld.HDF5.HDF5BIOMObservationMatrixDataDatasetParser;
import eu.genomic.resources.biom2ld.HDF5.HDF5SimpleHObjectParser;
import eu.genomic.resources.biom2ld.Storage.JenaOnMemoryStore;


/**
 * 
 * Converts an HDF5 file to RDF
 * 
 * @author Mikel Egaña Aranguren
 * @version 0.0.1
 * @date
 */
public class Engine {

	private String hdf5_file_path;
	private String ontology;
	private String biom_table_uri;
	private String dump_path;

	/**
	 * 
	 * Main engine for converting HDF5 to RDF
	 * 
	 * @param HDF5FilePath
	 * @param TripleStoreConf
	 */
	public Engine(String HDF5FilePath, String biom_ontology_path, String biom_table, String output) {
		hdf5_file_path = HDF5FilePath;
		ontology = biom_ontology_path;
		biom_table_uri = biom_table;
		dump_path = output;
	}

	
	public static void main(String[] args) {
		Engine engine = new Engine(
				"/home/mikel/UPV-EHU/Eclipse_Workspace/biom-ld/data/rich_sparse_otu_table_hdf5.biom", 
				"/home/mikel/UPV-EHU/Eclipse_Workspace/biom-ld/ontology/biom.owl", 
				"http://genomic-resources.eu/biom_table_1", 
				"/home/mikel/UPV-EHU/Eclipse_Workspace/biom-ld/result/biom.rdf");
		engine.work();
		
	}
	/**
	 * For each parser, find its target in the HDF5 file and if found execute
	 * parser against Triple Store, adding necessary info to the cache for other parsers to use
	 */
	public void work() {
		// Load the HDF5 file
		HDF5File file = new HDF5File(hdf5_file_path);
		
		// Load on memory triple store
		JenaOnMemoryStore store = new JenaOnMemoryStore();
		
		// Load BIOM ontology
		store.loadRDF(ontology);
		store.setBIOMURI(biom_table_uri);
		
		// Create the simple parsers we want to use
		List<HDF5SimpleHObjectParser> simple_parsers = new ArrayList<HDF5SimpleHObjectParser>();
		simple_parsers.add(new HDF5AttributeTypeParser());
		
		// For each parser, execute it: find the HDF5 object the parser can consume 
		// and pass the object to the parser
		Iterator simple_parsers_iterator = simple_parsers.iterator();
		while (simple_parsers_iterator.hasNext()) {
			try {
				HDF5SimpleHObjectParser parser = (HDF5SimpleHObjectParser) simple_parsers_iterator.next();
				parser.execute(file.getObject(parser.getHObjectPath()), store);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		// Write the dataset
		try {
			store.dumpDataset(dump_path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Load cached parsers and execute
		
		// Create a list of the HDF5HObject parsers we want to use
//		List<HDF5HObjectParser> parsers = new ArrayList<HDF5HObjectParser>();
//		parsers.add(new HDF5BIOMObservationMatrixDataDatasetParser());

		// For each parser, execute it, i.e. find the object that can consume in
		// the HDF5 file and consume it
//		Iterator parsers_iterator = parsers.iterator();
//		while (parsers_iterator.hasNext()) {
//			try {
//				HDF5HObjectParser parser = (HDF5HObjectParser) parsers_iterator
//						.next();
//				parser.execute(file.getObject(parser.getHObjectPath()));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	}
	
	
	
	
	
	
	// Testing pass by reference in JENA
//	add_ref_triple(store, 
//			"http://genomic-resources.eu/biom_table_1/a",
//			"http://www.biom-format.org/resource/BIOM_000025",
//			"http://genomic-resources.eu/biom_table_1/b"
//			);
//	
//	add_ref_triple(store, 
//			"http://genomic-resources.eu/biom_table_1/c",
//			"http://www.biom-format.org/resource/BIOM_000025",
//			"http://genomic-resources.eu/biom_table_1/d"
//			);
//	
//	private static void add_ref_triple (JenaOnMemoryStore store,String sub_uri, String prop_uri, String obj_uri){
//		store.addTriple(sub_uri, prop_uri, obj_uri);
//	}
}
