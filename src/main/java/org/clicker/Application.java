package org.clicker;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.clicker.config.Config;
import org.clicker.ui.view.MainView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Lazy
@ComponentScan
@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.clicker.repository")
public class Application extends AbstractJavaFxApplicationSupport{

    @Value("${ui.title:Планировщик}")//
    private String windowTitle;

    @Autowired
    private MainView view;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle(windowTitle);
        stage.setScene(new Scene(view.getView()));
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launchApp(Application.class, args);
    }

}
