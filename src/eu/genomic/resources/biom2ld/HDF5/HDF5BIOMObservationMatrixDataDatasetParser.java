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

import ncsa.hdf.object.Dataset;
import ncsa.hdf.object.HObject;

/**
 * 
 * A parser for the dataset observation/matrix/data
 * 
 * @author Mikel Egaña Aranguren
 * @version
 * @date 
 */
public class HDF5BIOMObservationMatrixDataDatasetParser extends HDF5HObjectParser {

	/**
	 * @param path
	 */
	public HDF5BIOMObservationMatrixDataDatasetParser() {
		super("observation/matrix/data");
	}

	/* (non-Javadoc)
	 * @see eu.genomic.resources.biom2ld.HDF5.HDF5ElementParser#execute()
	 */
	@Override
	public void execute(HObject hobject) {
		Dataset dataset = (Dataset) hobject;
		try {
			System.out.println((dataset.getData()));
			double [] data = (double[]) dataset.getData();
			for (int k = 0; k < data.length; k++) {
				System.out.println(data[k]);
			}
		} catch (OutOfMemoryError | Exception e) {
			e.printStackTrace();
		}
	}

}
