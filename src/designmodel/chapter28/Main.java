        package designmodel.chapter28;

        /**
         * @Author: cxh
         * @CreateTime: 18/3/15 22:18
         * @ProjectName: JavaBaseTest
         */
        public class Main {
            public static void main(String[] args) {
                ObjectStructure os=new ObjectStructure();

                os.add(new ConcreteElmentA());
                os.add(new ConcreteElementB());
                os.add(new ConcreteElementC());

                Visitor a=new ConcreteVisitor1();
                Visitor b=new ConcreteVisitor2();
                Visitor c=new ConcreteVisitor3();

                //访问开始
                os.deteach(a);
                os.deteach(b);
                os.deteach(c);
            }
        }
