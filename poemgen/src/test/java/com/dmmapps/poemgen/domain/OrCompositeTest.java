package com.dmmapps.poemgen.domain;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrCompositeTest {

	@Test
	public void generateTest(){
		OrComposite orComp = new OrComposite();
		
		Word w = new Word();
		w.parse("apple", null);
		orComp.add(w);

		w = new Word();
		w.parse("poem", null);
		orComp.add(w);

		w = new Word();
		w.parse("rule", null);
		orComp.add(w);

		w = new Word();
		w.parse("sun", null);
		orComp.add(w);

		Assert.assertNotNull(orComp.generate());
		Assert.assertTrue(orComp.generate().length() >= 3, "The OrComposite returned wrong text");
	}
}
