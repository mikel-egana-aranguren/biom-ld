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

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.util.FileManager;

/**
 * @author Mikel Egaña Aranguren
 * @version
 * @date 
 */
public class JenaOnMemoryStore {
	private Model model;
	public static void main (String[] args){
		System.out.println("--");
		JenaOnMemoryStore store = new JenaOnMemoryStore();
		store.loadRDF("/home/mikel/UPV-EHU/Eclipse_Workspace/biom-ld/ontology/biom-format.owl");
		try {
			store.dumpDataset("/home/mikel/UPV-EHU/Eclipse_Workspace/biom-ld/result/ontology.rdf");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public JenaOnMemoryStore(){
		model = ModelFactory.createDefaultModel();
	}
	public void loadRDF(String inputFileName){
        InputStream in = FileManager.get().open( inputFileName );
        model.read(in, "");
	}
	public void addTriple(){}
	public void dumpDataset(String output) throws FileNotFoundException{
		model.write(new PrintStream(new File(output)),"RDF/XML-ABBREV");
	}
}
