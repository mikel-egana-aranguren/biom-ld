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



import eu.genomic.resources.biom2ld.Storage.Store;
import ncsa.hdf.object.Dataset;
import ncsa.hdf.object.HObject;


/**
 * 
 * A parser for the dataset sample/ids
 * 
 * @author Mikel Egaña Aranguren
 * @version 0.0.1
 * @date 2014 eka 16
 */
public class HDF5DatasetSampleIDsParser extends HDF5HObjectParser {

	/**
	 * @param path
	 */
	public HDF5DatasetSampleIDsParser() {
		super("sample/ids");
	}

	@Override
	public void execute(HObject hobject, Store store) throws Exception {
		String[] data = (String[]) ((Dataset) hobject).getData();
		for (int k = 0; k < data.length; k++) {
			store.set_observation_id_name(k, data[k]);
//			System.out.println(k +" - "+ data[k]);
		}
	}

}
