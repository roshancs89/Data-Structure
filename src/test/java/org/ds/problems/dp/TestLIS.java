package org.ds.problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.management.AttributeNotFoundException;

import junit.framework.TestCase;

public class TestLIS extends TestCase {
	
	LIS lis = new LIS();
	
	public void testGetLongestSequenceWithShortChain() throws AttributeNotFoundException {
		Integer[] listVal = new Integer[]{3, 10, 2, 1, 20};
		List<Integer> seqList = Arrays.asList(listVal);
		assertEquals(3, lis.getLongestSequence(seqList));
	}
	
	public void testGetLongestSequenceWithLongChain() throws AttributeNotFoundException {
		Integer[] listVal = new Integer[]{10, 22, 9, 33, 21, 50,41,60,80};
		List<Integer> seqList = Arrays.asList(listVal);
		assertEquals(6, lis.getLongestSequence(seqList));
	}
	
	public void testGetLongestSequenceNotStartsatFirstIndex() throws AttributeNotFoundException {
		Integer[] listVal = new Integer[]{50, 3, 10, 7, 40, 80};
		List<Integer> seqList = Arrays.asList(listVal);
		assertEquals(4, lis.getLongestSequence(seqList));
	}
	
	public void testNoSequence() throws AttributeNotFoundException {
		Integer[] listVal = new Integer[]{3,2};
		List<Integer> seqList = Arrays.asList(listVal);
		assertEquals(1, lis.getLongestSequence(seqList));
	}
	
}
