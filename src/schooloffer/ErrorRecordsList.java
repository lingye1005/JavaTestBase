package schooloffer;

import java.util.*;

/**
 * Created by caoxiaohong on 17/10/14.
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号...
 * 注意:
 * 1.记录最多有8条错误记录.
 * 2.对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(故:文件所在的目录不同，文件名和行号相同也要合并)
 * 3.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，不要合并)
 * 4.输入的文件可能带路径，记录文件名称不能带路径.
 *
 * 输入规定:
 * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 */
public class ErrorRecordsList {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //String[] input=new String[8];
        HashMap<String,ArrayList<String>> records=new HashMap<String, ArrayList<String>>();//list中元素顺序:name,linNum,times,index
        int index=0;//出现次序
        for(;;){
            String tmp=scanner.nextLine();
            if(tmp==null || tmp.equals(""))
                break;
            String[] namePath=tmp.split(" ")[0].split("\\\\");
            String lineNum=tmp.split(" ")[1];
            String name=namePath[namePath.length-1];
            if(records.containsKey(name+lineNum)){ //相同错误记录
                int times=Integer.valueOf(records.get(name+lineNum).get(2))+1;
                records.get(name+lineNum).set(2,String.valueOf(times));
            }else{
                ArrayList<String> list=new ArrayList<String>();
                if(name.length()<=16)
                    list.add(name);
                else {
                    int len=name.length();
                    list.add(name.substring(len-16,len));
                }
                list.add(lineNum);
                list.add("1");
                list.add(index+++"");
                records.put(name+lineNum,list);
            }
        }
        /**排序:错误个数times降序,出现顺序index升序
         * 注意:Collections.sort()方法是对list进行排序的,所以需要把map转为list,再进行排序
        **/
        ArrayList<Map.Entry<String,ArrayList<String>>> entry=new ArrayList<Map.Entry<String,ArrayList<String>>>(records.entrySet());

        Collections.sort(entry, new Comparator<Map.Entry<String,ArrayList<String>>>() {
            @Override
            public int compare(Map.Entry<String,ArrayList<String>> list1,Map.Entry<String,ArrayList<String>> list2){
                int times1=Integer.valueOf(list1.getValue().get(2));
                int times2=Integer.valueOf(list2.getValue().get(2));
                int index1=Integer.valueOf(list1.getValue().get(3));
                int index2=Integer.valueOf(list2.getValue().get(3));
                if(times1==times2)
                    return index1-index2;
                else
                    return times2-times1;
            }
        });

        //输出
        Iterator<Map.Entry<String,ArrayList<String>>> iterator=entry.iterator();
        int count=8;
        while (iterator.hasNext() && count-->0){
            ArrayList<String> arr=iterator.next().getValue();
            System.out.println(arr.get(0)+" "+arr.get(1)+" "+arr.get(2));
        }
    }
}
