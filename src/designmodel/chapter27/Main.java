    package designmodel.chapter27;

    /**
     * @Author: cxh
     * @CreateTime: 18/3/13 20:22
     * @ProjectName: JavaBaseTest
     */
    //测试类
    public class Main {

        public static void main(String[] args) {
            PlayText txt=new PlayText("T 500 O 2 H 1 I 1 A 3 E 1 G 1 I 4 O 3 C 1 O 2 H 8 G 1 C 3 E 1 D 3");
            String[] text=txt.toString().split(" ");
            Expression exe=null;
            for(int i=0;i<text.length;i+=2){
                String key=text[i];
                int value=Integer.valueOf(text[i+1]);
                if(key.equals("H"))
                    exe=new Scale();
                else if(key.equals("I"))
                    exe=new Speed();
                else
                    exe=new Note();
                //执行一对key-value解释行为
                exe.commonExpress(key,value);
            }
        }
    }
