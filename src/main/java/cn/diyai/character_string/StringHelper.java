package cn.diyai.character_string;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringHelper extends TestCase {

	private int getLength(String str) {
		if (str.length() == 0) {
			return 0;
		}

		int length = str.length();
		int count = 0;
		boolean isBegin = false;

		// 最后一个是空字符，就前找到知道遇到空格或者到字符串头部
		if (str.substring(length - 1, length).equals(" ")) {
			for (int i = str.length(); i > 0; i--) {
				if (!str.substring(i - 1, i).equals(" ")) {
					count += 1;
					isBegin = true;

				} else {
					if (isBegin) {
						return count;
					}
				}
			}
		} else {
			for (int i = str.length(); i > 0; i--) {
				if (!str.substring(i - 1, i).equals(" ")) {
					count += 1;

				} else {
					return count;
				}
			}
		}

		return count;

	}
	
	 public static void combiantion(char chs[]){  
	        if(chs==null||chs.length==0){  
	            return ;  
	        }  
	        List<Character> list=new ArrayList();  
	        for(int i=1;i<=chs.length;i++){  
	            combine(chs,0,i,list);  
	        }  
	    }  
	    //从字符数组中第begin个字符开始挑选number个字符加入list中  
	    public static void combine(char []cs,int begin,int number,List<Character> list){  
	        if(number==0){  
	            System.out.println(list.toString());  
	            return ;  
	        }  
	        if(begin==cs.length){  
	            return;  
	        }  
	        list.add(cs[begin]);  
	        combine(cs,begin+1,number-1,list);  
	        list.remove((Character)cs[begin]);  
	        combine(cs,begin+1,number,list);  
	    }


	/**
	 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
	 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
	 输入描述：输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
	 * @param str
	 * @return
	 */
	public ArrayList<String> getPermutation(String str) {
		
		ArrayList<String>  list = new ArrayList<String>();
		char[] chars = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0;i < chars.length;i++){
			
			sb.append(chars[i]);
			
//			for(char c:chars){
//				sb.append(c);
//			}
		}
		
		list.add(sb.toString());
		return list;
	       
    }


	/**
	 * 判断旋转词
	 *
	 * 如果对于一个字符串A，将A的前面任意一部分挪到后边去形成的字符串称为A的旋转词。
	 * 比如A="12345",A的旋转词有"12345","23451","34512","45123"和"51234"。
	 * 对于两个字符串A和B，请判断A和B是否互为旋转词。
	 给定两个字符串A和B及他们的长度lena，lenb，请返回一个bool值，代表他们是否互为旋转词。

	 思路:枚举出所有的旋转词，看是否在这些旋转词中
	 * @param A
	 * @param lena
	 * @param B
	 * @param lenb
	 * @return
	 */
	public boolean chkRotation(String A, int lena, String B, int lenb) {

		if(lena != lenb){
			return false;
		}

		String temp = "";
		String tail = "";
		String head = "";
		for(int i = 0; i < lena; i++ ){
			head = A.substring(i);
			tail = A.substring(0,i);
			temp =  head + tail;
			System.out.println(temp);
			if (temp.equals(B)) {
				return true;
			}

		}

		return false;
	}


	public static void main(String[] args) {
		System.out.println(new StringHelper().getLength("hello world"));
	}

	@Test
	public void testLength() throws Exception {

		StringHelper helper = new StringHelper();
		assertEquals(5, helper.getLength("hello world"));
		assertEquals(5, helper.getLength("hello world  "));
		assertEquals(7, helper.getLength(" XSUWHQ\n"));
		assertEquals(0, helper.getLength(""));
	}
	
	@Test
	public void testPermutation() throws Exception{
		StringHelper helper = new StringHelper();
		//assertEquals(6, helper.getPermutation("abc").size());
		for(String str:helper.getPermutation("abc")){
			System.out.println(str);
		}
	}
	
	public void testCombiantion(){
		char chs[]={'a','b','c'};  
        combiantion(chs);
        
	}

	public void testChkRotation(){
		assertEquals(true,chkRotation("cdab",4,"abcd",4));
		assertEquals(false,chkRotation("cdab",5,"abcd",4));
		assertEquals(false,chkRotation("cdab",5,"abdc",4));
	}
}
