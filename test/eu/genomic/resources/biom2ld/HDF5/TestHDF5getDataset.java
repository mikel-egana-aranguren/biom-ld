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
package eu.genomic.resources.biom2ld.HDF5;

import static org.junit.Assert.*;
import ncsa.hdf.object.Dataset;

import org.junit.Test;

/**
 * @author Mikel Egaña Aranguren
 * @version 0.0.1
 * @date 
 */
public class TestHDF5getDataset {

	/**
	 * Test method for {@link eu.genomic.resources.biom2ld.HDF5.HDF5File#getDataset(java.lang.String)}.
	 */
	@Test
	public void testGetDataset() {
		HDF5File hdf5file = new HDF5File("/home/mikel/UPV-EHU/Eclipse_Workspace/"
				+ "biom-ld/data/rich_sparse_otu_table_hdf5.biom");
		Dataset dataset = null;
		
		try {
			hdf5file.openFile();
			dataset = (Dataset) hdf5file.getDataset("observation/matrix/data");	
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("Datatype of dataset should be 64-bit floating-point", "64-bit floating-point", 
				dataset.getDatatype().getDatatypeDescription());
	}
}
