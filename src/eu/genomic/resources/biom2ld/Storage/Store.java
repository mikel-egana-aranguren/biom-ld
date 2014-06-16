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

import java.util.Hashtable;

/**
 * @author Mikel Egaña Aranguren
 * @version
 * @date 
 */
public class Store {
	private String biom_table_uri;
	private Hashtable<Integer, String> sample_ids_names;
	private Hashtable<Integer, String> observation_ids_names;
	public Store(){
		this.sample_ids_names = new Hashtable<Integer, String>();
		this.observation_ids_names = new Hashtable<Integer, String>();
	}
	public void setBIOMURI (String uri){
		this.biom_table_uri = uri;
	}
	public String get_BIOM_table_instance_URI (){
		return this.biom_table_uri;
	}
	public void set_sample_id_name (Integer id, String name){
		sample_ids_names.put(id, name);
	}
	public String get_sample_name_by_id (Integer id){
		return sample_ids_names.get(id);
	}
	public void set_observation_id_name (Integer id, String name){
		observation_ids_names.put(id, name);
	}
	public String get_observation_name_by_id (Integer id){
		return observation_ids_names.get(id);
	}
}
