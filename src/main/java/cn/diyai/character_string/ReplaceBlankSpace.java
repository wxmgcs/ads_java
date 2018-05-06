package cn.diyai.character_string;

import junit.framework.TestCase;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
 */
public class ReplaceBlankSpace extends TestCase{
	public static String replaceSpace(StringBuffer str) {
		String replaceStr = "%20";
		char blankSpace = ' ';
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == blankSpace) {
				str.replace(i, i + 1, replaceStr);
			}
		}

		return str.toString();

	}
	
	public void test(){
		StringBuffer sb = new StringBuffer();
		sb.append("We");
		sb.append(" Are Happy.");
		assertEquals("We%20Are%20Happy.", ReplaceBlankSpace.replaceSpace(sb));
	}
	
	public void test2(){
		StringBuffer sb = new StringBuffer();
		assertEquals("", ReplaceBlankSpace.replaceSpace(sb));
	}
	
	public static void main(String[] args) {
		ReplaceBlankSpace replaceBlankSpace = new ReplaceBlankSpace();
		replaceBlankSpace.test();
		replaceBlankSpace.test2();
	}
}
