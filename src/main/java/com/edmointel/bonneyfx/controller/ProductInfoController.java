package com.edmointel.bonneyfx.controller;

import com.edmointel.bonneyfx.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import org.joda.money.Money;

import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.ResourceBundle;

public class ProductInfoController implements Initializable {
    @FXML
    private ComboBox<PlotCode> plotCodeSelect;

    @FXML
    private ComboBox<String> productSelect;

    @FXML
    private ComboBox<Integer> planSelect;

    @FXML
    private TextField downPaymentField;

    @FXML
    private TextField boardValueField;

    @FXML
    private ComboBox<LeadCode> leadCodeSelect;

    @FXML
    private TextField faceAmount;

    @FXML
    private Button submitButton;

    private Alert alert;
    private List<Node> inputNodes;
    private List<String> forethoughProducts;
    private boolean atNeedSale;

    public boolean isForethought(String product) {
        return forethoughProducts.contains(product);
    }

    public boolean validInput() {
        for (Node n : inputNodes) {
            if (!n.isDisabled()) {
                if (n instanceof TextField) {
                    if (((TextField) n).getText().trim().isEmpty()) {
                        return false;

                    }
                } else if (n instanceof ComboBox)
                    if (((ComboBox) n).getValue() == null) {
                        return false;
                    }
            }
        }
        return true;
    }

    public void resetComboBox(ComboBox cb) {
        cb.getSelectionModel().clearSelection();
        cb.setValue(null);
    }

    public void enableFields(String product) {
        boardValueField.clear();
        faceAmount.clear();
        downPaymentField.clear();
        resetComboBox(planSelect);
        resetComboBox(leadCodeSelect);
        resetComboBox(plotCodeSelect);

        if (forethoughProducts.contains(product)) {
            planSelect.setDisable(false);
            faceAmount.setDisable(false);
            boardValueField.setDisable(true);
        } else {
            boardValueField.setDisable(false);
            faceAmount.setDisable(true);
            planSelect.setDisable(true);
        }

        if (product.equals("Property"))
            plotCodeSelect.setDisable(false);
        else
            plotCodeSelect.setDisable(true);
    }

    public void updateProduct(ActionEvent event) {
        String product = (String) ((ComboBox) event.getSource()).getValue();
        enableFields(product);
    }

    public void submit(ActionEvent e) {
        if (!validInput()) {
            alert.showAndWait().filter(response -> response == ButtonType.OK);
            return;
        }

        Item item = null;
        String product = productSelect.getValue();
        PlotCode plotCode = plotCodeSelect.getValue();
        LeadCode leadCode = leadCodeSelect.getValue();
        Money boardValue;
        Money downPayment;

        // add item to sale
        if (atNeedSale) { // at need
            boardValue = Utils.toUSD(boardValueField.getText());
            item = new AtNeedItem(product, boardValue, plotCode);
        } else if (isForethought(product)) { // forethough
            int payPlan = planSelect.getValue();
            boardValue = Utils.toUSD(faceAmount.getText());
            item = new Forethought(product, boardValue, payPlan);
        } else { // pre need
            downPayment = Utils.toUSD(downPaymentField.getText());
            boardValue = Utils.toUSD(boardValueField.getText());
            item = new PreNeedItem(product, boardValue, downPayment, leadCode, plotCode);
        }
        Sale.getInstance().setItem(item);
        System.out.println(Sale.getInstance());

    }

    public void initialize(URL url, ResourceBundle rb) {
        alert = new Alert(Alert.AlertType.WARNING, "There are unfilled fields");

        inputNodes = new ArrayList<Node>();
        inputNodes.add(productSelect);
        inputNodes.add(planSelect);
        inputNodes.add(leadCodeSelect);
        inputNodes.add(plotCodeSelect);
        inputNodes.add(boardValueField);
        inputNodes.add(faceAmount);
        inputNodes.add(downPaymentField);


        forethoughProducts = new ArrayList<String>();
        forethoughProducts.add("Insurance");
        forethoughProducts.add("Trust");
        forethoughProducts.add("Travel");

        EnumSet<PlotCode> plotCodesSet = EnumSet.allOf(PlotCode.class);
        ObservableList<PlotCode> plotCodesList = FXCollections.observableArrayList();
        plotCodesList.addAll(plotCodesSet);

        ObservableList<String> products = FXCollections.observableArrayList(
                "Merchandise",
                "Property",
                "Interment",
                "Insurance",
                "Trust",
                "Travel");

        ObservableList<LeadCode> leadCodes = FXCollections.observableArrayList();
        EnumSet<LeadCode> leadCodeSet = EnumSet.allOf(LeadCode.class);
        leadCodes.addAll(leadCodeSet);

        ObservableList<Integer> payPlans = FXCollections.observableArrayList(1, 3, 5, 7, 10);
        productSelect.setItems(products);
        planSelect.setItems(payPlans);
        plotCodeSelect.setItems(plotCodesList);
        planSelect.setDisable(true);
        leadCodeSelect.setItems(leadCodes);

        // disable down payment for At Need sales
        atNeedSale = Sale.getInstance().getRecipient().isDeceased();
        downPaymentField.setDisable(atNeedSale);

        if (atNeedSale) {
            // at needs are always company leads
            leadCodeSelect.getSelectionModel().select(0);
            leadCodeSelect.setDisable(true);
        }


        enableFields("Merchandise");
    }
}
