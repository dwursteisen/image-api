package com.github.flickr.api.test;


import com.google.gson.Gson;
import org.junit.Test;

public class EchoResponseTest {

    @Test
    public void can_parse_response() {

        StringBuffer jsonResponse = new StringBuffer();
        jsonResponse.append("{");
        jsonResponse.append("\"method\": { \"_content\":\"flickr.test.echo\" },");
        jsonResponse.append("\"name\":{\"_content\":\"value\"},");
        jsonResponse.append("\"api_key\":{\"_content\":\"------------------\"},");
        jsonResponse.append("\"format\":{\"_content\":\"json\"},");
        jsonResponse.append("\"stat\":\"ok\"");
        jsonResponse.append("}");

        Gson gson = new Gson();
        gson.fromJson(jsonResponse.toString(), EchoResponse.class);
    }
}
