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

/**
 * @author Mikel Egaña Aranguren
 * @version
 * @date 
 */
public enum BIOM_URI {
	FunctionTable (NS.BIOM_RES.getNS() + "BIOM_000005","Function table"),
	MetaboliteTable(NS.BIOM_RES.getNS() + "BIOM_000007", "Metabolite table"),
	OrthologTable(NS.BIOM_RES.getNS() + "BIOM_000008", "Ortholog table"),
	OTUTable(NS.BIOM_RES.getNS() + "BIOM_000009", "OTU table"),
	GeneTable (NS.BIOM_RES.getNS() + "BIOM_000006","Gene table"),
	PathwayTable (NS.BIOM_RES.getNS() + "BIOM_000010","Pathway table"),
	TaxonTable (NS.BIOM_RES.getNS() + "BIOM_000011","Taxon table");
	
	private String biom_uri;
	private String hdf_5_name;
	
	private BIOM_URI (String uri, String name){
		this.biom_uri = uri;
		this.hdf_5_name = name;
	}
	
}
