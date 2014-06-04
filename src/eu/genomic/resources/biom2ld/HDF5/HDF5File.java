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

import ncsa.hdf.hdf5lib.HDF5Constants;
import ncsa.hdf.object.h5.H5File;
import ncsa.hdf.object.Dataset;

/**
 * 
 * This class holds an HDF5 file in memory
 * 
 * @author Mikel Egaña Aranguren
 * @version 0.0.1
 * @date
 */
public class HDF5File {
	private final String filePath;
	private final H5File h5file;

	/**
	 * 
	 * Create an HDF5 file object
	 * 
	 * @param filePath
	 */
	public HDF5File(String HDF5filePath) {
		filePath = HDF5filePath;
		h5file = new H5File(filePath, HDF5Constants.H5F_ACC_RDONLY);
	}

//	/**
//	 * @return the HDF5 file path
//	 */
//	public final String getFilePath() {
//		return filePath;
//	}

	/**
	 * 
	 * Open the HDF5 file
	 * 
	 * @throws Exception
	 */
	public void openFile() throws Exception {
		h5file.open();
	}
	
	/**
	 * 
	 * Get a dataset from the HDF5 object
	 * 
	 * @param datasetPath
	 * @return
	 * @throws Exception
	 */
	public Dataset getDataset (String datasetPath) throws Exception {
		return (Dataset) h5file.get(datasetPath);
	}
}