        package designmodel.chapter28;

        /**
         * @Author: cxh
         * @CreateTime: 18/3/15 22:12
         * @ProjectName: JavaBaseTest
         */
        public class ConcreteElementC implements Element {

            @Override
            public void accept(Visitor v) {
                v.visitElementC(this);
            }
        }
