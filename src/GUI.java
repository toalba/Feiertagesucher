import javafx.application.Application;
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.*;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GUI extends Application{

    Comp comp = new Comp();
    public HashMap<String,Integer> feiertage= comp.feiertage();
    public List<String> Wochentage = new ArrayList<String>();

    @Override
   public void start(Stage stage) {
       try {
           // Angeben wie die Achsen sein sollen
           final CategoryAxis xAxis = new CategoryAxis();
           final NumberAxis yAxis = new NumberAxis();
           final BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
           Wochentage.add("Montag");
           Wochentage.add("Dienstag");
           Wochentage.add("Mittwoch");
           Wochentage.add("Donnerstag");
           Wochentage.add("Freitag");
           barChart.setTitle("Anzahl der Feiertage pro Woche");
           xAxis.setLabel("Wochentage");
           yAxis.setLabel("Anzahl");
           XYChart.Series series1 = new XYChart.Series();
           for (int i = 0 ;i<Wochentage.size();i++)
           {
               series1.getData().add(new XYChart.Data(Wochentage.get(i),feiertage.get(Wochentage.get(i))));
           }

           Scene scene = new Scene(barChart, 960, 540);
           barChart.getData().addAll(series1);
           stage.setScene(scene);
           stage.show();
       } catch(Exception e) {
           e.printStackTrace();
       }
   }      
   public static void main(String args[]){ 
      launch(args);
   } 
}