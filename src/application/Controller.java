package application;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;

public class Controller {

    @FXML
    private TextField textField;
    @FXML
    private Label ipLabel;
    @FXML
    private Hyperlink hostLink;
    @FXML
    private Label hostLabel;

    @FXML
    public void onButtonPressed() { //Performs when the button is pressed
        String url = textField.getText();
        try {
            InetAddress inetAddress=InetAddress.getByName(url);
            String hostName=inetAddress.getHostName();
            String hostIP=inetAddress.getHostAddress();
            hostLink.setText(hostName);
            hostLabel.setText("Host: ");
            ipLabel.setText("Host IP: "+hostIP);

        }catch (Exception e) {
            hostLink.setText("");
            hostLabel.setText("");
            ipLabel.setText("Error Occurred!!");
        }//end of try/catch
    }

    @FXML
    public void onClicked() { //Performs when the link is clicked: opens in a browser
        try {
            URI uri = new URI(hostLink.getText());
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            if (desktop != null)
                desktop.browse(uri);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (URISyntaxException use) {
            use.printStackTrace();
        }//end of try/catch
    }
}
