Image Api
=========

What is the main purpose of this library ?
------------
Image API is here to provide an easy access to image web service like imgur, flickr, etc.
You'll be able to get data from webservice, as you'll be able to push data like your last picture, ...

How to use it ?
---------------
Add Image API into your classpath, then simply create the service object of your need (img ur, flickr, ...)
as the example just bellow

    Flickr flickrProvider = new Flickr("YOUR API KEY");

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

How to get it ?
---------------
Grap it into the [download section](http://github.com/dwursteisen/imgur-API/downloads)

How to compile it ?
-------------------
Create a property file into 'src/test/resources' directory named secret.properties with this bellowed content.
This file is only used for the testing phase of packaging.

    flickr.apikey = YOUR_FLICKR_API_KEY

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
