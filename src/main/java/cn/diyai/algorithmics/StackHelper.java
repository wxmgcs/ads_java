package cn.diyai.algorithmics;

import junit.framework.TestCase;

public class StackHelper extends TestCase {

	public boolean IsPopOrder(int [] pushA,int [] popA) {
		
		if(pushA.length != popA.length){
			return false;
		}
		
		
		return false;
	      
    }
	
	public static void main(String[] args) {
		int[] pushA = new int[]{1,2,3,4,5};
		StackHelper stackHelper = new StackHelper();
		assertEquals(true, stackHelper.IsPopOrder(pushA,new int[]{4,5,3,2,1}));
		assertEquals(false, stackHelper.IsPopOrder(pushA,new int[]{4,3,5,1,2}));
		assertEquals(false, stackHelper.IsPopOrder(pushA,new int[]{4,3,5,1}));

	}

}
