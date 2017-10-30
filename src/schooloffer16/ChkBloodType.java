package schooloffer16;

import java.util.HashMap;

/**
 * Created by caoxiaohong on 17/9/19.
 * 请实现一个程序，输入父母血型，判断孩子可能的血型。
 * 给定两个字符串father和mother，代表父母的血型,请返回一个字符串数组，代表孩子的可能血型(按照字典序排列)。
 */
public class ChkBloodType {
    public String[] chkBlood(String father, String mother) {
        // write code here
        HashMap<String,String> hashMap=new HashMap<String, String>();
        hashMap.put("OO","O");
        hashMap.put("AO","A,O");
        hashMap.put("OA","A,O");
        hashMap.put("AA","A,O");
        hashMap.put("AB","A,AB,B,O");
        hashMap.put("BA","A,AB,B,O");
        hashMap.put("AAB","A,AB,B");
        hashMap.put("ABA","A,AB,B");
        hashMap.put("BO","B,O");
        hashMap.put("OB","B,O");
        hashMap.put("BB","B,O");
        hashMap.put("BAB","A,AB,B");
        hashMap.put("ABB","A,AB,B");
        hashMap.put("ABO","A,B");
        hashMap.put("OAB","A,B");
        hashMap.put("ABAB","A,AB,B");

        String str=father+mother;
        String[] result=hashMap.get(str).split(",");
        return  result;
    }
}
