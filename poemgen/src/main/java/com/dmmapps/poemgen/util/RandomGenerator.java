package com.dmmapps.poemgen.util;

import java.util.Random;

/**
 * Random generator
 * 
 * @author davidmurillomatallana
 *
 */
public class RandomGenerator {

	private static Random random = new Random();
	
	/**
	 * Returns a pseudo-random integer number between
	 * 0 (inclusive) and max value (exclusive)
	 * 
	 * @param max max value
	 * @return integer number
	 */
	public static int getInt(int max){
		
		return random.nextInt(max);
	}
}
