/**
 * 
 */
package com.dmmapps.poemgen.domain;

import java.util.Map;

/**
 * Represents a word
 * 
 * @author davidmurillomatallana
 *
 */
public class Word extends GrammaticalRule {

	
	/**
	 * the word
	 */
	public String word;
	
	/**
	 * @see com.dmmapps.poemgen.domain.GrammaticalRule#generate()
	 */
	public String generate() {
		return word;
	}

	/* (non-Javadoc)
	 * @see com.dmmapps.poemgen.domain.GrammaticalRule#add(com.dmmapps.poemgen.domain.GrammaticalRule)
	 */
	public void add(GrammaticalRule rule) {
	}

	/* (non-Javadoc)
	 * @see com.dmmapps.poemgen.domain.GrammaticalRule#parse(java.lang.String, java.util.Map)
	 */
	public void parse(String txt, Map<String, GrammaticalRule> rulesMap) {
		word = txt;
	}
	
}
