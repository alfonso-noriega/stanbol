package org.apache.stanbol.ontologymanager.ontonet.api.ontology;

public enum SpaceType {

	CORE("core"), CUSTOM("custom"), SESSION("session");

	private SpaceType(String suffix) {
		this.suffix = suffix;
	}

	private String suffix;

	public String getIRISuffix() {
		return suffix;
	}

}
