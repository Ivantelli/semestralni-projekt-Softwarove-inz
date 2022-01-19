package cz.vse.si.predikceobleceni.controller;

import cz.vse.si.predikceobleceni.svet.Casoprostor;
import cz.vse.si.predikceobleceni.utils.Persistence;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class SmazatLokalituController {
    @FXML
    private ListView<Casoprostor> lokalityListView;
    @FXML
    private Button smazatButton;

    int currentId = Integer.MIN_VALUE;

    @FXML
    private void initialize() {
        nacistListView();
    }

    public void zpracujKliknutiMysi(MouseEvent mouseEvent) {
        if (lokalityListView.equals(mouseEvent.getSource())) {
            Casoprostor lokalita = lokalityListView.getSelectionModel().getSelectedItem();
            if (lokalita != null) {
                currentId = lokalita.getId();
            } else {
                return;
            }
        }

        smazatButton.setDisable(false);
    }

    public void smazatLokalitu() {
        //Persistence persistence = new Persistence();
        Persistence.getInstance().odeberLokalituPodleId(currentId);

        nacistListView();
    }

    private void nacistListView() {
        //Persistence persistence = new Persistence();
        ArrayList<Casoprostor> lokality = Persistence.getInstance().getLokality();

        ObservableList<Casoprostor> lokalityObservableList = FXCollections.observableArrayList(lokality);
        lokalityListView.setItems(lokalityObservableList);
    }
}
