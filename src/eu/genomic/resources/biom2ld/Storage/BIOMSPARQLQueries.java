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
 * @deprecated 
 */
public enum BIOMSPARQLQueries {
	GetBIOMTableInstance ("GetBIOMTableInstance");

	private String query_name;
	private BIOMSPARQLQueries(String query) {
		this.query_name = query;
	}
	public String generateQuery (){
		String sparql_query = null;
//		if (this.query_name.equals("GetBIOMTableInstance")){
//			sparql_query = 
//					generateSPARQLPREFIX("rdf", NS.RDF.getNS()) +
//					generateSPARQLPREFIX("rdfs", NS.RDFS.getNS()) +
//					generateSPARQLPREFIX("biom_res", NS.BIOM_RES.getNS()) +
//					"SELECT ?ind " +
//					"WHERE { " +
//					"?ind rdf:type ?object . " +
//					"?object rdfs:subClassOf biom_res:BIOM_000004 " +
//					"}"
//					;
//		}
		return sparql_query;
	}
	private static String generateSPARQLPREFIX (String prefix, String ns){
		return "PREFIX " + prefix +": <" + ns + "> ";
	}
	public static void main(String[] args) {
        System.out.println(BIOMSPARQLQueries.GetBIOMTableInstance.generateQuery());
    }
}
