import java.util.*;
public class Security
{
    public static void main (String[] args){
        System.out.println("ok");
        String defToken = "0cc175b9c0f1b6a831c399e269772661";
        getSign(defToken);
        System.out.println(getSign(defToken));
    }
    // getSign 方法
    public static String getSign(String token){
        if(token.length() != 32){
            System.out.println("token长度不符合要求");
            return "token长度不符合要求";
        }else{
            System.out.println(token);
            String[] charToken = token.split("");
            String newTokenStr = charToken[2] + charToken[5] + charToken[8];
//            十六进制转十进制
            long abToken = Long.parseLong(newTokenStr, 16);
            long moToken = abToken%8;
            int moTokenNub = (int)moToken;
            List<int[]> tokenList = new ArrayList<int[]>();
//            储存数组
            int[] is0 = {2,3,1,17,22,28};
            int[] is1 = {0,8,19,23,30,31};
            int[] is2 = {9,15,31,1,5,7};
            int[] is3 = {11,21,31,10,12,16};
            int[] is4 = {30,1,12,18,25,28};
            int[] is5 = {8,14,17,27,1,4};
            int[] is6 = {2,8,13,19,20,24};
            int[] is7 = {5,16,20,29,18,22};
            tokenList.add(is0);
            tokenList.add(is1);
            tokenList.add(is2);
            tokenList.add(is3);
            tokenList.add(is4);
            tokenList.add(is5);
            tokenList.add(is6);
            tokenList.add(is7);

            int[] lastToken = tokenList.get(moTokenNub);
//            System.out.println(lastToken);
            String putToken = "";
            for (int i = 0 ; i < lastToken.length; i++){
                String newLastTokenStr = charToken[lastToken[i]];
                putToken = putToken + newLastTokenStr;
            }
//            System.out.println(putToken);
            return putToken;
        }
    }
}