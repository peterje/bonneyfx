package bonniefx.controller;

import bonniefx.model.Recipient;
import bonniefx.model.Sale;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RecipientInfoController implements Initializable {

    ToggleGroup tg;
    @FXML
    private ToggleButton isDeceased;
    @FXML
    private DatePicker dateOfDeath;
    @FXML
    private TextField recipientName;
    @FXML
    private DatePicker dateOfBirth;

    private Alert alert;
    private List<Node> inputNodes;

    public boolean validInput() {
        for (Node n : inputNodes) {
            if (!n.isDisabled()) {
                if (n instanceof TextField) {
                    if (((TextField) n).getText().trim().isEmpty()) {
                        return false;

                    }
                } else if (n instanceof DatePicker)
                    if (((DatePicker) n).getValue() == null) {
                        return false;
                    }
            }
        }
        return true;
    }

    public void switchScene(ActionEvent event) throws IOException {
        if (!validInput()) {
            alert.showAndWait().filter(response -> response == ButtonType.OK);
            return;
        }

        // add recipient info to sale
        String name = recipientName.getText();
        LocalDate dob = dateOfBirth.getValue();
        LocalDate dod = dateOfDeath.getValue();
        boolean deceased = isDeceased.isSelected();
        Sale.getInstance().setRecipient(new Recipient(name, deceased, dob, dod));

        // switch to product info page
        Parent p = FXMLLoader.load(getClass().getResource("../view/productInfo.fxml"));
        Scene scene = new Scene(p);
        Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
        window.setScene(scene);
    }

    public void initialize(URL url, ResourceBundle rb) {
        alert = new Alert(Alert.AlertType.WARNING, "There are unfilled fields");
        inputNodes = new ArrayList<Node>();

        inputNodes.add(dateOfBirth);
        inputNodes.add(dateOfDeath);
        inputNodes.add(recipientName);

        dateOfDeath.setDisable(true);
        tg = new ToggleGroup();
        isDeceased.setToggleGroup(tg);
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                dateOfDeath.setDisable(!dateOfDeath.isDisabled());
            }
        });
    }
}
