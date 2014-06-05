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

/**
 * 
 * A representation of BIOM Compressed Sparse Row Matrix with associated utilities. 
 * 
 * See http://en.wikipedia.org/wiki/Sparse_matrix
 * See http://netlib.org/linalg/html_templates/node91.html#SECTION00931100000000000000
 * See http://homepage.cs.uiowa.edu/~sriram/21/fall07/code/CRS.java
 * 
 * @author Mikel Egaña Aranguren
 * @version 0.0.1
 * @date 
 */
public class CompressedSparseRowMatrix {
//	double [] data = { 1, 5, 1, 2, 3, 1, 1, 4, 2, 2, 1, 1, 1, 1, 1, 79 };
//	int [] indices = { 2, 0, 1, 3, 4, 5, 2, 3, 5, 0, 1, 2, 5, 1, 2, 5 }; 
//	int [] indptr = { 0, 1, 6, 9, 13 };
	
	double [] data = { 1, 5, 1, 2, 3, 1, 1, 4, 2, 2, 1, 1, 1, 1, 1 };
	int [] indices = { 2, 0, 1, 3, 4, 5, 2, 3, 5, 0, 1, 2, 5, 1, 2 }; 
	int [] indptr = { 0, 1, 6, 9, 13, 15 };
	
	/**
	 * @param matrix_data: an array containing the actual non-zero values
	 * @param matrix_indices: an array containing the column index for each non-zero value
	 * @param matrix_indptr: an array containing the locations in the matrix_data that start a row
	 */
	
	public CompressedSparseRowMatrix (double [] matrix_data, int [] matrix_indices, int [] matrix_indptr){
//		data = matrix_data;
//		indices = matrix_indices;
//		indptr = matrix_indptr;
		
	}
	
	public void walkCSR (){
		int last_column = 0;
		for (int k = 0; k < data.length; k++){
			last_column = getRowIndexFromDataValue(k, last_column);
			System.out.println("VALUE " + data[k] + " COLUMN INDEX " + 
			getColumnIndexFromDataValue(k) + " ROW INDEX " + last_column); 			
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CompressedSparseRowMatrix matrix = new CompressedSparseRowMatrix(null, null, null);
		matrix.walkCSR();
	}
	
	private int getColumnIndexFromDataValue(int data_index){
		return indices[data_index];
	}
	private int getRowIndexFromDataValue(int data_index, int last_row_index){
		int result = 0;
		for(int i = 0; i < indptr.length; i++){
//			System.out.println(data_index + "--" + indptr[i]);
			if(data_index == indptr[i]){
				System.out.println(data_index + "--" + indptr[i] + "--" + i);
				result = i;
				break;
			}
			if(i == indptr.length-1){
				System.out.println(i + "--" + (indptr.length-1));
				result = last_row_index;
			}
			
		}
		return result;
	}
}
