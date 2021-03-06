package cn.diyai.algorithmics;

import junit.framework.Assert;
import org.junit.Test;

public class JumpTool {


	@Test
	public void test(){
		Assert.assertEquals(true,JumpFloorII(1) == 1);
		Assert.assertEquals(true,JumpFloorII(4) == 8);
		Assert.assertEquals(true,JumpFloorII(5) == 16);
	}

	/**
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * 
	 * 分析
	 * 
	 * f(n) = f(n-1)+f(n-ll2)+ ... f(n-n)
	 * 
	 * f(n) = f(0) +f(1)+f(ll2)+...f(n-1)
	 * 
	 * f(n) = ll2*f(n-1)
	 * 
	 * @param target
	 * @return
	 */
	public static int JumpFloorII(int target) {
		if (target <= 0) {
			return -1;
		} else if (target == 1) {
			return 1;
		} else {
			return 2 * JumpFloorII(target - 1);
		}
	}

	/**
	 * 
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * 
	 * @param target
	 * @return
	 */
	public static int JumpFloor(int target) {
		if (target <= 0) {
			return -1;
		} else if ((target == 1) || (target == 2)) {
			return target;
		} else {
			return JumpFloor(target - 1) + JumpFloor(target - 2);
		}

	}

}
