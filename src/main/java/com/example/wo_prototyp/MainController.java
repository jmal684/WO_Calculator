package com.example.wo_prototyp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private ToggleButton btn_bit0, btn_bit1, btn_bit2, btn_bit3, btn_bit4, btn_bit5, btn_bit6, btn_bit7, btn_bit8, btn_bit9, btn_bit10,
            btn_bit11, btn_bit12, btn_bit13, btn_bit14, btn_bit15, btn_bit16, btn_bit17, btn_bit18, btn_bit19, btn_bit20,
            btn_bit21, btn_bit22, btn_bit23, btn_bit24, btn_bit25, btn_bit26, btn_bit27, btn_bit28, btn_bit29, btn_bit30,
            btn_bit31, btn_bit32, btn_bit33, btn_bit34, btn_bit35, btn_bit36, btn_bit37, btn_bit38, btn_bit39, btn_bit40,
            btn_bit41, btn_bit42, btn_bit43, btn_bit44, btn_bit45, btn_bit46, btn_bit47, btn_bit48, btn_bit49, btn_bit50,
            btn_bit51, btn_bit52, btn_bit53, btn_bit54, btn_bit55, btn_bit56, btn_bit57, btn_bit58, btn_bit59, btn_bit60, btn_bit61,
            btn_bit62, btn_bit63;
    @FXML
    private Button btn_A, btn_B, btn_C, btn_D,btn_E, btn_F, btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    @FXML
    private Label label_bit_63, label_bit_47, label_bit_32, label_bit_31, label_bit_15;
    @FXML
    private Label output_screen_label;
    @FXML
    private ToggleGroup number_systems, number_formats;

    private ArrayList<ToggleButton> binaryRepresentationButtons;
    private Button[] keyboardKeysButtons;
    private Label[] bitLabels;
    private String currentOutput;


    // initialization
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeBinaryRepresentationToggleButtons();
        initializeNumberSystemsToggleGroup();
        initializeNumberFormatsToggleGroup();
        initializeKeyboard();

        currentOutput = output_screen_label.getText();
    }
    private void initializeBinaryRepresentationToggleButtons(){
        binaryRepresentationButtons = new ArrayList<ToggleButton>(Arrays.asList(new ToggleButton[]{btn_bit0, btn_bit1, btn_bit2, btn_bit3, btn_bit4, btn_bit5, btn_bit6, btn_bit7, btn_bit8, btn_bit9, btn_bit10,
                btn_bit11, btn_bit12, btn_bit13, btn_bit14, btn_bit15, btn_bit16, btn_bit17, btn_bit18, btn_bit19, btn_bit20,
                btn_bit21, btn_bit22, btn_bit23, btn_bit24, btn_bit25, btn_bit26, btn_bit27, btn_bit28, btn_bit29, btn_bit30,
                btn_bit31, btn_bit32, btn_bit33, btn_bit34, btn_bit35, btn_bit36, btn_bit37, btn_bit38, btn_bit39, btn_bit40,
                btn_bit41, btn_bit42, btn_bit43, btn_bit44, btn_bit45, btn_bit46, btn_bit47, btn_bit48, btn_bit49, btn_bit50,
                btn_bit51, btn_bit52, btn_bit53, btn_bit54, btn_bit55, btn_bit56, btn_bit57, btn_bit58, btn_bit59, btn_bit60, btn_bit61,
                btn_bit62, btn_bit63}));

        bitLabels = new Label[]{label_bit_63, label_bit_47, label_bit_32, label_bit_31, label_bit_15};

        for(ToggleButton toggleButton: binaryRepresentationButtons)
        {
            toggleButton.setOnAction(actionEvent -> {
                toggleButton.setText(toggleButton.getText().equals("0") ? "1" : "0");
                System.out.println("Button " + binaryRepresentationButtons.indexOf(toggleButton));
            });
        }
    }
    private void initializeNumberSystemsToggleGroup(){
        number_systems.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton clicked = (RadioButton) t1.getToggleGroup().getSelectedToggle();

                // TODO Implement converting to different number systems, preferably using a switch
                updateKeyboardKeysAvailability(clicked.getText());

            }
        });
    }
    private void initializeNumberFormatsToggleGroup(){
        number_formats.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton clicked = (RadioButton) t1.getToggleGroup().getSelectedToggle();

                //TODO Implement converting to different number formats, preferably using a switch
                updateBinaryRepresentationScreen(clicked.getText());
            }
        });
    }
    private void initializeKeyboard(){
        keyboardKeysButtons = new Button[]{btn_A, btn_B, btn_C, btn_D, btn_E, btn_F, btn_9, btn_8, btn_7, btn_6, btn_5, btn_4, btn_3, btn_2, btn_1, btn_0};

        for(Button key: keyboardKeysButtons)
        {
            key.setOnAction(e -> {
                updateOutputScreenLabel(key.getText(), true);
            });
        }

    }

    // updating view components
    private void updateBinaryRepresentationScreen(String numberFormat){
        int availableBits = 0, labelSwitcherIndicator = 0;

        labelSwitcherIndicator = switch (numberFormat) {
            case "Qword" -> {
                availableBits = 64;
                yield 6;
            }
            case "Dword" -> {
                availableBits = 32;
                yield 3;
            }
            case "Word" -> {
                availableBits = 16;
                yield 2;
            }
            case "Byte" -> {
                availableBits = 8;
                yield 1;
            }
            default -> labelSwitcherIndicator;
        };

        for (int i = 0; i < bitLabels.length; i++)
            bitLabels[i].setVisible(i > bitLabels.length - labelSwitcherIndicator);

        for (int i = binaryRepresentationButtons.size() - 1; i >= 0; i--)
        {
            ToggleButton bitButton = binaryRepresentationButtons.get(i);

            if(i >= availableBits)
            {
                bitButton.setVisible(false);
                bitButton.setDisable(true);
                bitButton.setText("0");
            }
            else
            {
                bitButton.setVisible(true);
                bitButton.setDisable(false);
            }
        }
    }
    private void updateKeyboardKeysAvailability(String numberSystem){
        int amountOfAvailableKeys =
                switch (numberSystem){
            case "Hex" -> 16;
            case "Dec" -> 10;
            case "Oct" -> 8;
            case "Bin" -> 2;
            default -> 0;
                };

        for(int i = 0; i < keyboardKeysButtons.length; i++)
            keyboardKeysButtons[i].setDisable(i < (keyboardKeysButtons.length - amountOfAvailableKeys));
    }
    private void updateOutputScreenLabel(String s, boolean add){
        if(add)
        {
            if(currentOutput.charAt(0) == '0')
                currentOutput = s;
            else
                currentOutput += s;

        }
        else
        {
            if(currentOutput.length() - 1 < 1)
                currentOutput = "0";
            else
                currentOutput = currentOutput.substring(0, currentOutput.length() - 1);
        }

        output_screen_label.setText(currentOutput);
    }

    // action functions
    @FXML
    private void backspaceButtonHandler(ActionEvent event){
        updateOutputScreenLabel("", false);
    }


}