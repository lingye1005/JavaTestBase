package zhenti.meituanprogram;

import java.util.*;

/**
 * @Author: cxh
 * @CreateTime: 17/12/13 15:17
 * @ProjectName: JavaBaseTest
 * 90% 大数不能通过
 */
public class ChampinShips {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            long n;
            n=scanner.nextLong();//n (1≤n≤ 2^20)
            long ximmei=scanner.nextLong();//小美积分
            List<Long> original=new ArrayList<>();//数字范围：-1000000…1000000
            for(int i=0;i<n-1;i++){
                original.add(scanner.nextLong());
            }
            //n=1
            if(original.size()==0){
                System.out.println(0);
                continue;
            }
            //处理
            Collections.sort(original);
            if(ximmei<original.get(0)){
                System.out.println(0);
                continue;
            }else{
                int lunci=0;
                while (original.size()>1){
                    if(original.get(0)>ximmei)
                        break;
                    ArrayList<Long> remain=new ArrayList<>();
                    for(int i=1;i<original.size()-1;i+=2)
                        remain.add(original.get(i)>original.get(i+1)?original.get(i):original.get(i+1));
                    //删除original中多余的元素
                    while (original.size()>remain.size()){
                        original.remove(original.size()-1);
                    }
                    Collections.copy(original,remain);
                    lunci++;
                }
                if(original.size()==1 && original.get(0)<ximmei)
                    System.out.println(++lunci);
                else
                    System.out.println(lunci);
            }
        }
    }
}
