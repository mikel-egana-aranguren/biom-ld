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
package eu.genomic.resources.biom2ld.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Iterator;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.query.QuerySolution;

/**
 * @author Mikel Egaña Aranguren
 * @version
 * @date
 */
public class JenaOnMemoryStore extends Store{
	private Model model;

//	public static void main(String[] args) {
//		JenaOnMemoryStore store = new JenaOnMemoryStore();
//		store.loadRDF("/home/mikel/UPV-EHU/Eclipse_Workspace/biom-ld/ontology/biom.owl");
//		Iterator<QuerySolution> results = store.execSelectQuery(BIOMSPARQLQueries.GetBIOMTableInstance.generateQuery());
//		while (results.hasNext()) {
//			QuerySolution soln = results.next();
//			System.out.println(soln.get("?ind"));
//		}
//		 store.addTriple(
//		 "http://genomic-resources.eu/biom_table_1/GG_OTU_1-Sample3",
//		 "http://www.biom-format.org/resource/BIOM_000025",
//		 "http://genomic-resources.eu/biom_table_1/GG_OTU_1"
//		 );
//		 try {
//		 store.dumpDataset("/home/mikel/UPV-EHU/Eclipse_Workspace/biom-ld/result/biom.rdf");
//		 } catch (FileNotFoundException e) {
//		 e.printStackTrace();
//		 }
//	}

	public JenaOnMemoryStore() {
		model = ModelFactory.createDefaultModel();
	}
	
	public void loadRDF(String inputFileName) {
		InputStream in = FileManager.get().open(inputFileName);
		model.read(in, "");
	}

	public void addTriple(String sub_uri, String prop_uri, String obj_uri) {
		Resource sub = model.createResource(sub_uri);
		Property prop = model.createProperty(prop_uri);
		Resource obj = model.createResource(obj_uri);
		sub.addProperty(prop, obj);
	}

	public ResultSet execSelectQuery(String queryString) {
		Query query = QueryFactory.create(queryString);
		QueryExecution qexec = QueryExecutionFactory.create(query, model);
		return qexec.execSelect();
	}

	public void dumpDataset(String output) throws FileNotFoundException {
		model.write(new PrintStream(new File(output)), "RDF/XML-ABBREV");
	}
}
