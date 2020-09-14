/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxjourney;

import com.codebrig.journey.JourneyBrowserView;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import java.awt.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import org.ini4j.*;

/**
 *
 * @author vikas
 */
public class FxJourney extends Application {

    public static void main(String[] args) throws IOException {
        Ini aRead;
        String url;

        aRead = new Ini();
        aRead.load(new FileReader("Url.ini"));
        url = aRead.get("section", "url", String.class);

        ImageIcon img = new ImageIcon("Image/House.jpg");
        JourneyBrowserView browser = new JourneyBrowserView(url);
        JFrame frame = new JFrame();
        frame.getContentPane().add(browser, BorderLayout.CENTER);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                browser.getCefApp().dispose();
                frame.dispose();
            }
        });
        frame.setTitle("GWPL POS");
        frame.setSize(1000, 600);
        frame.setVisible(true);
        frame.setIconImage(img.getImage());
        //frame.setFont(new Font("Calabri",Font.ITALIC, 36));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
