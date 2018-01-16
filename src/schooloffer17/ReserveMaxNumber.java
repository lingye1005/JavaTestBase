package schooloffer17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: cxh
 * @CreateTime: 17/11/24 10:01
 * @ProjectName: JavaBaseTest
 * <保留最大的数字></>
 * 50%
 */
public class ReserveMaxNumber {
    public static void main(String[] args) {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try{
            while (!br.ready()){
                String number=br.readLine();
                int cnt=Integer.valueOf(br.readLine());
                //循环删除升序(x,y)中的x
                StringBuilder sb=new StringBuilder(number);
                while (cnt>0){
                    for(int i=0;i<sb.length();i++){
                        if(i+1<sb.length() && sb.charAt(i)<sb.charAt(i+1)){
                            sb.deleteCharAt(sb.toString().indexOf(sb.charAt(i)));
                            cnt--;
                            break;
                        }
                    }
                }
                System.out.println(sb.toString());
            }
        }catch (IOException e){
            System.out.println(0);
        }
    }
}
