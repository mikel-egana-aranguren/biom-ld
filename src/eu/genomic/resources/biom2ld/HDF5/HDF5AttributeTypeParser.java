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

import ncsa.hdf.object.Attribute;
import ncsa.hdf.object.HObject;
import eu.genomic.resources.biom2ld.Storage.BIOM_URI;
import eu.genomic.resources.biom2ld.Storage.JenaOnMemoryStore;
import eu.genomic.resources.biom2ld.Storage.NS;
import eu.genomic.resources.biom2ld.Storage.Store;

/**
 * @author Mikel Egaña Aranguren
 * @version
 * @date
 */
public class HDF5AttributeTypeParser extends HDF5HObjectParser {

	public HDF5AttributeTypeParser() {
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
		// Attribute attr = (Attribute) metadata.get(7);
		Attribute attr = super.getMetadataAttributeByName(metadata, "type");
		if (attr == null) {
			throw new BIOMHDF5ParserException(
					"Could not find attribute type in HDF5 file");
		} else {
			String table_type = ((String[]) attr.getValue())[0];
			String normalised_table_type_name = (table_type.split("\\s")[0])
					.toLowerCase();
			String biom_table_uri = null;
			if (normalised_table_type_name.equals("otu")) {
				biom_table_uri = BIOM_URI.OTUTable.getURI();
			} else if (normalised_table_type_name.equals("pathway")) {
				biom_table_uri = BIOM_URI.PathwayTable.getURI();
			} else if (normalised_table_type_name.equals("function")) {
				biom_table_uri = BIOM_URI.FunctionTable.getURI();
			} else if (normalised_table_type_name.equals("ortholog")) {
				biom_table_uri = BIOM_URI.OrthologTable.getURI();
			} else if (normalised_table_type_name.equals("Gene")) {
				biom_table_uri = BIOM_URI.GeneTable.getURI();
			} else if (normalised_table_type_name.equals("Metabolite")) {
				biom_table_uri = BIOM_URI.MetaboliteTable.getURI();
			} else if (normalised_table_type_name.equals("Taxon")) {
				biom_table_uri = BIOM_URI.TaxonTable.getURI();
			} else {
				throw new BIOMHDF5ParserException(
						"Table type (otu, pathway, function, ortholog, gene, metabolite, taxon) not found in HDF5 file");
			}

			if (biom_table_uri != null) {
				((JenaOnMemoryStore) store).addTriple(
						((JenaOnMemoryStore) store)
								.get_BIOM_table_instance_URI(), NS.RDF.getNS()
								+ "type", biom_table_uri);
			}
		}
	}
}
