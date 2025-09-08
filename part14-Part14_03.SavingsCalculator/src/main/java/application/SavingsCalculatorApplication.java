package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class SavingsCalculatorApplication extends Application {

    @Override
    public void start(Stage window) {

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(20, 20, 20, 20));

        VBox topComponent = new VBox();
        topComponent.setSpacing(20);

        BorderPane sliderLayout1 = new BorderPane();
        BorderPane sliderLayout2 = new BorderPane();

        Label monthlySavingsLabel = new Label("Monthly savings");
        Label sliderValueLabel1 = new Label("0");

        Label yearlyInterestRateLabel = new Label("Yearly interest rate");
        Label sliderValueLabel2 = new Label("0");

        Slider monthlySavingsSlider = new Slider(25, 250, 25);
        monthlySavingsSlider.setShowTickLabels(true);
        monthlySavingsSlider.setShowTickMarks(true);
        monthlySavingsSlider.setMajorTickUnit(25);
        monthlySavingsSlider.setMinorTickCount(3);

        Slider yearlyInterestRatesSlider = new Slider(0, 10, 0);
        yearlyInterestRatesSlider.setShowTickLabels(true);
        yearlyInterestRatesSlider.setShowTickMarks(true);
        yearlyInterestRatesSlider.setMajorTickUnit(1);
        yearlyInterestRatesSlider.setMinorTickCount(0);

        sliderValueLabel1.setText(String.valueOf((int) monthlySavingsSlider.getValue()));
        sliderValueLabel2.setText(String.valueOf((int) yearlyInterestRatesSlider.getValue()));

        layout.setTop(topComponent);
        topComponent.getChildren().add(sliderLayout1);
        topComponent.getChildren().add(sliderLayout2);

        sliderLayout1.setLeft(monthlySavingsLabel);
        sliderLayout1.setCenter(monthlySavingsSlider);
        sliderLayout1.setRight(sliderValueLabel1);

        sliderLayout2.setLeft(yearlyInterestRateLabel);
        sliderLayout2.setCenter(yearlyInterestRatesSlider);
        sliderLayout2.setRight(sliderValueLabel2);

        XYChart.Series<Number, Number> monthlySavingData = new XYChart.Series<>();
        monthlySavingData.setName("no Interest");
        XYChart.Series<Number, Number> interestData = new XYChart.Series<>();
        interestData.setName("with interest");

        NumberAxis yAxis = new NumberAxis(0, (int) monthlySavingsSlider.getValue() * 400, (int) monthlySavingsSlider.getValue() * (int) monthlySavingsSlider.getValue());
        NumberAxis xAxis = new NumberAxis(0, 30, 1);

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings calculator");
        //lineChart.setLegendVisible(false);

        for (int year = 0; year <= 30; year++) {

            double totalSavings = ((int) monthlySavingsSlider.getValue() * 12) * (year);
            monthlySavingData.getData().add(new XYChart.Data<>(year, totalSavings));

        }

        lineChart.getData().add(monthlySavingData);
        lineChart.getData().add(interestData);
        layout.setCenter(lineChart);

        monthlySavingsSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            int monthlyValue = newVal.intValue();
            sliderValueLabel1.setText(String.valueOf(monthlyValue));

            monthlySavingData.getData().clear();
            for (int year = 0; year <= 30; year++) {
                double totalSavings = monthlyValue * 12 * year;
                monthlySavingData.getData().add(new XYChart.Data<>(year, totalSavings));
            }

            updateInterestLine(interestData, monthlyValue, yearlyInterestRatesSlider.getValue(), yAxis);
        });

        yearlyInterestRatesSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            double interestRate = newVal.doubleValue();
            sliderValueLabel2.setText(String.valueOf((int) interestRate));
            updateInterestLine(interestData, (int) monthlySavingsSlider.getValue(), interestRate, yAxis);
        });

        updateInterestLine(interestData, (int) monthlySavingsSlider.getValue(), yearlyInterestRatesSlider.getValue(), yAxis);

        Scene scene = new Scene(layout, 800, 800);
        window.setScene(scene);
        window.show();
    }

    private void updateInterestLine(XYChart.Series<Number, Number> interestData,
                                    int monthlySavingValue,
                                    double yearlyInterestRate,
                                    NumberAxis yAxis) {

        interestData.getData().clear();
        interestData.getData().add(new XYChart.Data<>(0, 0));

        double totalSavings = 0;

        for (int year = 1; year <= 30; year++) {
            // Add a full year's worth of savings
            totalSavings += monthlySavingValue * 12;

            // Apply yearly interest
            totalSavings *= (1 + yearlyInterestRate / 100);

            interestData.getData().add(new XYChart.Data<>(year, totalSavings));
        }

        // Set appropriate axis bounds
        if (totalSavings > 0) {

            int step = 25000;
            double upperBound = Math.ceil(totalSavings / step) * step;

            yAxis.setUpperBound(upperBound);
            yAxis.setTickUnit(Math.ceil(upperBound / 5) );
        }
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");

        launch(SavingsCalculatorApplication.class);
    }

}
