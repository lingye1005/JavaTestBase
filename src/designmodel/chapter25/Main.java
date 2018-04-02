        package designmodel.chapter25;

        /**
         * @Author: cxh
         * @CreateTime: 18/2/20 14:40
         * @ProjectName: JavaBaseTest
         */
        public class Main {
            public static void main(String[] args) {
                ConcreteColleague1 Korea=new ConcreteColleague1();//朝鲜
                ConcreteColleague2 USA=new ConcreteColleague2();//美国
                ConcreteMediate mediate=new ConcreteMediate();//联合国安理会
                mediate.setConcreteColleague1(Korea);
                mediate.setConcreteColleague2(USA);
                Korea.setMediate(mediate);
                USA.setMediate(mediate);

                Korea.send("请求联合国安理会支持朝鲜半岛的统一,杜绝美国的干涉");
                System.out.println("--------------------------------我是分隔线----------------------------");
                USA.send("请求联合国安理会驳回朝鲜期望统一的无理要求");
            }
        }
