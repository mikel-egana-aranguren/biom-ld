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

import eu.genomic.resources.biom2ld.HDF5.HDF5BIOMObservationMatrixDataDatasetParser;
import eu.genomic.resources.biom2ld.HDF5.HDF5HObjectParser;
import eu.genomic.resources.biom2ld.HDF5.HDF5File;

/**
 * @author Mikel Egaña Aranguren
 * @version
 * @date 
 */
public class Application {

	/**
	 * @param args
	 * @throws Exception ds_par
	 */
	public static void main(String[] args) throws Exception {
		HDF5File file = new HDF5File("/home/mikel/UPV-EHU/Eclipse_Workspace/"
				+ "biom-ld/data/rich_sparse_otu_table_hdf5.biom");
		
		// Create array of HDF5HObject parsers, with the path
		HDF5BIOMObservationMatrixDataDatasetParser ds_parser = new HDF5BIOMObservationMatrixDataDatasetParser();
		
		ds_parser.execute(file.getObject(ds_parser.getHObjectPath()));
		
	}
}
