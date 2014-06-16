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
 * 
 * The BIOM format URIs, also found in the BIOM ontology
 * 
 * @author Mikel Egaña Aranguren
 * @version 0.0.1
 * @date 2014 eka 16
 */
public enum BIOM_URI {
	FunctionTable (NS.BIOM_RES.getURI() + "BIOM_000005"), 
	MetaboliteTable (NS.BIOM_RES.getURI() + "BIOM_000007"),
	OrthologTable (NS.BIOM_RES.getURI() + "BIOM_000008"),
	OTUTable (NS.BIOM_RES.getURI() + "BIOM_000009"),
	GeneTable (NS.BIOM_RES.getURI() + "BIOM_000006"),
	PathwayTable (NS.BIOM_RES.getURI() + "BIOM_000010"),
	TaxonTable (NS.BIOM_RES.getURI() + "BIOM_000011"),
	GeneratedBy (NS.BIOM_RES.getURI() + "BIOM_000017"),
	CreationDate (NS.BIOM_RES.getURI() + "BIOM_000016"),
	NumberNonZeroElements (NS.BIOM_RES.getURI() + "BIOM_000018"),
	NumberOfObservations (NS.BIOM_RES.getURI() + "BIOM_000019"),
	NumberOfSamples (NS.BIOM_RES.getURI() + "BIOM_000020"),
	Observation (NS.BIOM_RES.getURI() + "BIOM_000021"),
	Sample (NS.BIOM_RES.getURI() + "BIOM_000022"),
	RefersToObservation (NS.BIOM_RES.getURI() + "BIOM_000025"),
	RefersToSample (NS.BIOM_RES.getURI() + "BIOM_000026"),
	NumericalValue (NS.BIOM_RES.getURI() + "BIOM_000027");
	
	private String biom_uri;

	private BIOM_URI (String uri){
		this.biom_uri = uri;

	}
	
	public String getURI (){
		return this.biom_uri;
	}
}
