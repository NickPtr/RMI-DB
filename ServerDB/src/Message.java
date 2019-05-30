/*Nikos Potaris
  icsd15173*/

import java.io.Serializable;

//klasi gia tin metafora ton minimatwn-gia tin epikoinonia Client kai Server
public class Message implements Serializable {

    private String title;
    private String type;
    private String singer;
    private String time;
    private int rating;
    private int repeats;

    public Message(String title, String type, String singer, String time, Integer repeats) {
        this.title = title;
        this.type = type;
        this.singer = singer;
        this.time = time;
        this.repeats=repeats;
    }

    public Message(int rating, int repeats)
    {
        this.rating=rating;
        this.repeats=repeats;
    }
    
    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;

    }

    public String getSinger() {
        return this.singer;
    }
    
    public String getTime() {
        return this.time;
    }

    public int getRating() {
        return this.rating;
    }
    
    public int getRepeats() {
        return this.repeats;
    }
}
