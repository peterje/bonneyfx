package bonniefx.controller;

import bonniefx.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
    private TextField downPayment;

    @FXML
    private TextField boardValue;

    @FXML
    private ComboBox<String> leadCodeSelect;

    @FXML
    private TextField faceAmount;

    @FXML
    private Button submitButton;

    private List<String> forethoughProducts;
    private boolean atNeedSale;

    public void enableFields(String product) {
        if (forethoughProducts.contains(product)) {
            planSelect.setDisable(false);
            faceAmount.setDisable(false);
            boardValue.setDisable(true);
        } else {
            boardValue.setDisable(false);
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
        Item item = null;
        // TODO validate input


        // add item to sale
        String product = productSelect.getValue();
        if (atNeedSale) {
            // build atneed
            // product, board value, plot code
            item = new AtNeedItem();
        } else if (isForethought(product)) {
            int payPlan = planSelect.getValue();
            // product, pay plan, board value
            // TODO switch from product as enum to product as string
            //item = new Forethought(product, payPlan);
        } else {
            // build preneed
            // product, downpayment, lead code, board value
            item = new PreNeedItem();
        }

        // generate csv

        // generate pdf
    }

    public boolean isForethought(String product) {
        return forethoughProducts.contains(product);
    }

    public void initialize(URL url, ResourceBundle rb) {
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

        ObservableList<String> leadCodes = FXCollections.observableArrayList(
                "Company",
                "Personal"
        );
        ObservableList<Integer> payPlans = FXCollections.observableArrayList(1, 3, 5, 7, 10);
        productSelect.setItems(products);
        planSelect.setItems(payPlans);
        plotCodeSelect.setItems(plotCodesList);
        planSelect.setDisable(true);
        leadCodeSelect.setItems(leadCodes);

        // disable down payment for At Need sales
        atNeedSale = SaleCreator.getInstance().getSale().getRecipient().isDeceased();
        downPayment.setDisable(atNeedSale);

        if (atNeedSale) {
            // at needs are always company leads
            leadCodeSelect.getSelectionModel().select(0);
            leadCodeSelect.setDisable(true);
        }


        enableFields("Merchandise");
    }
}
