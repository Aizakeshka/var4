package com.example.var4;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Random;

public class MainController {

    private final ObservableList<Character> characterList = FXCollections.observableArrayList();

    @FXML
    private TextField nameField;
    @FXML
    private ComboBox<String> genderBox;
    @FXML
    private ComboBox<String> raceBox;
    @FXML
    private ComboBox<String> classBox;
    @FXML
    private Spinner<Integer> levelSpinner;
    @FXML
    private Button randomNameButton;
    @FXML
    private Button generateButton;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button saveButton;

    @FXML
    private TableView<Character> table;
    @FXML
    private TableColumn<Character, String> nameColumn;
    @FXML
    private TableColumn<Character, String> genderColumn;
    @FXML
    private TableColumn<Character, String> raceColumn;
    @FXML
    private TableColumn<Character, String> classColumn;
    @FXML
    private TableColumn<Character, Integer> strengthColumn;
    @FXML
    private TableColumn<Character, Integer> agilityColumn;
    @FXML
    private TableColumn<Character, Integer> intelligenceColumn;
    @FXML
    private TableColumn<Character, Integer> enduranceColumn;
    @FXML
    private TableColumn<Character, Integer> charismaColumn;
    @FXML
    private TableColumn<Character, Integer> luckColumn;
    @FXML
    private TableColumn<Character, Integer> levelColumn;

    @FXML
    public void initialize() {
        // Инициализация comboBox (если не сделано в FXML)
        genderBox.setItems(FXCollections.observableArrayList("Мужской", "Женский", "Рандом"));
        raceBox.setItems(FXCollections.observableArrayList("Человек", "Эльф", "Орк", "Гном", "Демон", "Нежить"));
        classBox.setItems(FXCollections.observableArrayList("Воин", "Маг", "Ассасин", "Лучник", "Жрец", "Варвар", "Некромант"));

        // Инициализация spinner (если не сделано в FXML)
        levelSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 50, 1));

        table.setItems(characterList);
        setupColumns();
    }

    private void setupColumns() {
        nameColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        genderColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getGender()));
        raceColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getRace()));
        classColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getCharacterClass()));

        strengthColumn.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getStrength()).asObject());
        agilityColumn.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getAgility()).asObject());
        intelligenceColumn.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getIntelligence()).asObject());
        enduranceColumn.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getEndurance()).asObject());
        charismaColumn.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getCharisma()).asObject());
        luckColumn.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getLuck()).asObject());
        levelColumn.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getLevel()).asObject());
    }

    @FXML
    private void onRandomName() {
        String gender = genderBox.getValue();
        if (gender == null || gender.equals("Рандом")) {
            gender = new Random().nextBoolean() ? "Мужской" : "Женский";
            genderBox.setValue(gender);
        }
        nameField.setText(CharacterGenerator.randomName(gender));
    }

    @FXML
    private void onGenerate() {
        Character ch = CharacterGenerator.generateRandomCharacter();
        nameField.setText(ch.getName());
        genderBox.setValue(ch.getGender());
        raceBox.setValue(ch.getRace());
        classBox.setValue(ch.getCharacterClass());
        levelSpinner.getValueFactory().setValue(ch.getLevel());
    }

    @FXML
    private void onAdd() {
        characterList.add(collectCharacter());
    }

    @FXML
    private void onDelete() {
        Character selected = table.getSelectionModel().getSelectedItem();
        if (selected != null) {
            characterList.remove(selected);
        }
    }

    @FXML
    private void onSave() {
        ExcelExporter.export(characterList, "characters.xlsx");
    }

    private Character collectCharacter() {
        return new Character(
                nameField.getText(),
                genderBox.getValue(),
                raceBox.getValue(),
                classBox.getValue(),
                CharacterGenerator.random(1, 20),
                CharacterGenerator.random(1, 20),
                CharacterGenerator.random(1, 20),
                CharacterGenerator.random(1, 20),
                CharacterGenerator.random(1, 20),
                CharacterGenerator.random(1, 10),
                levelSpinner.getValue()
        );
    }
}
