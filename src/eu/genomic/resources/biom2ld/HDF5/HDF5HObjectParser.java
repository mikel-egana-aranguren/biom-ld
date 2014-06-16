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
import eu.genomic.resources.biom2ld.Storage.Store;


/**
 * 
 * An HDF5HObject parser is able to consume the HDF5 Object whose path is defined when constructing the parser 
 * 
 * @author Mikel Egaña Aranguren
 * @version 0.0.1
 * @date 2014 eka 16
 */
public abstract class HDF5HObjectParser{
	private String targetPath;
	
	/**
	 * @param path the path of the object in the HDF5 file this parser can consume
	 */
	public HDF5HObjectParser(String path){
		targetPath = path;
	}
	
	/**
	 * @return a string containing the object's path in the HDF5 file
	 */
	public String getHObjectPath (){
		return targetPath;
	}
	
	/**
	 * 
	 * Execute the parser (whoever calls the parser is responsible for obtaining the object from the HDF5 file)
	 * 
	 * @param hobject the HDF5 object to consume
	 * @param store a store (Usually a triple store) that will store the information from the HDF5 file
	 * @throws Exception
	 */
	public abstract void execute(HObject hobject, Store store) throws Exception;
	
	/**
	 * @param metadata the list of metadata attributes
	 * @param attr_name the name of the attibute we want to retrieve	
	 * @return the retrieved attribute
	 */
	public Attribute getMetadataAttributeByName (List metadata, String attr_name){
		Attribute result = null;
		for (Object o : metadata) {
            Attribute a = (Attribute) o;
            if(a.getName().equals(attr_name)){
            	result = a;
            	break;
            }
		}
		return result;
	}
}
