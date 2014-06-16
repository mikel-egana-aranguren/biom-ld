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

import java.util.List;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;

import ncsa.hdf.object.Attribute;
import ncsa.hdf.object.HObject;
import eu.genomic.resources.biom2ld.Storage.BIOM_URI;
import eu.genomic.resources.biom2ld.Storage.JenaOnMemoryStore;
import eu.genomic.resources.biom2ld.Storage.Store;

/**
 * 
 * A parser for the BIOM attribute creation-date
 * 
 * @author Mikel Egaña Aranguren
 * @version 0.0.1
 * @date 2014 eka 16
 */
public class HDF5AttributeCreationDateParser extends HDF5HObjectParser {

	public HDF5AttributeCreationDateParser() {
		super("/");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.genomic.resources.biom2ld.HDF5.HDF5SimpleHObjectParser#execute(ncsa
	 * .hdf.object.HObject, eu.genomic.resources.biom2ld.Storage.Store)
	 */
	@Override
	public void execute(HObject hobject, Store store) throws Exception {
		List metadata = hobject.getMetadata();
		Attribute attr = super.getMetadataAttributeByName(metadata,"creation-date");
		if (attr == null) {
			throw new BIOMHDF5ParserException(
					"Could not find attribute creation-date in HDF5 file");
		} else {
			String creation_date_value = ((String[]) attr.getValue())[0];
			((JenaOnMemoryStore) store).addLiteral(
					((JenaOnMemoryStore) store).get_BIOM_table_instance_URI(),
					BIOM_URI.CreationDate.getURI(), creation_date_value, XSDDatatype.XSDdateTime);
		}
	}
}
