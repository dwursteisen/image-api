package com.github.imgur;

import com.github.imgur.api.account.AccountRequest;
import com.github.imgur.api.account.AccountResponse;
import com.github.imgur.api.upload.UploadRequest;
import com.github.imgur.api.upload.UploadResponse;
import org.scribe.model.Token;
import org.scribe.model.Verifier;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

/**
 * User: Wursteisen David
 * Date: 23/02/12
 * Time: 21:46
 */
public class ImgurTester {

    private static final ImgUr imgur = new ImgUrBuilder().withApiKey().build();

    public void can_oauth() throws IOException {
        final Token requestToken = imgur.getRequestToken();
        String url = imgur.getAuthorizationUrl(requestToken);


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


        JPanel serviceResponse = new JPanel();
        serviceResponse.add(response);

        JFrame mainFrame = new JFrame("Oauth with imgur");
        JPanel frame = new JPanel();
        frame.setLayout(new BoxLayout(frame, BoxLayout.PAGE_AXIS));
        frame.add(authorization);
        frame.add(userToken);
        frame.add(serviceResponse);

        mainFrame.setContentPane(frame);
        mainFrame.pack();


        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Verifier verifier = new Verifier(userInput.getText());
                Token accessToken = imgur.getAccessToken(requestToken, verifier);
                try {
                    URL imageUrl = new URL("http://i.imgur.com/jxGar.jpg");

                    UploadRequest.Builder builder = new UploadRequest.Builder();
                    UploadRequest request = builder.withImageUrl(imageUrl)
                                            .withAccessToken(accessToken).build();

                    UploadResponse r = imgur.upload().call(request);

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
        new ImgurTester().can_oauth();
    }
}
