package com.example.wo_prototyp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    private ToggleButton btn_bit0, btn_bit1, btn_bit2, btn_bit3, btn_bit4, btn_bit5, btn_bit6, btn_bit7, btn_bit8, btn_bit9, btn_bit10,
            btn_bit11, btn_bit12, btn_bit13, btn_bit14, btn_bit15, btn_bit16, btn_bit17, btn_bit18, btn_bit19, btn_bit20,
            btn_bit21, btn_bit22, btn_bit23, btn_bit24, btn_bit25, btn_bit26, btn_bit27, btn_bit28, btn_bit29, btn_bit30,
            btn_bit31, btn_bit32, btn_bit33, btn_bit34, btn_bit35, btn_bit36, btn_bit37, btn_bit38, btn_bit39, btn_bit40,
            btn_bit41, btn_bit42, btn_bit43, btn_bit44, btn_bit45, btn_bit46, btn_bit47, btn_bit48, btn_bit49, btn_bit50,
            btn_bit51, btn_bit52, btn_bit53, btn_bit54, btn_bit55, btn_bit56, btn_bit57, btn_bit58, btn_bit59, btn_bit60, btn_bit61,
            btn_bit62, btn_bit63;

    private ToggleButton[] binaryRepresentationButtons;

    @FXML
    public void initialize(){
        initializeBinaryRepresentationToggleButtons();
    }

    private void initializeBinaryRepresentationToggleButtons(){
        binaryRepresentationButtons = new ToggleButton[]{btn_bit0, btn_bit1, btn_bit2, btn_bit3, btn_bit4, btn_bit5, btn_bit6, btn_bit7, btn_bit8, btn_bit9, btn_bit10,
                btn_bit11, btn_bit12, btn_bit13, btn_bit14, btn_bit15, btn_bit16, btn_bit17, btn_bit18, btn_bit19, btn_bit20,
                btn_bit21, btn_bit22, btn_bit23, btn_bit24, btn_bit25, btn_bit26, btn_bit27, btn_bit28, btn_bit29, btn_bit30,
                btn_bit31, btn_bit32, btn_bit33, btn_bit34, btn_bit35, btn_bit36, btn_bit37, btn_bit38, btn_bit39, btn_bit40,
                btn_bit41, btn_bit42, btn_bit43, btn_bit44, btn_bit45, btn_bit46, btn_bit47, btn_bit48, btn_bit49, btn_bit50,
                btn_bit51, btn_bit52, btn_bit53, btn_bit54, btn_bit55, btn_bit56, btn_bit57, btn_bit58, btn_bit59, btn_bit60, btn_bit61,
                btn_bit62, btn_bit63};
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}