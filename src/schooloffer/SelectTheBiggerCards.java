package schooloffer;

import java.util.Scanner;

/**
 * Created by caoxiaohong on 17/10/13.
 * 扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A，2各4张....
 * 基本规则:
 * (1）输入每手牌可能是个子，对子，顺子（连续5张），三个，炸弹（四个）和对王中的一种，不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
 *（2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系（如，对子跟对子比较，三个跟三个比较），不考虑拆牌情况（如：将对子拆分成个子）
 *（3）大小规则跟大家平时了解的常见规则相同，个子，对子，三个比较牌面大小；顺子比较最小牌大小；炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；
 *（4）输入的两手牌不会出现相等的情况。
 */
public class SelectTheBiggerCards {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String[] cards=scanner.nextLine().split("-");//cards[0]:表示左手牌  &&   cards[1]:表示右手牌
            //长度为4或者2时候要特殊处理:判定是否有对王或者有炸弹
            String[] left=cards[0].split(" ");
            String[] right=cards[1].split(" ");
            //转换
            strTransToNum(left);
            strTransToNum(right);

            //算法
            //4种情况:存在王对
            if(left.length==2 && left[0].equals("16") && left[1].equals("17")){
                System.out.println("joker"+" "+"JOKER");
            }else if(left.length==2 && left[0].equals("17") && left[1].equals("16")){
                System.out.println("JOKER"+" "+"joker");
            }else if(right.length==2 && right[0].equals("16") && right[1].equals("17")){
                System.out.println("joker"+" "+"JOKER");
            }else if(right.length==2 && right[0].equals("17") && right[1].equals("16")){
                System.out.println("JOKER"+" "+"joker");
            }
            //2种情况:存在炸弹
            else if(left.length==4){
                //取值范围:3 4 5 6 7 8 9 10 J Q K A 2
                if(left[0].equals("11"))
                    System.out.println("J"+" "+"J"+" "+"J"+" "+"J");
                else if(left[0].equals("12"))
                    System.out.println("Q"+" "+"Q"+" "+"Q"+" "+"Q");
                else if(left[0].equals("13"))
                    System.out.println("K"+" "+"K"+" "+"K"+" "+"K");
                else if(left[0].equals("14"))
                    System.out.println("A"+" "+"A"+" "+"A"+" "+"A");
                else if(left[0].equals("15"))
                    System.out.println("2"+" "+"2"+" "+"2"+" "+"2");
                else
                    System.out.println(left[0]+" "+left[0]+" "+left[0]+" "+left[0]);
            }else if(right.length==4){
                //取值范围:3 4 5 6 7 8 9 10 J Q K A 2
                if(right[0].equals("11"))
                    System.out.println("J"+" "+"J"+" "+"J"+" "+"J");
                else if(right[0].equals("12"))
                    System.out.println("Q"+" "+"Q"+" "+"Q"+" "+"Q");
                else if(right[0].equals("13"))
                    System.out.println("K"+" "+"K"+" "+"K"+" "+"K");
                else if(right[0].equals("14"))
                    System.out.println("A"+" "+"A"+" "+"A"+" "+"A");
                else if(right[0].equals("15"))
                    System.out.println("2"+" "+"2"+" "+"2"+" "+"2");
                else
                    System.out.println(right[0]+" "+right[0]+" "+right[0]+" "+right[0]);
            }
            //其他情况:个子\对子\顺子\三个
            else{
                if(left.length!=right.length)
                    System.out.println("ERROR");
                else{
                    int from=Math.max(Integer.valueOf(left[0]),Integer.valueOf(right[0]));
                    if(left.length==5){//顺子
                        //from范围:4 5 6 7 8 9 10 J Q K
                        if(from<7){
                            System.out.println(from++ +" "+ from++ +" "+from++ +" "+from++ +" "+from);
                        }
                        else if(from==7){
                            System.out.println("7"+" "+"8"+" "+"9"+" "+"10"+" "+"J");
                        }else if(from==8){
                            System.out.println("8"+" "+"9"+" "+"10"+" "+"J"+" "+"Q");
                        }else if(from==9){
                            System.out.println("9"+" "+"10"+" "+"J"+" "+"Q"+" "+"K");
                        }else if(from==10){
                            System.out.println("10"+" "+"J"+" "+"Q"+" "+"K"+" "+"A");
                        }else if(from==11){
                            System.out.println("J"+" "+"Q"+" "+"K"+" "+"A"+"2");
                        }else if(from==12){
                            System.out.println("Q"+" "+"K"+" "+"A"+"2"+"joker");
                        }else if(from ==13){
                            System.out.println("K"+" "+"A"+"2"+"joker"+" "+"JOKER");
                        }
                    }else if(left.length==1){
                        //from范围:4 5 6 7 8 9 10 J Q K A 2 joker JOKER
                        if(from<11)
                            System.out.println(from);
                        else if(from==11)
                            System.out.println("J");
                        else if(from==12)
                            System.out.println("Q");
                        else if(from==13)
                            System.out.println("K");
                        else if(from==14)
                            System.out.println("A");
                        else if(from==15)
                            System.out.println("2");
                        else if(from==16)
                            System.out.println("joker");
                        else if(from==17)
                            System.out.println("JOKER");
                    }else if(left.length==2){
                        if(from<11)
                            System.out.println(from+" "+from);
                        else if(from==11)
                            System.out.println("J"+" "+"J");
                        else if(from==12)
                            System.out.println("Q"+" "+"Q");
                        else if(from==13)
                            System.out.println("K"+" "+"K");
                        else if(from==14)
                            System.out.println("A"+" "+"A");
                        else if(from==15)
                            System.out.println("2"+" "+"2");
                    }else if(left.length==3){
                        if(from<11)
                            System.out.println(from+" "+from+" "+from);
                        else if(from==11)
                            System.out.println("J"+" "+"J"+" "+"J");
                        else if(from==12)
                            System.out.println("Q"+" "+"Q"+" "+"Q");
                        else if(from==13)
                            System.out.println("K"+" "+"K"+" "+"K");
                        else if(from==14)
                            System.out.println("A"+" "+"A"+" "+"A");
                        else if(from==15)
                            System.out.println("2"+" "+"2"+" "+"2");
                    }
                }
            }
        }
    }

    /**string 转为数字
     * @param strs
     */
    private static void strTransToNum(String[] strs){
        for(int i=0;i<strs.length;i++){
            // J Q K A 2 joker JOKER
            if(strs[i].equals("J"))
                strs[i]="11";
            else if(strs[i].equals("Q"))
                strs[i]="12";
            else if(strs[i].equals("K"))
                strs[i]="13";
            else if(strs[i].equals("A"))
                strs[i]="14";
            else if(strs[i].equals("2"))
                strs[i]="15";
            else if(strs[i].equals("joker"))
                strs[i]="16";
            else if(strs[i].equals("JOKER"))
                strs[i]="17";
        }
    }
}
