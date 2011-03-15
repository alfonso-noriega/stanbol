package org.apache.stanbol.ontologymanager.ontonet.api.session;

import org.apache.stanbol.ontologymanager.ontonet.api.DuplicateIDException;
import org.semanticweb.owlapi.model.IRI;


/**
 * Thrown when attempting to create a KReSSession by forcing a session ID that
 * is already registered, even if it used to be associated to a session that has
 * been destroyed.
 * 
 * @author alessandro
 * 
 */
public class DuplicateSessionIDException extends DuplicateIDException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3548783975623103351L;

	public DuplicateSessionIDException(IRI dupe) {
		super(dupe);
	}

	public DuplicateSessionIDException(IRI dupe, String message) {
		super(dupe, message);
	}

	public DuplicateSessionIDException(IRI dupe, Throwable cause) {
		super(dupe, cause);
	}

}
