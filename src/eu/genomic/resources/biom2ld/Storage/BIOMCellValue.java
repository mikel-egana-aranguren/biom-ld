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
 * An object to store a BIOM table cell
 * 
 * @author Mikel Egaña Aranguren
 * @version
 * @date 2014 eka 16
 */
public final class BIOMCellValue {
	 private double value;
	 private int row_index;
	 private int col_index;

	/**
	 * @param value the actual value of the cell
	 * @param row_index the row of this cell
	 * @param col_index the column of this cell
	 */
	public BIOMCellValue(double value, int row_index, int col_index) {
		this.value = value;
		this.row_index = row_index;
		this.col_index = col_index;
	}

	/**
	 * @return the value
	 */
	public final double getValue() {
		return value;
	}

	/**
	 * @return the row_index
	 */
	public final int getRow_index() {
		return row_index;
	}

	/**
	 * @return the col_index
	 */
	public final int getCol_index() {
		return col_index;
	}

}
