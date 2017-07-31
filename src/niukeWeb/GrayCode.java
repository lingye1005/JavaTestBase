package niukeWeb;

import java.util.ArrayList;

/**
 * Created by caoxiaohong on 17/7/26.
 * 格雷码:编码方式:每个相邻的数值之间:仅1位二进制位不同.这是为了避免数值从小到大转换时,转换太多位容易出错这类问题而设计的.
 *  十进制　格雷码  二进制码
     0  　　 000    000
     1  　　 001    001
     2   　　011    010
     3   　　010    011
     4   　　110    100
     5   　　111    101
     6   　　101    110
     7   　　100    111
 * 递归求解
 */

public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
         ArrayList<Integer> ret = new ArrayList<Integer>();
         if (n == 0) {
                ret.add(0);
                 return ret;
         }
         ret = grayCode(n - 1);

         for (int i = ret.size() - 1; i >= 0; i--) {
                int num = ret.get(i);
                 num += 1 << (n - 1);
                 ret.add(num);
         }
         return ret;
    }
}
