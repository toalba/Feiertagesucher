import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class Comp {

    public void feiertage(List<String> jahre,Stage stage) {

        String url1 = "https://deutsche-feiertage-api.de/api/v1/";
        String url2 = "https://ferien-api.de/api/v1/holidays/BY/";
        Apicon apicon = new Apicon();
        Sucher sucher = new Sucher();
        Handler handler = new Handler();
        String jahres = jahre.get(0)+" bis "+jahre.get(1);
        sucher.sucher(handler.gLocalDates(apicon.getfeiertagObject(jahre.get(1),jahre.get(0),url1)));
        GUI gui = new GUI();
        gui.diagram(jahres);
    }
}