package com.dmmapps.poemgen.domain;

import java.util.Map;

/**
 * Represents a grammatical rule
 * @author davidmurillomatallana
 *
 */
public abstract class GrammaticalRule {
		
	/**
	 * Generates text according to
	 * the grammatical rule
	 * 
	 * @return text
	 */
	public abstract String generate();

	/**
	 * adds a child grammatical rule
	 * @param rule
	 */
	public abstract void add(GrammaticalRule rule);
	
	public abstract void parse(String txt, Map<String, GrammaticalRule> rulesMap);
	
	protected GrammaticalRule parseNodeRule(String txt, 
			Map<String, GrammaticalRule> rulesMap){
		
		if (txt.charAt(0) == '<'){
			String ruleName = txt.substring(1, txt.indexOf('>'));
			return rulesMap.get(ruleName);
			
		} else if (txt.charAt(0) == '$'){
			Keyword keyword = new Keyword();;
			keyword.parse(txt.substring(1), rulesMap);
			return keyword;
		} else {
			Word word = new Word();
			word.parse(txt, rulesMap);
			return word;
		}
		
	}

}
