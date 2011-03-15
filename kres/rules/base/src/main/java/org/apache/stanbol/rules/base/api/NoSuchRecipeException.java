package org.apache.stanbol.rules.base.api;

import org.semanticweb.owlapi.model.IRI;


/**
 * 
 * @author andrea.nuzzolese
 *
 */

public class NoSuchRecipeException extends Exception {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected IRI recipeIRI;

	/**
	 * Creates a new instance of OntologySpaceModificationException.
	 * 
	 * @param space
	 *            the ontology space whose modification was attempted.
	 */
	public NoSuchRecipeException(IRI recipeIRI) {
		this.recipeIRI = recipeIRI;
	}

	/**
	 * Returns the {@link IRI} of the recipe that threw the exception.
	 * 
	 * @return the recipe {@link IRI} on which the exception was thrown.
	 */
	public IRI getRecipeIRI() {
		return recipeIRI;
	}
	
	

}
