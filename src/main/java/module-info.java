module org.wangpai.demo.fxmlapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.wangpai.demo.purejavafx to javafx.fxml;

    exports org.wangpai.demo.purejavafx;
}