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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ncsa.hdf.hdf5lib.exceptions.HDF5ObjectHeaderException;
import eu.genomic.resources.biom2ld.HDF5.HDF5BIOMObservationMatrixDataDatasetParser;
import eu.genomic.resources.biom2ld.HDF5.HDF5File;
import eu.genomic.resources.biom2ld.HDF5.HDF5HObjectParser;

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

	/**
	 * 
	 * Main engine for converting HDF5 to RDF
	 * 
	 * @param HDF5FilePath
	 * @param TripleStoreConf
	 */
	public Engine(String HDF5FilePath, String TripleStoreConf) {
		hdf5_file_path = HDF5FilePath;
	}
	
	/**
	 * For each parser, find its target in the HDF5 file and if found execute parser against Triple Store
	 */
	public void work (){
		// Load the HDF5 file
		HDF5File file = new HDF5File(hdf5_file_path);
		
		// Create a list of the HDF5HObject parsers we want to use
		List<HDF5HObjectParser> parsers = new ArrayList<HDF5HObjectParser>();
		parsers.add(new HDF5BIOMObservationMatrixDataDatasetParser());
		
		// For each parser, execute it, i.e. find the object that can consume in the HDF5 file and consume it
		Iterator parsers_iterator = parsers.iterator();
		while(parsers_iterator.hasNext()){
			try {
				HDF5HObjectParser parser = (HDF5HObjectParser) parsers_iterator.next();
				parser.execute(file.getObject(parser.getHObjectPath()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		
	}
}
