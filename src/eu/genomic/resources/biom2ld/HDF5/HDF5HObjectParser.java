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
 * @author Mikel Egaña Aranguren
 * @version
 * @date 
 */
public abstract class HDF5HObjectParser{
	private String targetPath;
	
	public HDF5HObjectParser(String path){
		targetPath = path;
	}
	
	public String getHObjectPath (){
		return targetPath;
	}
	
	public abstract void execute(HObject hobject, Store store) throws Exception;
	
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
