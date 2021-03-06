        package designmodel.chapter28;

        /**
         * @Author: cxh
         * @CreateTime: 18/3/15 22:16
         * @ProjectName: JavaBaseTest
         */
        public class ConcreteVisitor2 implements Visitor{
            @Override
            public void visitElementA(Element a) {
                System.out.println("ConcreteVisitor2 访问 ElementA");
            }

            @Override
            public void visitElementB(Element b) {
                System.out.println("ConcreteVisitor2 访问 ElementB");
            }

            @Override
            public void visitElementC(Element c) {
                System.out.println("ConcreteVisitor2 访问 ElementC");
            }
        }
