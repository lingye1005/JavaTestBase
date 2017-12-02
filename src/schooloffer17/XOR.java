package schooloffer17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/20 15:54
 * @ProjectName: JavaBaseTest
 * <异或></>
 * 关键算法:字典树TrieTree的应用
 */
public class XOR {
    private static class TrieTree{
        TrieTree[] next=new TrieTree[2];//next[0]表示左节点, next[1]表示右节点.
        short count=1;//表示有多少个数的在形成01字符串表达式的过程中,经过了这个节点
    }
    public static void main(String[] args) {
        int n,m;
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            n=scanner.nextInt();
            m=scanner.nextInt();
            int[] number=new int[n];
            for(int i=0;i<n;i++)
                number[i]=scanner.nextInt();
            //建树
            TrieTree root=builderTree(number);
            int res=0;//记录结果值
            for(int i=0;i<n;i++){
                //查找TrieTree树,并进行比较
                res+=searchTrieTree(root,number[i],m,31);
            }
            System.out.println(res/2);
        }
    }

    /**
     * 建树
     * 这是一棵二叉树,高度最高为33(最深处:33个节点,边32条,因为字典树定义就是:节点不存储数据,边才表示0或者1)
     * @param a
     */
    private static TrieTree builderTree(int[] a){
        TrieTree root=new TrieTree();
        for(int i=0;i<a.length;i++){
            TrieTree curr=root;
            for(int j=31;j>=0;j--){
                int digit=(a[i]>>j) & 1;
                if(curr.next[digit]==null){
                    curr.next[digit]=new TrieTree();//count=1是初始值,故这里就不用再new之后为count赋值为1了
                }else{
                    curr.next[digit].count++;
                }
                curr=curr.next[digit];
            }
        }
        return root;
    }

    /**
     * 搜索查找字典树
     * @param root 字典树根
     * @param a 要比较的元素
     * @param m 输入的比较值
     * @param move 需要右移的位数
     * @return
     */
    private static int searchTrieTree(TrieTree root,int a,int m,int move){
        if(root==null)
            return 0;

        TrieTree curr=root;
        for(int i=move;i>=0;i--){
            int aDigit=(a>>i) & 1;
            int mDigit=(m>>i) & 1;
            if(aDigit==0 && mDigit==0){
                int x=searchTrieTree(curr.next[0],a,m,i-1);
                int y=curr.next[1]==null?0:curr.next[1].count;
                return (short)(x+y);
            }else if(aDigit==0 && mDigit==1){
                if(curr.next[1]==null)
                    return 0;
                curr=curr.next[1];
            }else if(aDigit==1 && mDigit==0){
                int x=curr.next[0]==null?0:curr.next[0].count;
                int y=searchTrieTree(curr.next[1],a,m,i-1);
                return (short)(x+y);
            }else{
                if(curr.next[0]==null)
                    return 0;
                curr=curr.next[0];
            }
        }
        return 0;
    }
}
