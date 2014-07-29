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
 * The BIOM format URIs, also found in the BIOMO ontology
 * 
 * @author Mikel Egaña Aranguren
 * @version 0.0.1
 * @date 2014 eka 16
 */
public enum BIOMO_URI {
	FunctionTable (NS.BIOMO_RES.getURI() + "BIOMO_000005"), 
	MetaboliteTable (NS.BIOMO_RES.getURI() + "BIOMO_000007"),
	OrthologTable (NS.BIOMO_RES.getURI() + "BIOMO_000008"),
	OTUTable (NS.BIOMO_RES.getURI() + "BIOMO_000009"),
	GeneTable (NS.BIOMO_RES.getURI() + "BIOMO_000006"),
	PathwayTable (NS.BIOMO_RES.getURI() + "BIOMO_000010"),
	TaxonTable (NS.BIOMO_RES.getURI() + "BIOMO_000011"),
	GeneratedBy (NS.BIOMO_RES.getURI() + "BIOMO_000017"),
	CreationDate (NS.BIOMO_RES.getURI() + "BIOMO_000016"),
	NumberNonZeroElements (NS.BIOMO_RES.getURI() + "BIOMO_000018"),
	NumberOfObservations (NS.BIOMO_RES.getURI() + "BIOMO_000019"),
	NumberOfSamples (NS.BIOMO_RES.getURI() + "BIOMO_000020"),
	Observation (NS.BIOMO_RES.getURI() + "BIOMO_000021"),
	Sample (NS.BIOMO_RES.getURI() + "BIOMO_000022"),
	RefersToObservation (NS.BIOMO_RES.getURI() + "BIOMO_000025"),
	RefersToSample (NS.BIOMO_RES.getURI() + "BIOMO_000026"),
	NumericalValue (NS.BIOMO_RES.getURI() + "BIOMO_000027");
	
	private String biomo_uri;

	private BIOMO_URI (String uri){
		this.biomo_uri = uri;

	}
	
	public String getURI (){
		return this.biomo_uri;
	}
}
