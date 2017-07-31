package niukeWeb;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by caoxiaohong on 17/5/22.
 * 生成杨辉三角.给定行数numRows,则返回numRows行的数据
 *
 */
public class generate {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        HashMap<Integer,ArrayList<Integer>> temp=new HashMap<Integer, ArrayList<Integer>>();//存储杨辉三角的数字
        ArrayList<Integer> rowList=new ArrayList<Integer>();//存储当前行数据
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();//存放返回结果

        if(numRows<0)
            return result;
        rowList.add(1);  //存储第一个元素;
        if(numRows==0){
            result.add(rowList);
            return result;
        }

        temp.put(0,rowList);

        //求第k行数据
        for(int i=1;i<numRows;i++){
            ArrayList<Integer> irow=new ArrayList<Integer>();
            for(int j=0;j<=i;j++){  //第i行有i个数据
                if(j==0 || j==i){  //每行第1个元素和最后一个元素均为1
                    irow.add(1);
                    temp.put(i,irow);
                    continue;
                }
                int num1=temp.get(i-1).get(j-1);
                int num2=temp.get(i-1).get(j);
                irow.add(num1+num2);
                temp.put(i,irow);
            }
        }
        for(int i=0;i<temp.size();i++){
            result.add(temp.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        generate test=new generate();
        ArrayList<ArrayList<Integer>> arr=test.generate(5);
        for(int i=0;i<arr.size();i++){
            for(int j=0;j<arr.get(i).size();j++){
                System.out.print(arr.get(i).get(j)+",");
            }
            System.out.println();
        }
    }
}
