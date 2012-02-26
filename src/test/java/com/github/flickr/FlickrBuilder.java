package com.github.flickr;

import com.github.commons.Builder;
import org.scribe.model.Token;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * User: Wursteisen David
 * Date: 18/02/12
 * Time: 14:34
 */
public class FlickrBuilder extends Builder<Flickr> {


    public FlickrBuilder() {
        super("flickr.apikey", "flickr.secret");
    }

    @Override
    public Flickr build() {
        return new Flickr(getApiKey(), getSecret());
    }

    private static Token accessToken;
    public static Token getAccessToken() {
        if(accessToken == null) {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("flickr.token"));
                accessToken = (Token) in.readObject();
            } catch (IOException e) {
                throw new RuntimeException("Oups ! flickr token not found ! " +
                        "Start FlickrTest first to generate your oauth token");
            } catch (ClassNotFoundException e) {

                throw new RuntimeException("Oups ! flickr token seems to be invalid. Restart FlickrTest to " +
                        "regenerate your oauth token");
            }
        }
        return accessToken;
    }
}
