package org.wangpai.demo.purejavafx;

import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.geometry.Pos.BOTTOM_RIGHT;
import static javafx.geometry.Pos.CENTER;

public class App extends Application {
    /**
     * 程序运行开始时间（单位：ms）
     *
     * @since 2021-9-28
     */
    public static final long START_TIME = System.currentTimeMillis();

    @Override
    public void start(Stage stage) throws IOException {
        var output = new TextArea();
        output.setPrefSize(200, 200);
        output.setEditable(false);
        output.setWrapText(true);

        var input = new TextArea();
        input.setPrefSize(200, 200);
        input.setWrapText(true);

        var send = new Button("发送(S)");
        send.setOnAction(event -> {
            var msg = input.getText();
            System.out.println(msg);
            output.setText(msg);
            input.requestFocus();
            input.clear();
        });

        var sendVbox = new VBox(send);
        sendVbox.setPrefSize(200, 0);
        sendVbox.setAlignment(BOTTOM_RIGHT);

        var vbox = new VBox(20, output, input, sendVbox);
        vbox.getStylesheets().add(App.class.getResource("/org/wangpai/demo/purejavafx/MainFace.css").toExternalForm());
        vbox.setAlignment(CENTER);
        vbox.setPrefSize(500, 500);
        vbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox, 500, 500);
        stage.setTitle("javafx without fxml");
        stage.setScene(scene);
        stage.show();

        output.setText("应用启动用时：" + (System.currentTimeMillis() - START_TIME) / 1000.0 + "s");
        input.requestFocus();
    }

    public static void main(String[] args) {
        launch();
    }
}