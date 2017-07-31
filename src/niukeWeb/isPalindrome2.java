package niukeWeb;

/**
 * Created by caoxiaohong on 17/7/15.
 * 判定一个整数是否为回文序列
 * java的integer是32位的。范围在-2147483648 到2147483647
 */
public class isPalindrome2 {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        if(x>=0 && x<=9)
            return true;
        int temp=x;
        //x有10位
        if(x>999999999 && x<=2147483647){
            if(temp%10!=x/1000000000)  //9个0
                return false;
            temp=temp/10;
            x=x%1000000000;
            if(temp%10!=x/100000000)  //8
                return false;
            temp=temp/10;
            x=x%100000000;
            if(temp%10!=x/10000000)   //7
                return false;
            temp=temp/10;
            x=x%10000000;
            if(temp%10!=x/1000000)   //6
                return false;
            temp=temp/10;
            x=x%1000000;
            if(temp%10!=x/100000) //5
                return false;
            return true;
        }
        //x有9位
        else if(x>99999999 && x<=999999999){
            if(temp%10!=x/100000000)  //8
                return false;
            temp=temp/10;
            x=x%100000000;
            if(temp%10!=x/10000000)   //7
                return false;
            temp=temp/10;
            x=x%10000000;
            if(temp%10!=x/1000000)   //6
                return false;
            temp=temp/10;
            x=x%1000000;
            if(temp%10!=x/100000) //5
                return false;
            return true;
        }
        //x有8位
        else if(x>9999999 && x<=9999999){
            if(temp%10!=x/10000000)  //7
                return false;
            temp=temp/10;
            x=x%10000000;
            if(temp%10!=x/1000000)   //6
                return false;
            temp=temp/10;
            x=x%1000000;
            if(temp%10!=x/100000)   //5
                return false;
            temp=temp/10;
            x=x%100000;
            if(temp%10!=x/10000) //4
                return false;
            return true;
        }
        //x有7位
        else if(x>999999 && x<=9999999){
            if(temp%10!=x/1000000)   //6
                return false;
            temp=temp/10;
            x=x%1000000;
            if(temp%10!=x/100000)   //5
                return false;
            temp=temp/10;
            x=x%100000;
            if(temp%10!=x/10000) //4
                return false;
            return true;
        }
        //x有6位
        else if(x>99999 && x<=999999){
            if(temp%10!=x/100000)   //5
                return false;
            temp=temp/10;
            x=x%100000;
            if(temp%10!=x/10000)   //4
                return false;
            temp=temp/10;
            x=x%10000;
            if(temp%10!=x/1000) //3
                return false;
            return true;
        }
        //x有5位
        else if(x>9999 && x<=99999){
            if(temp%10!=x/10000)   //4
                return false;
            temp=temp/10;
            x=x%10000;
            if(temp%10!=x/1000)   //3
                return false;
            return true;
        }
        //x有4位
        else if(x>999 && x<=9999){
            if(temp%10!=x/1000)   //3
                return false;
            temp=temp/10;
            x=x%1000;
            if(temp%10!=x/100)   //2
                return false;
            return true;
        }
        //x有3位
        else if(x>99 && x<=999){
            if(temp%10!=x/100)   //2
                return false;
            return true;
        }
        //x有2位
        else{
            if(temp%10!=x/10)   //1
                return false;
            return true;
        }
    }

    public static void main(String[] args) {
        isPalindrome2 test=new isPalindrome2();
        System.out.println(test.isPalindrome(101010101));
    }
}
