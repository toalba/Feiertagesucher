import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GUI extends Application{

    public void start(Stage s)
    {
        ui(s);
    }
   public void ui(Stage s) {

       GridPane grid = new GridPane();
       grid.setPadding(new Insets(10, 10, 10, 10));
       grid.setVgap(5);
       grid.setHgap(5);
       //Defining the minJahr text field
       Label label1 = new Label("Gebe das min. Jahr in Format <yyyy> ein:");
       final TextField minJahr = new TextField();
       minJahr.setPromptText("<yyyy>");
       minJahr.setPrefColumnCount(4);
       minJahr.getText();
       HBox hb1 = new HBox();
       hb1.getChildren().addAll(label1, minJahr);
       hb1.setSpacing(10);
       GridPane.setConstraints(hb1, 0, 0);
       grid.getChildren().add(hb1);
       //Defining the minJahr text field
       Label label2 = new Label("Gebe das max. Jahr in Format <yyyy> ein:");
       final TextField maxJahr = new TextField();
       maxJahr.setPromptText("<yyyy>");
       maxJahr.setPrefColumnCount(4);
       maxJahr.getText();
       HBox hb2 = new HBox();
       hb2.getChildren().addAll(label2, maxJahr);
       hb2.setSpacing(10);
       GridPane.setConstraints(hb2, 0, 1);
       grid.getChildren().add(hb2);
       //Defining the Submit button
       Button submit = new Button("Submit");
       GridPane.setConstraints(submit, 0, 2);
       grid.getChildren().add(submit);

       //Adding a Label
       final Label label = new Label();
       GridPane.setConstraints(label, 0, 3);
       GridPane.setColumnSpan(label, 2);
       grid.getChildren().add(label);

       Scene sc = new Scene(grid, 300, 150);
       s.setScene(sc);
       s.setTitle("Eingabe Jahre");
       s.show();
       boolean warten=false;

       List<String> Jahre = new ArrayList<String>();
       submit.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent e) {
               if ((minJahr.getText() != null && !minJahr.getText().isEmpty()) && (maxJahr.getText() != null && !maxJahr.getText().isEmpty())) {
                   Jahre.add(minJahr.getText());
                   Jahre.add(maxJahr.getText());
                   Comp comp = new Comp();
                   comp.feiertage(Jahre,s);
                   s.close();
               } else {
                   label.setText("The Input is not correct");
               }

           }
       });

   }
    public void diagram(String Jahre)
    {
        try {

            Stage stage = new Stage();
            stage.setTitle("Feiertagediagramm von "+Jahre);
            Mariadb mariadb = new Mariadb();
            List<String> Wochentage = new ArrayList<String>();
            HashMap<String,Integer> feiertage= new HashMap<String,Integer>();
            feiertage = mariadb.getData();
            final CategoryAxis xAxis = new CategoryAxis();
            final NumberAxis yAxis = new NumberAxis();
            final BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
            Wochentage.add("Montag");Wochentage.add("Dienstag");Wochentage.add("Mittwoch");Wochentage.add("Donnerstag");Wochentage.add("Freitag");
            barChart.setTitle("Anzahl der Feiertage pro Wochentag von "+Jahre);
            xAxis.setLabel("Wochentage");
            yAxis.setLabel("Anzahl");
            XYChart.Series series1 = new XYChart.Series();
            series1.setName("Anzahl der Feiertage");
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
