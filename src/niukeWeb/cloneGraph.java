package niukeWeb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by caoxiaohong on 17/7/19.
 * 复制一个无向图
 * 节点之间lable是不同的.每个节点到邻居节点作为一个小组,组内分隔符是, 组间分隔符是#.
 * As an example, consider the serialized graph{0,1,2# 1,2# 2,2}.
 * 图有3个节点,分为3个小组.  0节点连接1和2;  1连接2;   2连接2;
 */
//无向图类定义
class UndirectedGraphNode {
         int label;
         ArrayList<UndirectedGraphNode> neighbors;
         UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}


public class cloneGraph {
    int _123=2;
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
             return null;
        UndirectedGraphNode front=new UndirectedGraphNode(node.label);// 复制节点
        HashMap<Integer,UndirectedGraphNode> map=new HashMap<Integer, UndirectedGraphNode>();//存放已经clone的节点
        map.put(front.label,front);

        LinkedList<UndirectedGraphNode> queue=new LinkedList<UndirectedGraphNode>();//存放未被访问的节点
        queue.add(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode orginalNode=queue.poll();
            UndirectedGraphNode cloneNode=map.get(orginalNode.label);
            for(UndirectedGraphNode i:orginalNode.neighbors){
                //如果i节点已经被克隆
                if(map.get(i.label)!=null){
                    cloneNode.neighbors.add(map.get(i.label));
                    continue;
                }
                //如果i节点没有被克隆,则入队
                queue.add(i);
                //克隆节点,放入map中
                UndirectedGraphNode newNode=new UndirectedGraphNode(i.label);
                map.put(i.label,newNode);

                //新节点加入邻居集中
                cloneNode.neighbors.add(newNode);
            }
        }
        return front;
    }

    public static void main(String[] args) {

    }
}
