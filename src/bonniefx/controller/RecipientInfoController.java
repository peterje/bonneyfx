package bonniefx.controller;

import bonniefx.model.Recipient;
import bonniefx.model.SaleCreator;
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
import java.util.ResourceBundle;

public class RecipientInfoController implements Initializable {

    @FXML
    private ToggleButton isDeceased;

    @FXML
    private DatePicker dateOfDeath;

    @FXML
    private TextField recipientName;

    @FXML
    private DatePicker dateOfBirth;

    ToggleGroup tg;

    public void switchScene(ActionEvent event) throws IOException {
        String name = recipientName.getText();
        LocalDate dob = dateOfBirth.getValue();
        LocalDate dod = dateOfDeath.getValue();
        boolean deceased = isDeceased.isSelected();
        SaleCreator.getInstance().getSale().setRecipient(new Recipient(name, deceased, dob, dod));
        System.out.println(SaleCreator.getInstance().getSale().getRecipient().toString());
        Parent p = FXMLLoader.load(getClass().getResource("../view/directorsInfo.fxml"));
        Scene scene = new Scene(p);

        // get the stage
        Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
        window.setScene(scene);
    }

    public void initialize(URL url, ResourceBundle rb) {
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
