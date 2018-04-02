        package java8;

        import java.util.ArrayList;
        import java.util.List;

        /**
         * @Author: cxh
         * @CreateTime: 18/3/17 09:11
         * @ProjectName: JavaBaseTest
         */
        public class Albums {
            private static List<Album> albums;

            private static void init(){
                albums=new ArrayList<>();
                //第一张专辑
                //beyongd乐队,成员:黄家驹、黄贯中、黄家强、叶世荣 && 歌曲:真的爱你,喜欢你,海阔天空,大地
                List<String> members1=new ArrayList<>();
                members1.add("黄家驹");members1.add("黄贯中");members1.add("黄家强");members1.add("叶世荣");
                List<Artist> artists1=new ArrayList<>();
                artists1.add(new Artist("beyongd乐队",members1,"中国"));
                List<Track> tracks1=new ArrayList<>();
                tracks1.add(new Track("真的爱你",3));
                tracks1.add(new Track("喜欢你",4));
                tracks1.add(new Track("海阔天空",5));
                tracks1.add(new Track("大地",3));
                albums.add(new Album("beyond乐队专辑",tracks1,artists1));

                //第二张专辑
                //瘦人乐队,成员:戴秦,周坤 && 歌曲:《瘦人I》《瘦人I》《第七天》EP《一路向北》
                List<String> members2=new ArrayList<>();
                members2.add("戴秦");members2.add("周坤");
                List<Artist> artists2=new ArrayList<>();
                artists2.add(new Artist("瘦人乐队",members2,"中国"));
                List<Track> tracks2=new ArrayList<>();
                tracks2.add(new Track("瘦人I",3));
                tracks2.add(new Track("瘦人II",3));
                tracks2.add(new Track("第七天",3));
                tracks2.add(new Track("一路向北",3));
                albums.add(new Album("瘦人乐队专辑",tracks2,artists2));

                //第三张专辑
                //五月天乐队,成员:温尚翊、阿信、石头、贝斯玛莎,冠佑  &&  歌曲:别惹我,知足,倔强,温柔\
                List<String> members3=new ArrayList<>();
                members3.add("温尚翊");members3.add("阿信");members3.add("石头");members3.add("贝斯玛莎");members3.add("冠佑");
                List<Artist> artists3=new ArrayList<>();
                artists3.add(new Artist("五月天乐队",members3,"中国"));
                List<Track> tracks3=new ArrayList<>();
                tracks3.add(new Track("别惹我",3));tracks3.add(new Track("知足",3));
                tracks3.add(new Track("倔强",3));tracks3.add(new Track("温柔",3));
                albums.add(new Album("五月天乐队专辑",tracks3,artists3));

                //第四章专辑
                //天堂乐队:雷刚,羊力,贺成功,仲夏,孙永栋 && 歌曲:少年,过年喽,战斗
                List<String> members4=new ArrayList<>();
                members4.add("雷刚"); members4.add("羊力"); members4.add("贺成功");
                members4.add("仲夏"); members4.add("孙永栋");
                List<Artist> artists4=new ArrayList<>();
                artists4.add(new Artist("天堂乐队",members4,"中国"));
                List<Track> tracks4=new ArrayList<>();
                tracks4.add(new Track("少年",3));tracks4.add(new Track("过年喽",3));
                tracks4.add(new Track("战斗",3));
                albums.add(new Album("天堂乐队专辑",tracks4,artists4));
            }
            public static List<Album> getAlbums(){
                init();
                return albums;
            }
        }
