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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;

import eu.genomic.resources.biom2ld.Storage.BIOMCellValue;
import eu.genomic.resources.biom2ld.Storage.BIOMCompressedSparseRowMatrix;
import eu.genomic.resources.biom2ld.Storage.BIOM_URI;
import eu.genomic.resources.biom2ld.Storage.JenaOnMemoryStore;
import eu.genomic.resources.biom2ld.Storage.Store;
import ncsa.hdf.object.Dataset;
import ncsa.hdf.object.Group;
import ncsa.hdf.object.HObject;

/**
 * 
 * A parser for the group observation/matrix
 * 
 * @author Mikel Egaña Aranguren
 * @version 0.0.1
 * @date  2014 eka 16
 */
public class HDF5GroupObservationParser extends HDF5HObjectParser {

	/**
	 * @param path
	 */
	public HDF5GroupObservationParser() {
		super("observation/matrix");
	}

	@Override
	public void execute(HObject hobject, Store store) throws Exception {
		Group obs_matrix = (Group) hobject;

		Dataset data_ds = (Dataset) obs_matrix.getMemberList().get(0);
		double [] data = (double[]) data_ds.getData();

		Dataset indices = (Dataset) obs_matrix.getMemberList().get(1);
		int [] indices_data = (int[]) indices.getData();
		
		Dataset indptr = (Dataset) obs_matrix.getMemberList().get(2);
		int [] indptr_data = (int[]) indptr.getData();
		
		BIOMCompressedSparseRowMatrix CSR = new BIOMCompressedSparseRowMatrix(data, indices_data, indptr_data);

		Iterator<BIOMCellValue> CSRIterator = CSR.iterator();
		while (CSRIterator.hasNext()){
			BIOMCellValue result = CSRIterator.next();
			Double value = result.getValue();
			String observation = store.get_observation_name_by_id(result.getRow_index());
			String sample = store.get_sample_name_by_id(result.getCol_index());
			
//			System.out.println(store.get_BIOM_table_instance_URI());
//			System.out.println(BIOM_URI.Observation.getURI());
//			System.out.println(store.get_BIOM_table_instance_URI()+"/"+observation);
			
			
			((JenaOnMemoryStore)store).addTriple(
					store.get_BIOM_table_instance_URI(), 
					BIOM_URI.Observation.getURI(), 
					store.get_BIOM_table_instance_URI()+"/"+observation);
			
			((JenaOnMemoryStore)store).addTriple(
					store.get_BIOM_table_instance_URI(), 
					BIOM_URI.Sample.getURI(), 
					store.get_BIOM_table_instance_URI()+"/"+sample);
			
			((JenaOnMemoryStore)store).addTriple(
					store.get_BIOM_table_instance_URI()+"/"+sample+observation, 
					BIOM_URI.RefersToObservation.getURI(), 
					store.get_BIOM_table_instance_URI()+"/"+observation);
			
			((JenaOnMemoryStore)store).addTriple(
					store.get_BIOM_table_instance_URI()+"/"+sample+observation, 
					BIOM_URI.RefersToSample.getURI(), 
					store.get_BIOM_table_instance_URI()+"/"+sample);
			
			((JenaOnMemoryStore)store).addLiteral(
					store.get_BIOM_table_instance_URI()+"/"+sample+observation, 
					BIOM_URI.NumericalValue.getURI(), 
					value.toString(),
					XSDDatatype.XSDdouble);
			
			
//			System.out.println(result.getValue());
//			System.out.println(store.get_observation_name_by_id(result.getRow_index()));
//			System.out.println(store.get_sample_name_by_id(result.getCol_index()));			
		}

	}

}
