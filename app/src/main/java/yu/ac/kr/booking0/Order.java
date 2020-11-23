package yu.ac.kr.booking0;

public class Order {
    public String Booker;
    public String Booked;
    public String groupNumber;
    public String date;
    public String time;

    public Order(){

    }

    public Order(String booker, String booked, String groupNumber, String date, String time){
        this.Booker = booker;
        this.Booked = booked;
        this.groupNumber = groupNumber;
        this.date = date;
        this.time = time;
    }

    public String getBooker() {
        return Booker;
    }

    public void setBooker(String booker) {
        Booker = booker;
    }

    public String getBooked() {
        return Booked;
    }

    public void setBooked(String booked) {
        Booked = booked;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
