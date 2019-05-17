package bonniefx.controller;

import bonniefx.model.SaleCreator;
import bonniefx.model.SalesGroup;
import bonniefx.model.SalesPerson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class DirectorsInfoController implements Initializable {

    @FXML
    private TextField primaryName;

    @FXML
    private TextField primaryPCT;

    @FXML
    private Button switchButton;

    @FXML
    private HBox director0;

    @FXML
    private HBox director1;

    @FXML
    private HBox director2;

    @FXML
    private HBox director3;

    private int lastDirectorID = 0;
    private HBox[] directorBoxes;

    private SalesPerson primaryServiceDirector;
    private ArrayList<SalesPerson> secondarySalesPeople;

    public void addDirector(ActionEvent event) {
        if (lastDirectorID < 3) {
            directorBoxes[lastDirectorID].setVisible(true);
            if (lastDirectorID < 2)
                lastDirectorID++;
        }
    }

    public void removeDirector(ActionEvent event) {
        if (lastDirectorID >= 0) {
            directorBoxes[lastDirectorID].setVisible(false);
            if (lastDirectorID > 0)
                lastDirectorID--;
        }
    }

    public void switchScene(ActionEvent event) throws IOException {
        //TODO Validate user input

        // construct the primary director
        try {
            primaryServiceDirector = new SalesPerson(primaryName.getText(), Double.parseDouble(primaryPCT.getText()));
        } catch (NumberFormatException e) {
            System.err.println("Not a valid split");
        }

        // construct secondary director list
        secondarySalesPeople = new ArrayList<SalesPerson>();
        List<String> directorInfo;
        HBox directorRow;
        for (int i = 0; i < lastDirectorID; i++) {
            directorRow = directorBoxes[i];
            directorInfo = new ArrayList<String>();
            for (Node node : directorRow.getChildren()) {
                if (node instanceof TextField)
                    directorInfo.add(((TextField) node).getText());
            }
            // create new sales rep with name string and sales pct
            secondarySalesPeople.add(new SalesPerson(directorInfo.get(0), Double.parseDouble(directorInfo.get(1))));
        }

        // add sales group to sale
        SaleCreator.getInstance().getSale().setSalesGroup(new SalesGroup(primaryServiceDirector, secondarySalesPeople));
        System.out.println(SaleCreator.getInstance().getSale().getSalesGroup().toString());

        // switch to recipient info page
        Parent p = FXMLLoader.load(getClass().getResource("../view/recipientInfo.fxml"));
        Scene scene = new Scene(p);
        Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
        window.setScene(scene);
    }

    public void initialize(URL url, ResourceBundle rb) {
        directorBoxes = new HBox[3];
        directorBoxes[0] = director1;
        directorBoxes[1] = director2;
        directorBoxes[2] = director3;

        director0.setVisible(true);
        director1.setVisible(false);
        director2.setVisible(false);
        director3.setVisible(false);
    }

}
