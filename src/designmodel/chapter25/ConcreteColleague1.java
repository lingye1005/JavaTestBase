        package designmodel.chapter25;

        /**
         * @Author: cxh
         * @CreateTime: 18/2/20 13:55
         * @ProjectName: JavaBaseTest
         */
        public class ConcreteColleague1 extends Colleague{
            @Override
            public void send(String sendInfo) {
                System.out.println("提申请::朝鲜->联合国安理会:"+sendInfo);
                super.mediate.declare(sendInfo,this);
            }

            @Override
            public void receive(String getInfo) {
                System.out.println("收通知::联合国安理会->朝鲜:"+getInfo);
            }
        }
