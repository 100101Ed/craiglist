/**
 * File Name: Postadd.java<br>
 * Mora, Eduardo<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Feb 15, 2016
 */
package com.sqa.em.util.craiglist;

import com.sqa.em.util.helper.RequestInput;

/**
 * Postadd //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Mora, Eduardo
 * @version 1.0.0
 * @since 1.0
 */
public class Postadd {

	private String category;

	/**
	 * @param category
	 */
	public Postadd() {
		this(RequestInput.getString("For Craiglist what Category would you like to post your Ad to: "));
	}

	/**
	 * @param category
	 */
	public Postadd(String category) {
		setCategory(category);
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return this.category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Postadd [category=");
		builder.append(this.category);
		builder.append("]");
		return builder.toString();
	}
}
