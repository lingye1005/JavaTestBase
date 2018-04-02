        package java8;

        import java.util.ArrayList;
        import java.util.List;

        /**
         * @Author: cxh
         * @CreateTime: 17/12/14 20:38
         * @ProjectName: JavaBaseTest
         * <专辑></>
         */
        public class Album {
            String name;//专辑名称
            List<Track> tracks;//专辑上所有曲目的列表
            List<Artist> musicians;//参与创作本专辑的艺术家列表
            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<Track> getTracks() {
                return tracks;
            }

            public void setTracks(ArrayList<Track> tracks) {
                this.tracks = tracks;
            }

            public List<Artist> getMusicians() {
                return musicians;
            }

            public void setMusicians(ArrayList<Artist> musicians) {
                this.musicians = musicians;
            }

            Album(String name,List<Track> tracks,List<Artist> musicians){
                this.name=name;
                this.tracks=tracks;
                this.musicians=musicians;
            }

            //获取主唱
            public String getMainMusician(){
                return musicians.get(0).getMembers().get(0);
            }
            @Override
            public String toString() {
                return "Album{" +
                        "name='" + name + '\'' +
                        ", tracks=" + tracks +
                        ", musicians=" + musicians +
                        '}';
            }
        }
