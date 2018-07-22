package cn.diyai.stack;

public class InToPost {

    private StackX stackX;
    private String input;
    private String output= "";

    public InToPost(String input) {
        this.stackX = new StackX(input.length());
        this.input = input;
    }

    public String doTrans(){

        for(int j = 0; j < input.length();j++){
            char ch = input.charAt(j);
            stackX.displayStack("for "+ch+" ");
            switch (ch){
                case '+':
                case '-':
                    gotOper(ch,1);
                    break;
                case '*':
                case '/':
                    gotOper(ch,2);
                    break;
                case '(':
                    stackX.push(ch);
                    break;
                case '）':
                    gotParen(ch);
                    break;

                default:
                    output = output + ch;
                    break;
            }
        }

        while(!stackX.isEmpty()){
            stackX.displayStack("while ");
            output = output + stackX.pop();
        }

        stackX.displayStack("End  ");
        return output;
    }

    public void gotOper(char opThis,int prec1){
        while (!stackX.isEmpty()){
            char opTop = stackX.pop();

            if(opTop == '('){
                stackX.push(opTop);
                break;
            }else{
                int prec2;

                if(opTop == '+' || opTop == '-'){
                    prec2 =1;
                }else{
                    prec2 =2;
                }

                if(prec2 < prec1){
                    stackX.push(opTop);
                    break;
                }else{
                    output = output +opTop;

                }
            }
            stackX.push(opThis);
        }
    }

    public void gotParen(char ch){
        while(!stackX.isEmpty()){
            char chx = stackX.pop();
            if(chx == '('){
                break;
            }else{
                output = output + chx;
            }
        }
    }

    public static void main(String[] args) {
        String output;
        String input = " A*(B+C) - D/(E+F)";

        InToPost theTrans = new InToPost(input);
        output = theTrans.doTrans();

        System.out.println("Postfix is "+ output+"\n");

    }
}
