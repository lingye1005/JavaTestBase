package jianzhioffer2;

import java.util.Arrays;

/**
 * @Author: cxh
 * @CreateTime: 18/3/24 20:24
 * @ProjectName: JavaBaseTest
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0)
            return false;
        int[] inOrder=new int[sequence.length];
        System.arraycopy(sequence,0,inOrder,0,sequence.length);
        Arrays.sort(inOrder);
        return is(sequence,sequence.length-1,inOrder,0,inOrder.length-1);
    }
    private  boolean is(int[] postOrder,int pTo,int[] inOrder,int iFrom,int iTo){
        if(pTo<0 || pTo>=postOrder.length || iFrom<0 || iFrom>=inOrder.length ||
                iTo<0 || iTo>=inOrder.length || iFrom>iTo)
            return  true;
        int root=postOrder[pTo];
        //查找根节点在中序的位置
        int idx=-1;
        for(int i=iFrom;i<=iTo && idx==-1;i++){
            if(inOrder[i]==root)
                idx=i;
        }
        //没找到根节点
        if(idx==-1)
            return false;
        return is(postOrder,pTo-iTo+idx-1,inOrder,iFrom,idx-1) &&
                is(postOrder,pTo-1,inOrder,idx+1,iTo);
    }
}
