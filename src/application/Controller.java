package application;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.InetAddress;

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
}
