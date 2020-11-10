import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
public class Sucher{
    public int montag;
    public int dienstag;
    public int mittwoch;
    public int donerstag;
    public int freitag;

    public void sucher(List<LocalDate> list)  {


        for (int i = 0; i < list.size(); i++) 
        {
            LocalDate tag = list.get(i);
            switch (tag.getDayOfWeek()) {
                case MONDAY: montag++; break;
                case TUESDAY: dienstag++; break;
                case WEDNESDAY: mittwoch++; break;
                case THURSDAY:donerstag++; break;
                case FRIDAY: freitag++; break;
                case SATURDAY: break;
                case SUNDAY: break;
            }
        }
        try {
            Mariadb mariadb = new Mariadb();
            mariadb.Inserttodb("INSERT INTO feiertage (Montag,Dienstag,Mittwoch,Donnerstag,Freitag) VALUES ("+montag+","+dienstag+","+mittwoch+","+donerstag+","+freitag+")");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}