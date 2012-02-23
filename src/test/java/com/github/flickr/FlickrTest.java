package com.github.flickr;

import com.github.flickr.api.test.LoginRequest;
import com.github.flickr.api.test.LoginResponse;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.scribe.model.Token;
import org.scribe.model.Verifier;

import java.io.IOException;
import java.util.Scanner;

/**
 * User: Wursteisen David
 * Date: 23/02/12
 * Time: 21:46
 */
public class FlickrTest {

    private static final Flickr flickr = new FlickrBuilder().withApiKey().build();

    @Ignore("Not so easy to test it !")
    @Test
    public void can_oauth_on_flick() throws IOException {
        Token requestToken = flickr.getRequestToken();
        String url = flickr.getAuthorizationUrl(requestToken);
        System.out.println("Authorization url : "+url);
        System.out.println("Please paste verification token bellow : ");
        
        String token = "CHANGE IT WITH DEBUGGUER";
        
        Verifier verifier = new Verifier(token);
        Token accessToken = flickr.getAccessToken(requestToken, verifier);
        LoginResponse response = flickr.login().call(new LoginRequest(accessToken));
        System.out.println("Flickr response : "+response);
    }
}
