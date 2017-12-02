package schooloffer17;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/12/2 10:01
 * @ProjectName: JavaBaseTest
 * <电话号码分身></>
 */
public class PhoneNumDevide {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        n=Integer.valueOf(scanner.nextLine().trim());//n个测试用例
        int[] record=new int[10];
        for(int i=0;i<n;i++){
            String str=scanner.nextLine().trim().toLowerCase();
            Arrays.fill(record,0);//记录各个数字出现次数
            StringBuilder sb=new StringBuilder(str);
            //阶段1
            //two->4
            while (sb.indexOf("w")!=-1){
                sb.deleteCharAt(sb.indexOf("t"));
                sb.deleteCharAt(sb.indexOf("w"));
                sb.deleteCharAt(sb.indexOf("o"));
                record[4]++;
            }
            //six->8
            while (sb.indexOf("x")!=-1){
                sb.deleteCharAt(sb.indexOf("s"));
                sb.deleteCharAt(sb.indexOf("i"));
                sb.deleteCharAt(sb.indexOf("x"));
                record[8]++;
            }
            //eight->0
            while (sb.indexOf("g")!=-1){
                sb.deleteCharAt(sb.indexOf("e"));
                sb.deleteCharAt(sb.indexOf("i"));
                sb.deleteCharAt(sb.indexOf("g"));
                sb.deleteCharAt(sb.indexOf("h"));
                sb.deleteCharAt(sb.indexOf("t"));
                record[0]++;
            }
            //zero->2
            while (sb.indexOf("z")!=-1){
                sb.deleteCharAt(sb.indexOf("z"));
                sb.deleteCharAt(sb.indexOf("e"));
                sb.deleteCharAt(sb.indexOf("r"));
                sb.deleteCharAt(sb.indexOf("o"));
                record[2]++;
            }
            //阶段2
            //three->5
            while (sb.indexOf("h")!=-1){
                sb.deleteCharAt(sb.indexOf("t"));
                sb.deleteCharAt(sb.indexOf("h"));
                sb.deleteCharAt(sb.indexOf("r"));
                sb.deleteCharAt(sb.indexOf("e"));
                sb.deleteCharAt(sb.indexOf("e"));
                record[5]++;
            }
            //four->6
            while (sb.indexOf("u")!=-1){
                sb.deleteCharAt(sb.indexOf("f"));
                sb.deleteCharAt(sb.indexOf("o"));
                sb.deleteCharAt(sb.indexOf("u"));
                sb.deleteCharAt(sb.indexOf("r"));
                record[6]++;
            }
            //seven->9
            while (sb.indexOf("s")!=-1){
                sb.deleteCharAt(sb.indexOf("s"));
                sb.deleteCharAt(sb.indexOf("e"));
                sb.deleteCharAt(sb.indexOf("v"));
                sb.deleteCharAt(sb.indexOf("e"));
                sb.deleteCharAt(sb.indexOf("n"));
                record[9]++;
            }
            //阶段3
            //five->7
            while (sb.indexOf("f")!=-1){
                sb.deleteCharAt(sb.indexOf("f"));
                sb.deleteCharAt(sb.indexOf("i"));
                sb.deleteCharAt(sb.indexOf("v"));
                sb.deleteCharAt(sb.indexOf("e"));
                record[7]++;
            }
            //阶段4
            //nine->1
            while (sb.indexOf("i")!=-1){
                sb.deleteCharAt(sb.indexOf("n"));
                sb.deleteCharAt(sb.indexOf("i"));
                sb.deleteCharAt(sb.indexOf("n"));
                sb.deleteCharAt(sb.indexOf("e"));
                record[1]++;
            }
            //阶段5
            //one->3
            while (sb.indexOf("e")!=-1){
                sb.deleteCharAt(sb.indexOf("o"));
                sb.deleteCharAt(sb.indexOf("n"));
                sb.deleteCharAt(sb.indexOf("e"));
                record[3]++;
            }

            for(int j=0;j<10;j++){
                for(int k=0;k<record[j];k++){
                    sb.append(j);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
