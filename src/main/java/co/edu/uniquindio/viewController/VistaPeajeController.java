package co.edu.uniquindio.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VistaPeajeController {

    @FXML
    private ComboBox<String> tipoBox;
    @FXML private TextField placaField;
    @FXML private TextField detalle1;
    @FXML private TextField detalle2;
    @FXML private Label lblResultado;

    public void initialize() {
        tipoBox.getItems().addAll("Carro", "Moto", "Camion");
    }

    @FXML
    private void registrarVehiculo() {
        String tipo = tipoBox.getValue();
        String placa = placaField.getText();
        
        
        lblResultado.setText("Vehículo registrado: " + tipo + " - " + placa);
    }

    public void onRegistrarVehiculo(ActionEvent actionEvent) {
    }

    public void onRegistrarPaso(ActionEvent actionEvent) {
    }

    public void onMostrarTotal(ActionEvent actionEvent) {

    }
}