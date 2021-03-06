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
 * Common namespaces: OWL, RDF, ...
 * 
 * @author Mikel Egaña Aranguren
 * @version 0.0.1
 * @date 2014 eka 16
 */
public enum NS {
	RDF ("http://www.w3.org/1999/02/22-rdf-syntax-ns#"),
	OWL ("http://www.w3.org/2002/07/owl#"),
	XSD ("http://www.w3.org/2001/XMLSchema#"),
	RDFS ("http://www.w3.org/2000/01/rdf-schema#"),
	BIOMO_RES ("http://purl.oclc.org/BIOMO/resource/");
	
	private String ns_uri;
	
	private NS (String ns){
		this.ns_uri=ns;
	}
	
	public String getURI(){
		return this.ns_uri;
	}
}
