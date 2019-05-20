package com.edmointel.bonneyfx.controller;

import com.edmointel.bonneyfx.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class DirectorsInfoController implements Initializable {

    @FXML
    private HBox director0;

    @FXML
    private HBox director1;

    @FXML
    private HBox director2;

    @FXML
    private HBox director3;

    private int lastDirectorID = 0;
    private Alert alert;
    private Alert alertPCT;

    private List<HBox> inputBoxes = new ArrayList<>();
    private SalesPerson primaryServiceDirector;
    private ArrayList<SalesPerson> secondarySalesPeople;

    public double getSplit(HBox root) {
        return Double.parseDouble(((TextField) (root.getChildren().get(1))).getText());
    }

    public String getName(HBox root) {
        return ((TextField) (root.getChildren().get(0))).getText();
    }


    public boolean isValidPCT() {
        double sum = 0.0;
        for (HBox h : inputBoxes) {
            if (!h.isDisabled())
                sum += getSplit(h);
        }
        if (sum != 100.0)
            return false;
        return true;
    }

    public boolean validInput() {
        for (HBox h : inputBoxes) {
            if (!h.isDisabled()) {
                {
                    if(getName(h).trim().isEmpty())
                        return false;
                }
            }
        }
        return true;
    }

    public void addDirector(ActionEvent event) {
        if (lastDirectorID < 3) {
            lastDirectorID++;
            inputBoxes.get(lastDirectorID).setDisable(false);
        }
    }

    public void removeDirector(ActionEvent event) {
        if (lastDirectorID > 0) {
            HBox root = inputBoxes.get(lastDirectorID);
            root.setDisable(true);
            ((TextField) (root.getChildren().get(0))).clear();
            ((TextField) (root.getChildren().get(1))).clear();
            lastDirectorID--;
        }
    }

    public void switchScene(ActionEvent event) throws IOException {
        if (!validInput()) {
            alert.showAndWait().filter(response -> response == ButtonType.OK);
            return;
        }
        if (!isValidPCT()) {
            alertPCT.showAndWait().filter(response -> response == ButtonType.OK);
            return;
        }

        // construct primary FSD
        HBox primaryBox = inputBoxes.get(0);
        primaryServiceDirector = new SalesPerson(getName(primaryBox), getSplit(primaryBox));

        // construct secondary director list
        secondarySalesPeople = new ArrayList<SalesPerson>();
        for (int i = 1; i < inputBoxes.size(); i++) // exclude first box, primary fsd
        {
            HBox root = inputBoxes.get(i);
            if (!root.isDisabled()) {
                secondarySalesPeople.add(new SalesPerson(getName(root), getSplit(root)));
            }
        }
        // add sales group to sale
        Sale.getInstance().setSalesGroup(new SalesGroup(primaryServiceDirector, secondarySalesPeople));

        // switch to recipient info page
        Parent p = FXMLLoader.load(getClass().getClassLoader().getResource("view/recipientInfo.fxml"));
        Scene scene = new Scene(p);
        Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
        window.setScene(scene);
    }

    public void initialize(URL url, ResourceBundle rb) {
        alert = new Alert(Alert.AlertType.WARNING, "There are unfilled fields");
        alertPCT = new Alert(Alert.AlertType.WARNING, "Splits do not add to 100%");

        inputBoxes.add(director0);
        inputBoxes.add(director1);
        inputBoxes.add(director2);
        inputBoxes.add(director3);

        director1.setDisable(true);
        director2.setDisable(true);
        director3.setDisable(true);

    }

}
