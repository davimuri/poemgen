/**
 * 
 */
package com.dmmapps.poemgen.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.dmmapps.poemgen.util.RandomGenerator;

/**
 * Represents the or operator in a gramatical rule. Eg: heart|sun|moon
 * @author davidmurillomatallana
 *
 */
public class OrComposite extends GrammaticalRule {

	public static final String OR_TOKEN = "|";
	/**
	 * rule name
	 */
	private String ruleName;
	
	/**
	 * The grammatical rules contained by the or operator
	 */
	List<GrammaticalRule> childGrammaticalRules;

	public OrComposite(){
		childGrammaticalRules = new ArrayList<GrammaticalRule>();
	}
	
	public OrComposite(String ruleName){
		this();
		this.ruleName = ruleName;
	}
	
	/** 
	 * @see com.dmmapps.poemgen.domain.GrammaticalRule#generate()
	 */
	public String generate() {
		
		if (childGrammaticalRules == null || childGrammaticalRules.isEmpty()){
			throw new IllegalStateException("The or composite grammatical rule is not correct");
		}
		
		int i = RandomGenerator.getInt(childGrammaticalRules.size());
		
		return childGrammaticalRules.get(i).generate();
	}
	
	public void parse(String txt, Map<String, GrammaticalRule> rulesMap){
		StringTokenizer st = new StringTokenizer(txt, OR_TOKEN);
		
		while (st.hasMoreTokens()){
			add(parseNodeRule(st.nextToken(), rulesMap));
		}
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
	
	
}
