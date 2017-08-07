package niukeWeb;

import java.util.Stack;

/**
 * Created by caoxiaohong on 17/8/7.
 * 题意:将一个unix类型的路径转化为:其最终要表达的路径的最简式
 * 提示:用栈
 * 思路:将path按照/转换为数组.针对数组元素的操作:遇到..,出栈一个元素;遇到""或者.,无操作;遇到一个单词,入栈.
 * 最后:如果栈中没有元素:返回/
 *     如果有元素:每次出栈一个元素,插入到路径的第0个位置(头插法);
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        StringBuilder sbPath=new StringBuilder();//存放返回结果
        Stack<String> stack=new Stack<String>();
        String[] strPath=path.split("/");
        //处理strPath
        for(String str:strPath){
            if(str.equals("..")){
                if(!stack.isEmpty())
                     stack.pop();
            }else if(str.equals(".") || str.equals("")){
                continue;
            }else{
               stack.push(str);
            }
        }
        //栈判空,生成路径
        if(stack.isEmpty()){
            sbPath.append("/");
        }else{

            while(!stack.isEmpty()){
                sbPath.insert(0,stack.pop());
                sbPath.insert(0,"/");
            }
        }
        return sbPath.toString();
    }

    public static void main(String[] args) {
        SimplifyPath t=new SimplifyPath();
        /**
         * path ="/home/", =>"/home"
           path ="/a/./b/../../c/", =>"/c"
           path="/../"=>/
           path="/home//fool"=>/home/fool
         */
        System.out.println(t.simplifyPath("/home/"));
        System.out.println(t.simplifyPath("/a/./b/../../c/"));
        System.out.println(t.simplifyPath("/../"));
        System.out.println(t.simplifyPath("/home//fool"));
    }
}
