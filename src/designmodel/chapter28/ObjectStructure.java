        package designmodel.chapter28;

        import java.util.ArrayList;
        import java.util.List;

        /**
         * @Author: cxh
         * @CreateTime: 18/3/15 22:22
         * @ProjectName: JavaBaseTest
         */
        //访问者模式关键设计处
        public class ObjectStructure{
            private  List<Element> elements=new ArrayList<>();
            //crud
            public  void add(Element e){
                elements.add(e);
            }
            public  void delete(Element e){
                elements.remove(e);
            }
            //访问每一个元素
            public  void deteach(Visitor vi){
                elements.forEach(e->e.accept(vi));
            }
        }
