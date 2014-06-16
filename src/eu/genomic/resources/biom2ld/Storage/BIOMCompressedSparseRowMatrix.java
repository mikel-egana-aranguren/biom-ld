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

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * A representation of BIOM Compressed Sparse Row Matrix with associated
 * utilities. See:
 * <ul>
 * <li>http://en.wikipedia.org/wiki/Sparse_matrix</li>
 * <li>http://netlib.org/linalg/html_templates/node91.html#SECTION00931100000000000000</li>
 * <li>http://homepage.cs.uiowa.edu/~sriram/21/fall07/code/CRS.java</li>
 * </ul>
 * 
 * @author Mikel Egaña Aranguren
 * @version 0.0.1
 * @date 2014 eka 16
 */
public class BIOMCompressedSparseRowMatrix implements Iterable<ArrayList>{
	 private double [] data;
	 private int [] indices;
	 private int [] indptr;

//	double[] data = { 1, 5, 1, 2, 3, 1, 1, 4, 2, 2, 1, 1, 1, 1, 1 };
//	int[] indices = { 2, 0, 1, 3, 4, 5, 2, 3, 5, 0, 1, 2, 5, 1, 2 };
//	int[] indptr = { 0, 1, 6, 9, 13, 15 };

	/**
	 * @param matrix_data
	 *            : an array containing the actual non-zero values
	 * @param matrix_indices
	 *            : an array containing the column index for each non-zero value
	 * @param matrix_indptr
	 *            : an array containing the locations in the matrix_data that
	 *            start a row
	 */

	public BIOMCompressedSparseRowMatrix(double[] matrix_data,
			int[] matrix_indices, int[] matrix_indptr) {
		 this.data = matrix_data;
		 this.indices = matrix_indices;
		 this.indptr = matrix_indptr;

	}

//	public void walkCSR() {
//		int last_column = 0;
//		for (int k = 0; k < data.length; k++) {
//			last_column = getRowIndexFromDataValue(k, last_column);
//			System.out.println("VALUE " + data[k] + " COLUMN INDEX "
//					+ getColumnIndexFromDataValue(k) + " ROW INDEX "
//					+ last_column);
//		}
//	}

	private int getColumnIndexFromDataValue(int data_index) {
		return indices[data_index];
	}

	private int getRowIndexFromDataValue(int data_index, int last_row_index) {
		int result = 0;
		for (int i = 0; i < indptr.length; i++) {
			if (data_index == indptr[i]) {
//				System.out.println(data_index + "--" + indptr[i] + "--" + i);
				result = i;
				break;
			}
			if (i == indptr.length - 1) {
//				System.out.println(i + "--" + (indptr.length - 1));
				result = last_row_index;
			}
		}
		return result;
	}

	/** 
	 * 
	 * An iterator to go throw the CSR matrix
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator iterator() {
		return new CSRITerator();
	}
	
	private class CSRITerator implements Iterator <BIOMCellValue>{
		private int position = 0;
		private int last_column = 0;

		/* (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		public boolean hasNext() {
			return position < data.length;
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 * @return returns an ArrayList (value, row index, column index)
		 */
		public BIOMCellValue next() {
			last_column = getRowIndexFromDataValue(position, last_column);
			BIOMCellValue result = new BIOMCellValue(data[position], last_column, getColumnIndexFromDataValue(position));

//			result.add(data[position]);
//			result.add(last_column);
//			result.add(getColumnIndexFromDataValue(position));
			++position;
			return result;
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#remove()
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
