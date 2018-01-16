package zhenti.wangyileihuo17;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/16 19:39
 * @ProjectName: JavaBaseTest
 * <工作安排></>
 * 10%
 */
public class WorkArrangement {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=Integer.valueOf(scanner.nextLine().trim());//工程师人数n(1 ≤ n ≤ 6)
            String[] abilities=new String[n];//6项工作(编号为0至5),故abilities[i]一定是个由0~5中任意字符组成的字符串.
            for(int i=0;i<n;i++)
                abilities[i]=scanner.nextLine().trim();//每行一个字符串表示第i(1 ≤ i ≤ n)个人能够胜任的工作

            //处理
            ArrayList<ArrayList<String>> list=new ArrayList<>();
            ArrayList<String> list0=new ArrayList<>();
            ArrayList<String> list1=new ArrayList<>();
            ArrayList<String> list2=new ArrayList<>();
            ArrayList<String> list3=new ArrayList<>();
            ArrayList<String> list4=new ArrayList<>();
            ArrayList<String> list5=new ArrayList<>();

            list.add(list0);
            list.add(list1);
            list.add(list2);
            list.add(list3);
            list.add(list4);
            list.add(list5);

            for(int i=0;i<n;i++){
                for(int j=0;j<abilities[i].length();j++){
                    if(abilities[i].charAt(j)=='0')
                        list0.add(String.valueOf(i));
                    else if(abilities[i].charAt(j)=='1')
                        list1.add(String.valueOf(i));
                    else if(abilities[i].charAt(j)=='2')
                        list2.add(String.valueOf(i));
                    else if(abilities[i].charAt(j)=='3')
                        list3.add(String.valueOf(i));
                    else if(abilities[i].charAt(j)=='4')
                        list4.add(String.valueOf(i));
                    else if(abilities[i].charAt(j)=='5')
                        list5.add(String.valueOf(i));
                }
            }
            int res=1;
            while (list.get(0).size()>1 || list.get(1).size()>1 ||
                    list.get(2).size()>1 || list.get(3).size()>1 ||
                    list.get(4).size()>1 || list.get(5).size()>1){
                //找出包含元素最少的list
                int size0=list.get(0).size();
                int size1=list.get(1).size();
                int size2=list.get(2).size();
                int size3=list.get(3).size();
                int size4=list.get(4).size();
                int size5=list.get(5).size();
                String workNum;
                if(size0>0 && (size0<=size1 || size1==0) && (size0<=size2 || size2==0)
                        && (size0<=size3 || size3==3) && (size0<=size4|| size4==0)
                        && (size0<=size4 || size4==0) && (size0<=size5 || size5==0)){
                    workNum=list0.get(0);
                    res*=size0;
                }else if(size1>0 && (size1<=size0 ||size0==0) && (size1<=size2 || size2==0)
                        && (size1<=size3 || size3==0) && (size1<=size4 || size4==0)
                        && (size1<=size5 || size5==0)){
                    workNum=list1.get(0);
                    res*=size1;
                }else if(size2>0 && (size2<=size0 || size0==0) && (size2<=size1 || size1==0)
                        && (size2<=size3 || size3==0) && (size2<=size4 || size4==0)
                        && (size2<=size5 || size5==0)){
                    workNum=list2.get(0);
                    res*=size2;
                }else if(size3>0 && (size3<=size0 || size0==0) && (size3<=size1 || size1==0)
                        && (size3<=size2 || size2==0) || (size3<=size4 || size4==0)
                        && (size3<=size5 || size5==0)){
                    workNum=list3.get(0);
                    res*=size3;
                }else if(size4>0 && (size4<=size0 || size0==0) && (size4<=size1 || size1==0)
                        && (size4<=size2 || size2==0) && (size4<=size3 || size3==0)
                        && (size4<=size5 || size5==0)){
                    workNum=list4.get(0);
                    res*=size4;
                }else{
                    workNum=list5.get(0);
                    res*=size5;
                }
                delete(list,workNum);
            }
            System.out.println(res);
        }
    }
    private static void delete(ArrayList<ArrayList<String>> list, String workNum){
        for(int i=0;i<6;i++){
            if(list.get(i).contains(workNum)){
                list.get(i).remove(list.get(i).indexOf(workNum));
            }
        }
    }
}
