        package designmodel.chapter28;

        /**
         * @Author: cxh
         * @CreateTime: 18/3/15 22:11
         * @ProjectName: JavaBaseTest
         */
        public class ConcreteElementB implements Element {
            @Override
            public void accept(Visitor v) {
                v.visitElementB(this);
            }
        }
