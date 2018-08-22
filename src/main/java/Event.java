import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

public class Event {

    int id;
    String msg;
    Date date;
//    DateFormat dateFormat;

    public Event() {
        this.id = new Random().nextInt(200);
        this.date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }

    public Event(String message) {
        this.id = new Random().nextInt(200);
        this.date = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
        this.msg = message;
    }

    public Event(Date date) {
        this.date = date;
    }

//    public Event(Date date, DateFormat format) {
//        this.date=date;
//        this.dateFormat = format;
//    }
    public String toString() {
        return "Id: "+ id + ", msg: " + msg/*+ ", Date: " + dateFormat.format(date)*/;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
