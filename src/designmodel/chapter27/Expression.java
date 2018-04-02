        package designmodel.chapter27;

        /**
         * @Author: cxh
         * @CreateTime: 18/3/13 19:44
         * @ProjectName: JavaBaseTest
         */
        public interface Expression {
            default void commonExpress(String key,int value){
               execute(key,value);
            }
            void execute(String key,int value);
        }
