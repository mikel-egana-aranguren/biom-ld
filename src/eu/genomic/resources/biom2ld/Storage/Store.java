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
public class Store {
	private String biom_table_uri;
	public Store(){}
	public void setBIOMURI (String uri){
		this.biom_table_uri = uri;
	}
	public String get_BIOM_table_instance_URI (){
		return this.biom_table_uri;
	}
}