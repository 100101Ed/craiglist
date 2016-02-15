/**
 * File Name: Craiglist.java<br>
 * Mora, Eduardo<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Feb 15, 2016
 */
package com.sqa.em.util.craiglist;

import com.sqa.em.util.helper.RequestInput;

/**
 * Craiglist //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Mora, Eduardo
 * @version 1.0.0
 * @since 1.0
 */
public class QueryCraiglist {

	private String query;

	private int queryResultsCount;

	/**
	 * Will ask user for the the text to query
	 */
	public QueryCraiglist() {
		this(RequestInput.getString("What is your search criteria for Craiglist: "));
	}

	/**
	 *
	 */
	public QueryCraiglist(String query) {
		setQuery(query);
	}

	/**
	 * @return the query
	 */
	public String getQuery() {
		return this.query;
	}

	/**
	 * @return the queryResultsCount
	 */
	public int getQueryResultsCount() {
		return this.queryResultsCount;
	}

	/**
	 * @param query
	 *            the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}
}
