Image Api
=========

What is the main purpose of this library ?
------------
Image API is here to provide an easy access to image web service like imgur, flickr, etc.
You'll be able to get data from webservice, as you'll be able to push data like your last picture, ...

What image web service is now supported ?
-----
Today, you can make request for: [imgur](http://api.imgur.com/) and [flickr](http://www.flickr.com/services/api/)

How to use it ?
---------------
Add Image API into your classpath, then simply create the service object of your need (img ur, flickr, ...)
as the example just bellow

### With Flickr
    Flickr flickrProvider = new Flickr("YOUR API KEY", "YOUR API SECRET");

Then, just call a method from the Flickr API with a request, and you'll get a response from flickr !

    flickrProvider.echo().call(new EchoRequest());

If your request need parameters, just configure it with the request (ie : myRequest.setMyParameter());

    EchoRequest request = new EchoRequest();
    request.setTestParameter("My Test Parameter");
    EchoResponse response = flickrProvider.echo().call(request);

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

    ImageResponse response = imgurProvider.image().call(new ImageRequest("An imgur image hashcode"));

or like this for an authenticated resources :

    AccountResponse = imgurProvider.account().call(new AccountRequest(yourAccessToken));

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
Grap it into the [download section](http://github.com/dwursteisen/imgur-API/downloads)

How to compile it ?
-------------------
Create a property file into 'src/test/resources' directory named secret.properties with this bellowed content.
This file is only used for the testing phase of packaging.

    flickr.apikey = YOUR_FLICKR_API_KEY
    flickr.secret = YOUR_FLICKR_SECRET
    imgur.apikey = YOUR_IMGUR_API_KEY
    imgur.secret = YOUR_IMGUR_SECRET
    imgur.anonymous.apikey = YOUR_IMGUR_ANONYMOUS_API_KEY

 Compile it with maven

    mvn install

the jar will be avaible into the target directory.

How to *just* compile it ?
--------------------------
Skip tests !

    mvn install -Dmaven.test.skip=true

Got an issue?
--------------
Just fill an [issue](https://github.com/dwursteisen/imgur-API/issues) with your use case (service used, request, response received, response expected, ...)

Image api dependencies:
----

    imgur-api:imgur-api:jar:1.0-SNAPSHOT
    +- com.google.code.gson:gson:jar:2.1:compile
    +- org.scribe:scribe:jar:1.3.1-SNAPSHOT:compile
    |  \- commons-codec:commons-codec:jar:1.4:compile
    +- junit:junit:jar:4.8.2:compile
    +- commons-lang:commons-lang:jar:2.6:test
    +- org.mockito:mockito-all:jar:1.9.0:test
    +- commons-io:commons-io:jar:2.1:compile
    \- log4j:log4j:jar:1.2.16:compile
