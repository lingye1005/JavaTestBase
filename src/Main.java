import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);//笔试
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            scanner.nextLine();//换行
            ArrayList<ArrayList<Integer>> list=new ArrayList<>();
            ArrayList<Integer> list0=new ArrayList<>();
            ArrayList<Integer> list1=new ArrayList<>();
            ArrayList<Integer> list2=new ArrayList<>();
            ArrayList<Integer> list3=new ArrayList<>();
            ArrayList<Integer> list4=new ArrayList<>();
            ArrayList<Integer> list5=new ArrayList<>();

            for(int i=0;i<n;i++){
                String str=scanner.nextLine();
                if(str.contains("0"))
                    list0.add(0);
                if(str.contains("1"))
                    list1.add(1);
                if(str.contains("2"))
                    list2.add(2);
                if(str.contains("3"))
                   list3.add(3);
                if(str.contains("4"))
                    list4.add(4);
                if(str.contains("5"))
                    list5.add(5);
            }
            list.add(list0);
            list.add(list1);
            list.add(list2);
            list.add(list3);
            list.add(list4);
            list.add(list5);
            int result=1;
            while (list0.size()>1 || list1.size()>1 || list2.size()>1 || list3.size()>1 || list4.size()>1 || list5.size()>1){
                ArrayList<Integer> res=null;
                if(list0.size()>=list1.size() && list0.size()>=list2.size() && list0.size()>=list3.size() && list0.size()>=list4.size()
                        && list0.size()>=list5.size())
                    res=list0;
                else if(list1.size()>=list0.size() && list1.size()>=list2.size() && list1.size()>=list3.size() && list1.size()>=list4.size()
                        && list1.size()>=list5.size())
                    res=list1;
                else if(list2.size()>=list0.size() && list2.size()>=list1.size() && list2.size()>=list3.size() && list2.size()>=list4.size()
                        && list2.size()>=list5.size())
                    res=list2;
                else if(list3.size()>=list0.size() && list3.size()>=list2.size() && list3.size()>=list1.size() && list3.size()>=list4.size()
                        && list3.size()>=list5.size())
                    res=list3;
                else if(list4.size()>=list0.size() && list4.size()>=list2.size() && list4.size()>=list3.size() && list4.size()>=list1.size()
                        && list4.size()>=list5.size())
                    res=list4;
                else if(list5.size()>=list0.size() && list5.size()>=list2.size() && list5.size()>=list3.size() && list5.size()>=list4.size()
                        && list5.size()>=list1.size())
                    res=list5;
                result*=res.size();
                res.remove(0);
            }
            System.out.println(result);
        }
    }
}