    package designmodel.chapter27;

    /**
     * @Author: cxh
     * @CreateTime: 18/3/13 19:59
     * @ProjectName: JavaBaseTest
     */
    //音符,根据key演奏音乐
    public class Note implements Expression {
        @Override
        public void execute(String key, int value) {
            String note="";
            switch (key){
                case "C":
                    note="1";break;
                case "D":
                    note="2";break;
                case "E":
                    note="3";break;
                case "F":
                    note="4";break;
                case "G":
                    note="5";break;
                case "A":
                    note="6";break;
                case "B":
                    note="7";break;
            }
            //打印音符
            System.out.print(note+" ");
        }
    }
