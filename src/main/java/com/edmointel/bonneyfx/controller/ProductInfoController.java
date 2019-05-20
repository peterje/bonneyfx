package com.edmointel.bonneyfx.controller;

import com.edmointel.bonneyfx.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.joda.money.Money;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.ResourceBundle;

public class ProductInfoController implements Initializable {
    @FXML
    private ComboBox<PlotCode> plotCodeSelect;

    @FXML
    private ComboBox<Product> productSelect;

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

    @FXML
    private Button addItemBtn;


    private Alert alert;
    private List<Node> inputNodes;
    private List<Product> forethoughProducts;
    private boolean atNeedSale;

    public boolean isForethought(Product product) {
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

    public void addItem(ActionEvent e) throws IOException
    {
        if (!validInput()) {
            alert.showAndWait().filter(response -> response == ButtonType.OK);
            return;
        }
        submit(e); // build item and add to sale

        Parent p = FXMLLoader.load(getClass().getClassLoader().getResource("view/productInfo.fxml"));
        Scene scene = new Scene(p);
        Stage window = (Stage) (((Node) e.getSource()).getScene().getWindow());
        window.setScene(scene);

    }

    public void enableFields(Product product) {
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

        if (product.equals(Product.PROPERTY))
            plotCodeSelect.setDisable(false);
        else
            plotCodeSelect.setDisable(true);
    }

    public void updateProduct(ActionEvent event) {
        enableFields(productSelect.getValue());
    }

    public void submit(ActionEvent e) {

        Item item = null;
        Product product = productSelect.getValue();
        PlotCode plotCode = plotCodeSelect.getValue();
        LeadCode leadCode = leadCodeSelect.getValue();
        Money boardValue;
        Money downPayment;

        // add item to sale
        if (atNeedSale) { // at need
            boardValue = Utils.toUSD(boardValueField.getText());
            item = new AtNeedItem(product, boardValue,Sale.getInstance(), plotCode);
        } else if (isForethought(product)) { // forethough
            int payPlan = planSelect.getValue();
            boardValue = Utils.toUSD(faceAmount.getText());
            item = new Forethought(product, boardValue, Sale.getInstance(), payPlan);
        } else { // pre need
            downPayment = Utils.toUSD(downPaymentField.getText());
            boardValue = Utils.toUSD(boardValueField.getText());
            item = new PreNeedItem(product, boardValue, Sale.getInstance(), downPayment, leadCode, plotCode);
        }
        Sale.getInstance().addItem(item);
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


        forethoughProducts = new ArrayList<Product>();
        forethoughProducts.add(Product.INSURANCE);
        forethoughProducts.add(Product.TRUST);
        forethoughProducts.add(Product.TRAVEL);

        EnumSet<PlotCode> plotCodesSet = EnumSet.allOf(PlotCode.class);
        ObservableList<PlotCode> plotCodesList = FXCollections.observableArrayList();
        plotCodesList.addAll(plotCodesSet);

        EnumSet<Product> products = EnumSet.allOf(Product.class);
        ObservableList<Product> productsList = FXCollections.observableArrayList();
        productsList.addAll(products);

        ObservableList<LeadCode> leadCodes = FXCollections.observableArrayList();
        EnumSet<LeadCode> leadCodeSet = EnumSet.allOf(LeadCode.class);
        leadCodes.addAll(leadCodeSet);

        ObservableList<Integer> payPlans = FXCollections.observableArrayList(1, 3, 5, 7, 10);

        productSelect.setItems(productsList);
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

        enableFields(Product.MERCHANDISE);
    }
}
