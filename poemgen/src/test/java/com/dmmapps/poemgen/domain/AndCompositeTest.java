package com.dmmapps.poemgen.domain;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AndCompositeTest {

	@Test
	public void generateTest(){
		AndComposite andComp = new AndComposite("RULE1");
		
		Word w = new Word();
		w.parse("apple", null);
		andComp.add(w);

		w = new Word();
		w.parse("poem", null);
		andComp.add(w);

		w = new Word();
		w.parse("rule", null);
		andComp.add(w);

		w = new Word();
		w.parse("sun", null);
		andComp.add(w);
		
		Assert.assertNotNull(andComp.generate());
		Assert.assertEquals(andComp.generate(), "apple poem rule sun");
	}

}
