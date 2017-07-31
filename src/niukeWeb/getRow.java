package niukeWeb;

import java.util.*;

/**
 * Created by caoxiaohong on 17/5/21.
 * 杨辉三角:给出k,返回第k行的数据是多少,以数组形式.行数从0开始.
 * 杨辉三角:上下行关系:c(n+1,i)=c(n,i-1)+c(n,i)
 * 上述表达式解释:第(n+1)行的第i个数值=第n行的第(i-1)个数字  加上   第n行的第(i)个数字
 */
public class getRow {

    private ArrayList<Integer> getPascalTriangle(int k){
        HashMap<Integer,ArrayList<Integer>>  temp=new HashMap<Integer, ArrayList<Integer>>();//存储杨辉三角的数字
        ArrayList<Integer> rowList=new ArrayList<Integer>();

        if(k<0)
            return rowList;
        rowList.add(1);  //存储第一个元素;
        if(k==0)
            return rowList;
        temp.put(0,rowList);

        //求第k行数据
        for(int i=1;i<=k;i++){
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
        //因为之前rowList之前存过一个数据1,所以先删除这个数据,然后再重新存储第k行的数据.否则在最前面会多存储一个1
        rowList=new ArrayList<Integer>();
        for(int i:temp.get(k)){
            rowList.add(i);
        }

        return rowList;
    }

    public ArrayList<Integer> getRow(int rowIndex) {
        return getPascalTriangle(rowIndex);
    }

    public static void main(String[] args) {
        getRow test=new getRow();
        ArrayList<Integer> bbb=test.getRow(3);
        for(int i:bbb){
            System.out.println(i);
        }
    }
}
