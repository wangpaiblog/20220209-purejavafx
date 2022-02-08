package org.wangpai.demo.purejavafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class MainFace implements Initializable {
    private static MainFace mainFace;

    @FXML
    private TextArea output;

    @FXML
    private TextArea input;

    @FXML
    public void onActionSend(ActionEvent event) {
        var msg = this.input.getText();
        System.out.println(msg);
        this.output.setText(msg);
        this.input.requestFocus();
        this.input.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainFace = this;
    }

    public static void afterUiShow(String msg) {
        mainFace.input.requestFocus();
        mainFace.output.setText(msg);
    }
}