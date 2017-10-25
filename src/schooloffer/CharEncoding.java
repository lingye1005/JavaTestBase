package schooloffer;

import java.util.*;

/**
 * Created by caoxiaohong on 17/10/16.
 * 请设计一个算法，给一个字符串进行二进制编码，使得编码后字符串的长度最短。
 * 算法实质:
 * 1.各个字符个数有一个优先级队列,反复对这个队列进行筛选,每次筛选后:添加新生成节点到队列,删除之前两个最小的节点.
 * 最后,队列中会仅仅剩下一个节点,而这个节点就是:根节点.
 *
 * 2.哈夫曼树建成后,对数进行遍历,求所有节点的路径和.
 */
class HuffmanTree{
    static class  Node<T>{
        //变量
        private T data;
        private int weight;
        private Node<T> leftChild;
        private Node<T> rightChild;
        //构造器
        public Node(T data,int weight){
            this.data=data;
            this.weight=weight;
        }
        //设定:变量值
        public T getData() {
            return data;
        }

        public int getWeight() {
            return weight;
        }

        public Node<T> getLeftChild() {
            return leftChild;
        }

        public Node<T> getRightChild() {
            return rightChild;
        }
        public void setData(T data) {
            this.data = data;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public void setLeftChild(Node<T> leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(Node<T> rightChild) {
            this.rightChild = rightChild;
        }
    }
}
//主算法
public class CharEncoding {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            char[] str=scanner.nextLine().toCharArray();
            Arrays.sort(str);

            char pre=str[0];
            int len=str.length;
            int count=1;
            ArrayList<HuffmanTree.Node> list=new ArrayList<HuffmanTree.Node>();
            for(int i=1;i<len;i++){
                if(str[i]!=pre){
                    HuffmanTree.Node<Character> node=new HuffmanTree.Node<Character>(pre,count);
                    list.add(node);
                    pre=str[i];
                    count=1;
                }else{
                    count++;
                }
            }
            list.add(new HuffmanTree.Node(pre,count));//添加最后一个节点count值.

            //排序
            sort(list);
            //建树
            while (list.size()>1){
                buildTree(list);
            }
            HuffmanTree.Node root=list.get(0);//获得根节点;

            //求路径和
            int sum=0;//输出结果
            Set<Character> chars=new HashSet<Character>();
            for(char i:str)
                chars.add(i);
            //层序遍历树,遇到对应的data则加上当前层次数一次
            List<HuffmanTree.Node> queue=new LinkedList<HuffmanTree.Node>();
            int front=-1,rear=-1;
            int last=0,level=0;
            queue.add(root);
            rear++;
            while (!queue.isEmpty()){
                HuffmanTree.Node node=queue.remove(0);
                front++;
                if(chars.contains(node.getData()))
                    sum+=level*node.getWeight();

                if(node.getLeftChild()!=null) {
                    queue.add(node.getLeftChild());
                    rear++;
                }
                if(node.getRightChild()!=null) {
                    queue.add(node.getRightChild());
                    rear++;
                }
                if(front==last){
                    last=rear;
                    level++;
                }

            }
            System.out.println(sum);
        }
    }

    /**
     * 建树
     * @param list
     */
    private static void buildTree(ArrayList<HuffmanTree.Node> list){
        HuffmanTree.Node left=list.get(0);
        HuffmanTree.Node right=list.get(1);
        HuffmanTree.Node parent=new HuffmanTree.Node(null,left.getWeight()+right.getWeight());
        parent.setLeftChild(left);
        parent.setRightChild(right);

        list.add(parent); //添加新节点
        list.remove(left);//移除旧节点
        list.remove(right);//移除旧节点
        sort(list);//排序
    }

    /**
     * 排序
     */
    private static void sort(ArrayList<HuffmanTree.Node> list){
        Collections.sort(list, new Comparator<HuffmanTree.Node>() {
            @Override
            public int compare(HuffmanTree.Node o1, HuffmanTree.Node o2) {
                return o1.getWeight()-o2.getWeight();
            }
        });
    }
}
