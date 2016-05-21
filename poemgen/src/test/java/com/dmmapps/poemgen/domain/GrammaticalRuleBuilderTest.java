package com.dmmapps.poemgen.domain;

import java.io.BufferedReader;
import java.io.FileReader;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GrammaticalRuleBuilderTest {

	@Test
	public void buildTest(){
		try {
			FileReader fr = new FileReader("grammatical_rules1.txt");
			BufferedReader br = new BufferedReader(fr);
			GrammaticalRuleBuilder builder = new GrammaticalRuleBuilder();
			GrammaticalRule gr = builder.build(br, "POEM");
			
			System.out.println(gr.generate());
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}
}
