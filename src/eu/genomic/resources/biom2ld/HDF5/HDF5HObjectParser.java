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

import ncsa.hdf.object.HObject;

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

	public abstract void execute(HObject hobject) throws Exception;
}