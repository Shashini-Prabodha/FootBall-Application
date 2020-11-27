package lk.premierleague.pos;

public class SportClub {
     String name;
     String location;
     int tp;

    SportClub(){}
    SportClub(String name,String location,int tp){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }
}
