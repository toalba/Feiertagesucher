import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.json.*;


public class Handler {

    public List<LocalDate> gLocalDates(List<JSONObject> jsonyearList)
    {
        try {
            List<LocalDate> dList = new ArrayList<>();
            for (int i = 0; i < jsonyearList.size(); i++) {
                JSONObject obj = jsonyearList.get(i);
                System.out.println("Loading... "+obj.getString("message"));
                JSONArray arr= obj.getJSONArray("holidays");
                for (int j = 0; j < arr.length(); j++)
                {
                  LocalDate date = getDateofJSON(arr.getJSONObject(j),"holiday","date");
                  dList.add(date);
                }           
            }
            return dList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }
    public LocalDate getDateofJSON(JSONObject obj,String n1,String n2)
    {
        try {
            JSONObject obj2 = obj.getJSONObject(n1);
            return LocalDate.parse(obj2.getString(n2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<LocalDate> gferienLocalDates(List<JSONArray> jsonyearList)
    {
        try {
            List<LocalDate> dList = new ArrayList<>();
            for (int i = 0; i < jsonyearList.size(); i++) {

               
                JSONArray ar = jsonyearList.get(i);
                System.out.println(ar.get(1));
                JSONObject ar2 = (JSONObject) ar.get(1);
                System.out.println(ar2);
                
        
            }
            return dList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        
    }


}
