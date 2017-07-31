package innerclasses;

/**
 * Created by caoxiaohong on 17/1/15.
 * p196 practice10
 */


public class PubInterImpl {
    //内部私有类,实现类public接口
    private class pub implements PubInter{
        private String name;
        pub(String str){
            name=str;
        }
        public String getName(){
            return name;
        }
    }
    public PubInter getPub(){
        return new pub("this is in getPub()");
    }
    pub pubInter=new pub("ssss");
}
