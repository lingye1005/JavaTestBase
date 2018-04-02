package jianzhioffer;

/**
 * Created by caoxiaohong on 17/9/6.
 */
public class SerializeTree {
    StringBuilder serialSb=new StringBuilder();

    String Serialize(TreeNode root) {
        serialize(root);
        if(serialSb.charAt(serialSb.length()-1)==',')
            serialSb.delete(serialSb.length()-1,serialSb.length());
        return serialSb.toString();
    }
    TreeNode Deserialize(String str) {
        String[] list=str.split(",");
        return deSerialize(list);
    }


    //序列化
    void serialize(TreeNode root){
        if(root==null){
            serialSb.append("$,");
        }else{
            serialSb.append(root.val+",");
            serialize(root.left);
            serialize(root.right);
        }
    }
    //反序列化
    int index=-1;
    TreeNode deSerialize(String[] str){
        if(index>=str.length)
            return null;
        index++;
        TreeNode root=null;
        if(!str[index].equals("$")){
            root=new TreeNode(Integer.valueOf(str[index]));
            root.left=deSerialize(str);
            root.right=deSerialize(str);
        }
        return root;
    }

    public static void main(String[] args) {
        SerializeTree t=new SerializeTree();

        TreeNode t1=new TreeNode(8);
        TreeNode t2=new TreeNode(6);
        TreeNode t3=new TreeNode(10);
        TreeNode t4=new TreeNode(5);
        TreeNode t5=new TreeNode(7);
        TreeNode t6=new TreeNode(9);
        TreeNode t7=new TreeNode(11);

        t1.left=t2;t1.right=t3;
        t2.left=t4;t2.right=t5;
        t3.left=t6;t3.right=t7;

        System.out.println(t.Serialize(t1));
        TreeNode s=t.Deserialize("8,6,5,$,$,7,$,$,10,9,$,$,11,$,$");
    }
}
