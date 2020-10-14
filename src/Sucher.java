import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
public class Sucher{
    public int montag;
    public int dienstag;
    public int mittwoch;
    public int donerstag;
    public int freitag;

    public HashMap<String,Integer> sucher(List<LocalDate> list)
    {
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
        HashMap<String,Integer> Wochentage = new HashMap<>();
        Wochentage.put("Montag",montag);
        Wochentage.put("Dienstag",dienstag);
        Wochentage.put("Mittwoch",mittwoch);
        Wochentage.put("Donnerstag",donerstag);
        Wochentage.put("Freitag",freitag);
        return Wochentage;
    }
}