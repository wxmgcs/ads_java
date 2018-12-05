package cn.diyai.utils;

import junit.framework.Assert;
import org.junit.Test;

public class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        int hDirection = 0;
        int vDirection = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    vDirection++;
                    break;
                case 'D':
                    vDirection--;
                    break;
                case 'L':
                    hDirection--;
                    break;
                case 'R':
                    hDirection++;
                default:
                    break;
            }
        }
        return vDirection == 0 && hDirection == 0 ? true : false;

    }

    public boolean judgeCircle2(String moves){
        char[] map=new char[128];
        for(char move:moves.toCharArray()){
            map[move]++;
        }
        return map['U']==map['D']&&map['R']==map['L'];
    }

    @Test
    public void test(){

        Assert.assertEquals(true,judgeCircle("UD"));
        Assert.assertEquals(false,judgeCircle("LL"));
        Assert.assertEquals(true,judgeCircle2("UD"));
        Assert.assertEquals(false,judgeCircle2("LL"));
    }

}
