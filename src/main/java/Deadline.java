import java.util.Date;

public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public Date getDate(){
        String Value[] = by.split("/");
        int day = Integer.parseInt(Value[0]);
        int month = Integer.parseInt(Value[1]);
        String yr[] = Value[2].split(" ");
        int year = Integer.parseInt(yr[0]);
        int hour = Integer.parseInt(yr[1].substring(0,1));
        int min = Integer.parseInt(yr[1].substring(2));
        Date date = new Date(year,month,day,hour,min);
        return date;
    }

    @Override
    public String Storage(){
        return "D | " + getStatusIcon() + " " + description + " | " + by;
    }

    @Override
    public String toString() {
        return "[D]" + "[" + getStatusIcon()+ "]" + description + "(by:" + by + ")";
    }
}