package schooloffer16;

/**
 * Created by caoxiaohong on 17/9/14.
 * 小东和三个朋友一起在楼上抛小球，他们站在楼房的不同层，假设小东站的楼层距离地面N米，球从他手里自由落下，每次落地后反跳回上次下落高度的一半，并以此类推知道全部落到地面不跳，求4个小球一共经过了多少米？(数字都为整数)
 给定四个整数A,B,C,D，请返回所求结果。
 */
public class Balls {
    public int calcDistance(int A, int B, int C, int D) {
        // write code here
        double suma=A,sumb=B,sumc=C,sumd=D;
        float a=Float.valueOf(A);
        float b=Float.valueOf(B);
        float c=Float.valueOf(C);
        float d=Float.valueOf(D);

        while(a>0.0000000001 || b>0.0000000001 || c>0.0000000001 || d>0.0000000001){
            if(a!=0){
                suma+=a;
                a/=2;
            }
            if(b!=0){
                sumb+=b;
                b/=2;
            }
            if(c!=0){
                sumc+=c;
                c/=2;
            }
            if(d!=0){
                sumd+=d;
                d/=2;
            }
        }
        return (int)Math.ceil(suma+sumb+sumc+sumd);
    }

    public static void main(String[] args) {
        System.out.println(new Balls().calcDistance(100,90,80,70));
    }
}
