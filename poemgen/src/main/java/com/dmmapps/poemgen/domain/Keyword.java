package com.dmmapps.poemgen.domain;

import java.util.Map;

/**
 * A keyword for the grammatical rule
 * @author davidmurillomatallana
 *
 */
public class Keyword extends GrammaticalRule {

	/**
	 * Keyword LINEBREAK constant
	 */
	public static final String LINEBREAK = "LINEBREAK";
	
	/**
	 * Keyword END constant
	 */
	public static final String END = "END";
	
	
	/**
	 * Keyword name (LINEBREAK, END)
	 */
	private String name;

	/**
	 * @see com.dmmapps.poemgen.domain.GrammaticalRule#generate()
	 */
	public String generate() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.dmmapps.poemgen.domain.GrammaticalRule#add(com.dmmapps.poemgen.domain.GrammaticalRule)
	 */
	public void add(GrammaticalRule rule) {
	}
	
	public void parse(String txt, Map<String, GrammaticalRule> rulesMap){
		
		if (txt.equalsIgnoreCase(END)){
			name = "";
		} else if (txt.equalsIgnoreCase(LINEBREAK)){
			name = "\n";
		}
	}
	
}
