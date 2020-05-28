package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entities.Pessoa;

public class ViewController implements Initializable{
	@FXML
	private ComboBox<Pessoa> comboBoxPessoa;
	@FXML
	private Button tudo;
	private ObservableList<Pessoa> obs;
	
	@FXML
	public void onComboBoxAction() {
		Pessoa pessoa = comboBoxPessoa.getSelectionModel().getSelectedItem();
		System.out.println(pessoa);
	}
	
	@FXML
	public void onTudoAction() {
		for(Pessoa pessoa: comboBoxPessoa.getItems()) {
			System.out.println(pessoa);
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Pessoa(1, "Maria","maria@gmail.com"));
		pessoas.add(new Pessoa(2, "Alex","alex@gmail.com"));
		pessoas.add(new Pessoa(3, "Bob","bob@gmail.com"));
		obs = FXCollections.observableArrayList(pessoas);
		comboBoxPessoa.setItems(obs);
		
		Callback<ListView<Pessoa>, ListCell<Pessoa>> factory = lv -> new ListCell<Pessoa>() {
			@Override
			protected void updateItem(Pessoa item, boolean empty) {
			super.updateItem(item, empty);
			setText(empty ? "" : item.getName());
			}
		};
		comboBoxPessoa.setCellFactory(factory);
		comboBoxPessoa.setButtonCell(factory.call(null));
	}
	
}
