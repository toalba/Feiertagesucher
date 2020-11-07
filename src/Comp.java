import java.sql.SQLException;
import java.util.HashMap;

public class Comp {


    public HashMap<String,Integer> feiertage() {

        String url1 = "https://deutsche-feiertage-api.de/api/v1/";
        String url2 = "https://ferien-api.de/api/v1/holidays/BY/";
        Apicon apicon = new Apicon();
        Menu menu = new Menu();
        Sucher sucher = new Sucher();
        Handler handler = new Handler();
        String mindate = menu.mindate();
        String maxdate = menu.maxdate();
        HashMap<String,Integer> feiertageMap =  sucher.sucher(handler.gLocalDates(apicon.getfeiertagObject(maxdate,mindate,url1)));
        return feiertageMap;
       /* try {
			Mariadb mariadb = new Mariadb();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }
}