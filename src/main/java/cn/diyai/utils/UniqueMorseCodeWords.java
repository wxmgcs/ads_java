package cn.diyai.utils;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueMorseCodeWords {

    private int uniqueMorseRepresentations(String[] words) {

        String[] maps = new String[]{".-","-...","-.-.","-..",".","..-.",
                "--.","....","..",".---","-.-",".-..","--","-.","---",
                ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        List<String> keys = new ArrayList<>();
        if(words == null || words.length == 0){
            return 0;
        }

        for(int i = 0 ; i < words.length;i++){
            //转换每个字符
            StringBuffer sb =  new StringBuffer();
            String str = words[i];
            for(int j = 0 ; j < str.length();j++){
                String map = maps[str.charAt(j) - 'a'];
                sb.append(map);
            }

            if(!keys.contains(sb.toString())){
                keys.add(sb.toString());
            }
        }

        return keys.size();
    }

    private int uniqueMorseRepresentations2(String[] words) {

        String[] maps = new String[]{".-","-...","-.-.","-..",".","..-.",
                "--.","....","..",".---","-.-",".-..","--","-.","---",
                ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> keys = new HashSet<>();
        if(words == null || words.length == 0){
            return 0;
        }

        for(int i = 0 ; i < words.length;i++){
            //转换每个字符
            StringBuffer sb =  new StringBuffer();
            String str = words[i];
            for(int j = 0 ; j < str.length();j++){
                String map = maps[str.charAt(j) - 'a'];
                sb.append(map);
            }

            keys.add(sb.toString());
        }

        return keys.size();
    }

    //优化
    private int uniqueMorseRepresentations3(String[] words){
        String[] maps = new String[]{".-","-...","-.-.","-..",".","..-.",
                "--.","....","..",".---","-.-",".-..","--","-.","---",
                ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> translated = new HashSet<String>();
        for(int i = 0; i < words.length; i++) {
            StringBuilder word = new StringBuilder();
            for(char c : words[i].toCharArray()){
                word.append(maps[c - 'a']);
            }
            translated.add(word.toString());
        }

        return translated.size();
    }

    @Test
    public void test(){

        Assert.assertEquals(2,uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
        Assert.assertEquals(2,uniqueMorseRepresentations2(new String[]{"gin", "zen", "gig", "msg"}));
        Assert.assertEquals(2,uniqueMorseRepresentations3(new String[]{"gin", "zen", "gig", "msg"}));

        Set<String> translated = new HashSet<String>();
        translated.add("1");
        translated.add("1");
        translated.add("1");

        Assert.assertEquals(1,translated.size());


    }
}
