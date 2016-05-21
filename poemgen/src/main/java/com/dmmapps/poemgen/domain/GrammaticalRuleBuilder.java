package com.dmmapps.poemgen.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class GrammaticalRuleBuilder {

	public GrammaticalRule build(BufferedReader reader, String rootRuleName) throws IOException {
		Map<String, GrammaticalRule> rulesMap = new HashMap<String, GrammaticalRule>();
		List<String> lines = new ArrayList<String>();
		
		for (String line = reader.readLine(); line != null; line = reader.readLine()){
			createRule(line, rulesMap);
			lines.add(line);
		}

		for (String line: lines){
			processLine(line, rulesMap);
		}
		
		return rulesMap.get(rootRuleName);
	}

	private void createRule(String line, Map<String, GrammaticalRule> rulesMap){
		String[] ruleParts = getRuleParts(line);
		String ruleName = ruleParts[0];
		String rule = ruleParts[1];
		
		if (rule.contains(AndComposite.AND_TOKEN)){
			AndComposite andRule = new AndComposite(ruleName);
			rulesMap.put(ruleName, andRule);
			
		} else if (rule.contains(OrComposite.OR_TOKEN)){
			OrComposite orRule = new OrComposite(ruleName);
			rulesMap.put(ruleName, orRule);
			
		} else {
			throw new IllegalArgumentException("the rule is incorrect: " + line) ;
		}
		
	}
	

	private String[] getRuleParts(String line){
		
		StringTokenizer st = new StringTokenizer(line, ":");
		String ruleName = null;
		
		if (st.hasMoreTokens()){
			ruleName = st.nextToken().trim();
		} else {
			throw new IllegalArgumentException("the rule is incorrect: " + line) ;
		}
		
		String rule = null;
		
		if (st.hasMoreTokens()){
			rule = st.nextToken().trim();
		} else {
			throw new IllegalArgumentException("the rule is incorrect: " + line) ;
		}

		return new String[]{ruleName, rule};
	}
	
	private void processLine(String line, Map<String, GrammaticalRule> rulesMap){
		String[] ruleParts = getRuleParts(line);
		String ruleName = ruleParts[0];
		String rule = ruleParts[1];
		GrammaticalRule grammaticalRule = rulesMap.get(ruleName);
		grammaticalRule.parse(rule, rulesMap);
	}
	
}
