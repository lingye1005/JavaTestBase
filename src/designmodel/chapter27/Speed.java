    package designmodel.chapter27;

    /**
     * @Author: cxh
     * @CreateTime: 18/3/13 20:11
     * @ProjectName: JavaBaseTest
     */
    //音速:根据value值确定
    public class Speed implements Expression {
        //key始终为I
        @Override
        public void execute(String key, int value) {
            String speed="";
            if(value<500)
                speed="低速";
            else if(value<1000)
                speed="中速";
            else
                speed="高速";
            //打印音速
            System.err.print(speed+" ");
        }
    }
