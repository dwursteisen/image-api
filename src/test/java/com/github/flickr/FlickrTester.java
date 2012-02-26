package com.github.flickr;

import com.github.flickr.api.test.LoginRequest;
import com.github.flickr.api.test.LoginResponse;
import org.scribe.model.Token;
import org.scribe.model.Verifier;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * User: Wursteisen David
 * Date: 23/02/12
 * Time: 21:46
 */
public class FlickrTester {

    private static final Flickr flickr = new FlickrBuilder().withApiKey().build();

    public void can_oauth_on_flick() throws IOException {
        final Token requestToken = flickr.getRequestToken();
        String url = flickr.getAuthorizationUrl(requestToken);


        final JTextField userInput = new JTextField(10);
        final JTextField response = new JTextField(50);

        JPanel authorization = new JPanel();
        authorization.add(new JLabel("Autorization Url:"));
        authorization.add(new JTextField(url));

        JButton buttonOk = new JButton("OK");

        JPanel userToken = new JPanel();
        userToken.add(new JLabel("Code:"));
        userToken.add(userInput);
        userToken.add(buttonOk);


        JPanel flickrResponse = new JPanel();
        flickrResponse.add(response);

        JFrame mainFrame = new JFrame("Oauth with Flickr");
        JPanel frame = new JPanel();
        frame.setLayout(new BoxLayout(frame, BoxLayout.PAGE_AXIS));
        frame.add(authorization);
        frame.add(userToken);
        frame.add(flickrResponse);

        mainFrame.setContentPane(frame);
        mainFrame.pack();


        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Verifier verifier = new Verifier(userInput.getText());
                Token accessToken = flickr.getAccessToken(requestToken, verifier);
                try {
                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("flickr.token"));
                    out.writeObject(accessToken);
                    out.close();

                    LoginResponse r = flickr.login().call(new LoginRequest(accessToken));
                    response.setText(r.toString());
                } catch (IOException e1) {
                    response.setText("Oups ! Got exception : " + e1);
                }
            }
        });

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(800, 200);
        mainFrame.setVisible(true);

    }

    public static void main(String[] args) throws IOException {
        new FlickrTester().can_oauth_on_flick();
    }
}
