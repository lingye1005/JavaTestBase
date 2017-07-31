package niukeWeb;

/**
 * Created by caoxiaohong on 17/5/10.
 * 牛客网第17题
 * 环形路上有N个加油站,第i个加油站存储油的数量为gas[i].
 * 假设你的车的油箱足够大,且从加油站i到加油站i+1所消耗的油量为cost[i].
 * 开始时,你车的油箱里没有油,且起始点为任意的一个加油站.
 * 如果你可以开车环游一圈,则返回开始加油站的index,否则返回-1.
 * 假设:最多只存在一个点满足条件
 */

public class canCompleteCircuit17 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remainGas=0;//油箱剩余油量,开始为0
        int stationNum=gas.length;
        int result=-1; //返回结果

        for(int i=0;i<stationNum;i++){
            int temp=0;
            for(int j=i;j<stationNum+i;j++){
                //j<stationNum
                if(j<stationNum) {
                    remainGas += gas[j];//更新油量
                    if (remainGas >= cost[j]) {//油量>=从j点到j+1点需要消耗的油量
                        remainGas -= cost[j];
                    } else {//油量不足,推出本重循环,从下一个节点开始查找起始点.
                        remainGas = 0;//油量置为空
                        break;
                    }
                    if (j == stationNum + i - 1) {//遍历完一圈
                        result = i;
                        break;
                    }
                }else{
                    remainGas += gas[temp];//更新油量
                    if (remainGas >= cost[temp]) {//油量>=从j点到j+1点需要消耗的油量
                        remainGas -= cost[temp];
                        temp++;
                    } else {//油量不足,推出本重循环,从下一个节点开始查找起始点.
                        remainGas = 0;//油量置为空
                        break;
                    }
                    if (j == stationNum + i - 1) {//遍历完一圈
                        result = i;
                        break;
                    }
                }
            }
            if(result==i){//找到合适起点
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] gas1=new int[]{4,3,4,3};
        int[] cost1=new int[]{3,4,3,4};
        int[] gas2=new int[]{67,68,69,70,71,72,73,74,75,76,77,78,79, 80,81,82,83,84,85,86,87,88,89,90,91,
                             92,93,94,95,96,97,98,99,100,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,
                             20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,
                             45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66};
        int[] cost2=new int[]{27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,
                              52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,
                              77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,1,
                              2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
        int[] gas3=new int[]{2,4};
        int[] cost3=new int[]{3,4};
        canCompleteCircuit17 test=new canCompleteCircuit17();
        System.out.println(test.canCompleteCircuit(gas2,cost2));
    }
}
