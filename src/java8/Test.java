//package java8;
//
//import java.lang.reflect.InvocationTargetException;
//import java.util.ArrayList;
//import java.util.Map;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
///**
// * @Author: cxh
// * @CreateTime: 17/12/14 20:47
// * @ProjectName: JavaBaseTest
// * <测试类></>
// */
//public class Test{
//    public static void main(String[] args) {
//        ArrayList<Album> albums=new ArrayList<>();
//        //1
//        //artists
//        ArrayList<Artist> artists=new ArrayList<>();
//        ArrayList<String> members=new ArrayList<>();
//        members.add("123");members.add("111");
//        String name="cxh";
//        String original="beijing";
//        Artist artist=new Artist(name,members,original);
//        artists.add(artist);
//        //tracks
//        ArrayList<Track> tracks=new ArrayList<>();
//        String tname="trackName";
//        int len=10;
//        Track track=new Track(tname,len);
//        tracks.add(track);
//        //name
//        String aname="专辑名字";
//        albums.add(new Album(aname,tracks,artists));
//
//        //2
//        //tracks
//        ArrayList<Track> tracks1=new ArrayList<>();
//        String tname1="trackName";
//        int len1=10;
//        Track track1=new Track(tname1,len1);
//        tracks1.add(track1);
//        //artists
//        ArrayList<Artist> artists1=new ArrayList<>();
//        ArrayList<String> members1=new ArrayList<>();
//        members1.add("123");members1.add("111");
//        String name2="cxh";
//        String original2="beijing";
//        Artist artist1=new Artist(name2,members1,original2);
//        artists1.add(artist1);
//        //name
//        String name3="mingzi";
//        albums.add(new Album(name3,tracks1,artists1));
//
//        //3
//        //tracks
//        ArrayList<Track> tracks2=new ArrayList<>();
//        String tname2="ccccc";
//        int len2=11;
//        Track track2=new Track(tname2,len2);
//        tracks2.add(track2);
//        //artists
//        ArrayList<Artist> artists2=new ArrayList<>();
//        ArrayList<String> members2=new ArrayList<>();
//        members2.add("333");members2.add("fgh");
//        String name4="rty";
//        String original3="beijing";
//        Artist artist2=new Artist(name4,members2,original3);
//        artists2.add(artist2);
//        //name
//        String name5="liming";
//        albums.add(new Album(name5,tracks2,artists2));
//
//        //4
//        albums.add(new Album(name5,tracks,artists2));
//        albums.add(new Album(aname,tracks,artists));
//
//        //计算每个艺术家的专辑数目
//        Function<Album,Artist> function=album -> album.getMainMusician();
//        Map<Artist,Long> numberOfAlbulms=albums.stream().collect(Collectors.groupingBy(function,Collectors.counting()));
//        for(Map.Entry<Artist,Long> entry:numberOfAlbulms.entrySet()){
//            Artist key=entry.getKey();
//            Long counts=entry.getValue();
//            System.out.println("艺术家名字:"+key+"and 其专辑数目为:"+counts);
//        }
//        //格式化艺术家名称
//        StringBuilder sb=new StringBuilder();
//        sb.append("[");
//        albums.stream().map(album -> album.getMusicians()).flatMap(numbers->numbers.stream())
//                .map(artist3 -> artist3.getName())
//                .forEach(ename->{
//                    if(sb.length()>1)
//                        sb.append(",");
//                    sb.append(ename);
//                });
//        sb.append("]");
//        System.out.println(sb.toString());
//
//        //一个笨重的reduce
//        StringBuilder reduced=albums.stream().map(album -> album.getMusicians())
//                .flatMap(musicans->musicans.stream())
//                .map(mucian->mucian.getName())
//                .reduce(new StringBuilder(),(builder,names)->{
//                  if(builder.length()>1)
//                      builder.append(",");
//                    builder.append(names);
//                    return builder;
//                },(left,right)->left.append(right));
//        reduced.insert(0,"[");
//        reduced.append("]");
//        System.out.println("reduced: "+reduced.toString());
//
//
//        //一个轻巧的 reduce
//        ArrayList<String> l1=new ArrayList<>();
//        ArrayList<Integer> l2=new ArrayList<>();
//        System.out.println(l1.getClass()==l2.getClass());
//        try{
//            l1.getClass().getMethod("add", Object.class).invoke(l1,"asd");
//            if(l1.size()>=1)
//                System.out.println(l1.get(0));
//        }catch (NoSuchMethodException e){
//            System.out.println(e);
//        }catch (IllegalAccessException e){
//            System.out.println(e);
//        }catch (InvocationTargetException e){
//            System.out.println(e);
//        }
//
//        //测试泛型
//        System.out.println(Test.add(1,2));
//        System.out.println(Test.add("abc","df"));
//        System.out.println(Test.<Integer>add(3,4));
//        //if(l1 instanceof ArrayList<String>)
//        if(l1 instanceof ArrayList<?>)
//            System.out.println();
//        //System.out.println(Test.<Integer>add(1,"abc"));
//        System.out.println(FanXing.get(1));
//        //Collector
//    }
//    private static <T> T add(T x,T y){
//        if(Math.random()>0.5)
//            return x;
//        else
//            return y;
//    }
//}
//
//class FanXing<T>{
//    public static <T> T get(T a){
//        System.out.println("this is in static get:"+a);
//        return a;
//    }
//
//}
