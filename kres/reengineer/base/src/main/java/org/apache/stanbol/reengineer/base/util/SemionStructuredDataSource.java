package org.apache.stanbol.reengineer.base.util;

import java.io.Serializable;

import org.apache.clerezza.rdf.core.MGraph;
import org.apache.clerezza.rdf.core.UriRef;

/**
 * 
 * A {@code SemionStructuredDataSource} is the representation of a data source after it has been reengineerd by Semion.
 * Basically it is identified by two UriRefs (see {@link UriRef}:
 * <ul>
 * <li> {@code schemaUriRef} that identifies the {@link MGraph} generated by Semion from the original data source schema
 * <li> {@code dataUriRef} that identifies the {@link MGraph} generated by Semion from the original data source data
 * </ul>
 * 
 * @author andrea.nuzzolese
 *
 */

public class SemionStructuredDataSource implements Serializable {

	/**
	 * Serial Version (generated)
	 */
	private static final long serialVersionUID = -4963544655534544288L;
	
	private UriRef schemaUriRef;
	private UriRef dataUriRef;
	
	/**
	 * Default constructor to be compliant with the Serializable interface.
	 */
	public SemionStructuredDataSource() {
		
	}
	
	/**
	 * It creates a {@code SemionStructuredDataSource} with a {@link UriRef} both for the schema and the data of a reengineered
	 * data source by Semion.
	 */
	public SemionStructuredDataSource(UriRef schemaUriRef, UriRef dataUriRef) {
		this.schemaUriRef = schemaUriRef;
		this.dataUriRef = dataUriRef;
	}
	
	/**
	 * Gets the {@link UriRef} for the {@link MGraph} of schema generated by the Semion reengineer.
	 * @return the {@link UriRef} for the {@link MGraph} of the schema. 
	 */
	public UriRef getSchemaUriRef() {
		return schemaUriRef;
	}
	
	/**
	 * Sets the {@link UriRef} for the {@link MGraph} of schema generated by the Semion reengineer. 
	 */
	public void setSchemaUriRef(UriRef schemaUriRef) {
		this.schemaUriRef = schemaUriRef;
	}
	
	/**
	 * Gets the {@link UriRef} for the {@link MGraph} of data generated by the Semion reengineer.
	 * @return the {@link UriRef} for the {@link MGraph} of the data. 
	 */
	public UriRef getDataUriRef() {
		return dataUriRef;
	}
	
	/**
	 * Gets the {@link UriRef} for the {@link MGraph} of data generated by the Semion reengineer.
	 */
	public void setDataUriRef(UriRef dataUriRef) {
		this.dataUriRef = dataUriRef;
	}
	
}
