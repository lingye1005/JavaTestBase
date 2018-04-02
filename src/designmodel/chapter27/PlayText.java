    package designmodel.chapter27;

    /**
     * @Author: cxh
     * @CreateTime: 18/3/13 19:41
     * @ProjectName: JavaBaseTest
     */
    public class PlayText {
        String playText;
        public PlayText(String text){
            this.playText=text;
        }
        public String getPlayText() {
            return playText;
        }

        @Override
        public String toString() {
            return playText;
        }
    }
