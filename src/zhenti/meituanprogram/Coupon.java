package zhenti.meituanprogram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/13 10:28
 * @ProjectName: JavaBaseTest
 * <优惠券></>
 * 10% 超时
 */
public class Coupon {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int m;//m条记录
            m= Integer.valueOf(scanner.nextLine().trim());

            HashMap<Character,Integer> mapin=new HashMap<>();//记录买次数
            ArrayList<String> out=new ArrayList<>();//记录消费记录
            mapin.put('x',0);

            for(int i=0;i<m;i++){
                String[] str=scanner.nextLine().split(" ");
                if(str.length==1){ //模糊情况:作为购买处理
                    mapin.put('x',mapin.get('x')+1);
                }else{
                    if(str[0].equals("O")){ //消费
                        out.add(str[1]+","+(i+1));
                    }else{ //购买
                        char key=str[1].toCharArray()[0];
                        if(mapin.containsKey(key)){
                            mapin.put(key,mapin.get(key)+1);
                        }else{
                            mapin.put(key,1);
                        }
                    }
                }
            }
            //判定合法xing
            boolean isFind=false;
            for(int i=0;i<out.size();i++){
                String[] consume=out.get(i).split(",");
                if(mapin.containsKey(consume[0].toCharArray()[0]) && mapin.get(consume[0].toCharArray()[0])>0){//包含字符
                    mapin.put(consume[0].toCharArray()[0],mapin.get(consume[0].toCharArray()[0])-1);
                }else if(mapin.containsKey('x') && mapin.get('x')>0){//用x字符替代
                    mapin.put('x',mapin.get('x')-1);
                }else{
                    System.out.println(Integer.valueOf(consume[1]));
                    isFind=true;
                }
            }
            if(!isFind)
                System.out.println(-1);
        }
    }
}
