package schooloffer17;

import java.util.Scanner;

/**
 * @Author: cxh
 * @CreateTime: 17/11/22 17:04
 * @ProjectName: JavaBaseTest
 * <Filename Extention></>
 * <文件扩展名></>
 */
public class FilenameExtention {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String[] strs=scanner.nextLine().trim().split("/");
            int to=strs[strs.length-1].length();
            int from=strs[strs.length-1].lastIndexOf(".");
            if(from==-1){
                System.out.println("null");
            }else{
                System.out.println(strs[strs.length-1].substring(from+1,to));
            }
        }
    }
}
