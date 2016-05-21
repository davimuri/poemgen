/**
 * 
 */
package com.dmmapps.poemgen.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Represents the and operator in a gramatical rule. Eg: heart <NOUN>
 * @author davidmurillomatallana
 *
 */
public class AndComposite extends GrammaticalRule {

	public static final String AND_TOKEN = " ";
	
	/**
	 * rule name
	 */
	private String ruleName;
	
	/**
	 * The grammatical rules contained by the and operator
	 */
	List<GrammaticalRule> childGrammaticalRules;

	public AndComposite(String ruleName){
		this.ruleName = ruleName;
		childGrammaticalRules = new ArrayList<GrammaticalRule>();
	}
	
	/**
	 * @see com.dmmapps.poemgen.domain.GrammaticalRule#generate()
	 */
	public String generate() {
		
		if (childGrammaticalRules == null || childGrammaticalRules.isEmpty()){
			throw new IllegalStateException("The and composite grammatical rule is not correct");
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (GrammaticalRule gr: childGrammaticalRules){
			sb.append(gr.generate());
			sb.append(" ");
		}
		
		return sb.toString().substring(0, sb.length() - 1);
	}

	/**
	 * Adds a grammatical rule
	 * @param gr
	 */
	public void add(GrammaticalRule gr){
		childGrammaticalRules.add(gr);
	}

	/**
	 * @return the ruleName
	 */
	public String getRuleName() {
		return ruleName;
	}

	/**
	 * @param ruleName the ruleName to set
	 */
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	/* (non-Javadoc)
	 * @see com.dmmapps.poemgen.domain.GrammaticalRule#parse(java.lang.String, java.util.Map)
	 */
	public void parse(String txt, Map<String, GrammaticalRule> rulesMap) {
		StringTokenizer st = new StringTokenizer(txt, AND_TOKEN);
		
		while (st.hasMoreTokens()){
			add(processSubRule(st.nextToken(), rulesMap));
		}

	}

	private GrammaticalRule processSubRule(String txt, 
			Map<String, GrammaticalRule> rulesMap){
		
		if (txt.contains(OrComposite.OR_TOKEN)){
			OrComposite orRule = new OrComposite();
			StringTokenizer st = new StringTokenizer(txt, "|");
			
			while (st.hasMoreTokens()){
				orRule.add(parseNodeRule(st.nextToken(), rulesMap));
			}
			
			return orRule;
		}
		
		return parseNodeRule(txt, rulesMap);
	}

}
