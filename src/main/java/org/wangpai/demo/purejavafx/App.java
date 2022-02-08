package org.wangpai.demo.purejavafx;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    /**
     * 程序运行开始时间（单位：ms）
     *
     * @since 2021-9-28
     */
    public static final long START_TIME = System.currentTimeMillis();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("MainFace.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("javafx with fxml");
        stage.setScene(scene);
        stage.show();

        MainFace.afterUiShow("应用启动用时：" + (System.currentTimeMillis() - START_TIME) / 1000.0 + "s");
    }

    public static void main(String[] args) {
        launch();
    }
}