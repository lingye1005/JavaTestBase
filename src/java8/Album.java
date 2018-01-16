package java8;

import java.util.ArrayList;

/**
 * @Author: cxh
 * @CreateTime: 17/12/14 20:38
 * @ProjectName: JavaBaseTest
 * <专辑></>
 */
public class Album {
    String name;//专辑名称
    ArrayList<Track> tracks;//专辑上所有曲目的列表
    ArrayList<Artist> musicians;//参与创作本专辑的艺术家列表
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }

    public ArrayList<Artist> getMusicians() {
        return musicians;
    }

    public void setMusicians(ArrayList<Artist> musicians) {
        this.musicians = musicians;
    }

    Album(String name,ArrayList<Track> tracks,ArrayList<Artist> musicians){
        this.name=name;
        this.tracks=tracks;
        this.musicians=musicians;
    }

    //获取主唱
    public Artist getMainMusician(){
        if(musicians.size()>0)
            return musicians.get(0);
        else
            return null;
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
