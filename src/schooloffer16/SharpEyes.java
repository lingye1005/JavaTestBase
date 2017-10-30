package schooloffer16;

import java.util.*;

/**
 * Created by caoxiaohong on 17/9/20.
 * 现在我们需要查出一些作弊的问答社区中的ID，作弊有两种：1.A回答了B的问题，同时B回答了A的问题。那么A和B都是作弊。
 * 2.作弊ID用户A和作弊ID用户B同时回答了C的问题，那么C也是作弊。已知每个用户的ID是一串数字，一个问题可能有多个人回答。
 */
public class SharpEyes {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N;//第一行为总问题数N(N小于等于200000)
        while (scanner.hasNext()) {
            //输入问题个数N
            N = scanner.nextInt();
            String inValid=scanner.nextLine();//无效
            ArrayList<ArrayList<Integer>> questions=new ArrayList<ArrayList<Integer>>();//问题集
            //输入N个问题
            for(int i=0;i<N;i++){
                String str=scanner.nextLine();
                String[] strs=str.split(" ");
                ArrayList<Integer> tmp=new ArrayList<Integer>();
                for(String s:strs){
                    tmp.add(Integer.valueOf(s));
                }
                questions.add(tmp);
            }

            //结果集
            ArrayList<Integer> result=new ArrayList<Integer>();
            //list.get(i).get(0);问问题人ID
            //list.get(i).get(1):回答人数目
            for(int i=0;i<questions.size();i++){
                int id=questions.get(i).get(0);
                for(int j=2;j<questions.get(i).size();j++){
                    int otherID=questions.get(i).get(j);
                    for(int k=i+1;k<questions.size();k++){
                        int id1=questions.get(k).get(0);
                        for(int m=2;m<questions.get(k).size() && id1!=id;m++){
                            int otherID1=questions.get(k).get(m);
                            if(id==otherID1 && otherID==id1){
                                if(!result.contains(id))
                                    result.add(id);
                                if(!result.contains(id1))
                                    result.add(id1);
                            }
                        }
                    }
                }
            }
            Collections.sort(result);
            System.out.println(result.size());
            for(int i=0;i<result.size();i++){
                if(i<result.size()-1){
                    System.out.print(result.get(i)+" ");
                }else{
                    System.out.println(result.get(i));
                }
            }
        }
    }
}
