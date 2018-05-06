package cn.diyai.algorithmics;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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
	
	
	public static void main(String[] args) {
		System.out.println(new StringHelper().getLength("hello world"));
	}

	@Test
	public void testLength() throws Exception {

		StringHelper helper = new StringHelper();
		assertEquals(5, helper.getLength("hello world"));
		assertEquals(5, helper.getLength("hello world  "));
		assertEquals(6, helper.getLength(" XSUWHQ\n"));
		assertEquals(0, helper.getLength(""));
	}
	
	@Test
	public void testPermutation() throws Exception{
		StringHelper helper = new StringHelper();
		assertEquals(6, helper.getPermutation("abc").size());
		for(String str:helper.getPermutation("abc")){
			System.out.println(str);
		}
	}
	
	public void testCombiantion(){
		char chs[]={'a','b','c'};  
        combiantion(chs);
        
	}
}
