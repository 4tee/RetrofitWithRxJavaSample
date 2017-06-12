# RetrofitWithRxJavaSample

Hi there, this is the sample android app that uses *Retrofit*, *Gson* and *RxJava Android* to show a list of countries from an open REST API from Open Air Quality website. Wait, if you are unfamiliar with Retrofit and Gson, go to this [Retrofit Sample](https://github.com/4tee/RetrofitSample) first to help you understand a little better. Recap: Retrofit is a library that offer very easy and faster way to use REST API.


## What should I know about RxJava?

RxJava is an Java libarary for ReactiveX, composing Async and Event-based program. What?? Basically, it runs async mode, so running in another thread. It can listen for events. The terms used in RxJava is Observables and Subscriber. Imagine it is a stream, like water flowing down from top to bottom. Your program is like watching the stream from a point. When something happened from the stream, bam!! you get notified and you can work on it. It is called Observer pattern.

## Where can I use it?
Everywhere. like do some action when the user clicks a button, or like save into the disk when the network receives data. But is it necessary? No. But in some cases, it is helpful for you, and use it wisely. In this code sample, we process data when we get data from REST API. You can do it with your own async task, but we do it in Rx way!!!

## How?

Add this into the ```build.gradle```:
```
// Rx
compile 'io.reactivex.rxjava2:rxandroid:2.0.0'
compile 'com.squareup.retrofit2:adapter-rxjava2:2.2.0'
```

## Credit
I am using a free web REST API call to demo this. It doesn't require any authentication at the moment.
https://api.openaq.org/v1/countries It is an API for open air quality data.
