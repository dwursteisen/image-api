Image Api
=========

To do what ?
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


Got an issue ?
--------------
Just fill an [issue](https://github.com/dwursteisen/imgur-API/issues) with your use case (service used, request, response received, response expected, ...)
