Image Api [![Build Status](https://buildhive.cloudbees.com/job/dwursteisen/job/image-api/badge/icon)](https://buildhive.cloudbees.com/job/dwursteisen/job/image-api/)
=========

What is the main purpose of this library ?
------------
Image API is here to provide an easy access to image web service like imgur, flickr, facebook, etc.
You'll be able to get data from webservice, as you'll be able to push data like your last picture, ...

What image web service is now supported ?
-----
Today, you can make request for: [imgur](http://api.imgur.com/), [flickr](http://www.flickr.com/services/api/) and
[facebook](https://developers.facebook.com/)

How to use it ?
---------------
Add Image API into your classpath, then simply create the service object of your need (imgur, flickr, facebook, ...)
as the example just bellow

### With Flickr
    Flickr flickrProvider = new Flickr("YOUR API KEY", "YOUR API SECRET");

Then, just call  Flickr with a request, and you'll get a response !

    flickrProvider.call(new EchoRequest());

If your request need parameters, just configure it with the request (ie : myRequest.setMyParameter());

    EchoRequest request = new EchoRequest();
    request.setTestParameter("My Test Parameter");
    EchoResponse response = flickrProvider.call(request);

The response will represent the response from the web service.
So, for this [echo method](http://www.flickr.com/services/api/flickr.test.echo.html), you'll be able to check
the flickr status with the stat field.

    System.out.println(response.getStat()); // will print ok

### With ImgUr
If you want to use the anonymous api:

    ImgUr imgurProvider = new ImgUr("YOUR ANONYMOUS API KEY");

If you want to use the authenticated api (with oauth):

    ImgUr imgurProvider = new ImgUr("YOUR API KEY", "YOUR API SECRET");

then you can call imgur like this :

    ImageResponse response = imgurProvider.call(new ImageRequest("An imgur image hashcode"));

or like this for an authenticated resources :

    AccountResponse = imgurProvider.call(new AccountRequest(yourAccessToken));

How to use the authentication based on oauth ?
--------
Image api use [scribe](https://github.com/fernandezpablo85/scribe-java) for oauth support.
Just call methods on your provider as the [oauth protocol](http://www.flickr.com/services/api/auth.oauth.html) describe it.
You haven't need to create any OAuthService as seen in [scribe](https://github.com/fernandezpablo85/scribe-java) documention, Image api will do it for you !

    Token requestToken = imgur.getRequestToken();
    String url = imgur.getAuthorizationUrl(requestToken); // redirect your user on this url
    [...]
    Verifier verifier = new Verifier(userCode); // code given by imgur
    Token accessToken = imgur.getAccessToken(requestToken, verifier); // use this token with authenticated request

How to get it ?
---------------
If you use maven (or other dependency management like ivy/graddle/sbt), just add image-api as a dependency

            <dependency>
                <groupId>com.github.dwursteisen</groupId>
                <artifactId>image-api</artifactId>
                <version>1.0-SNAPSHOT</version>
            </dependency>

Because it's currently hosted on sonatype oss repository, please add this snapshot repository into your maven project :

        <repositories>
            <repository>
                <id>sonatype-snapshot</id>
                <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
            </repository>
        </repositories>



Got an issue?
--------------
Just fill an [issue](https://github.com/dwursteisen/imgur-API/issues) with your use case (service used, request, response received, response expected, ...)
