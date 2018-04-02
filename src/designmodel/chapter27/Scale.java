    package designmodel.chapter27;

    /**
     * @Author: cxh
     * @CreateTime: 18/3/13 20:06
     * @ProjectName: JavaBaseTest
     */
    //音阶:根据value打印
    public class Scale implements Expression{
        //key始终为H
        @Override
        public void execute(String key, int value) {
            String scale="";
            switch (value){
                case 1:
                    scale="低音";break;
                case 2:
                    scale="中音";break;
                case 3:
                    scale="高音";break;
            }
            //打印音阶
            System.out.print(scale+" ");
        }
    }
