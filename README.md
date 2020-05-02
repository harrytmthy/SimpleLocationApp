# SimpleLocationApp

## Table of Contents
* [Introduction](#introduction)
* [Project Scope](#project-scope)
* [Architecture](#architecture)
* [Technologies](#technologies)

## Introduction
&nbsp;
[![Screenshot-1588411788.png](https://i.postimg.cc/nr8BKsyv/Screenshot-1588411788.png)](https://postimg.cc/mzwPBr2D)&nbsp; &nbsp; [![Screenshot-1588411575.png](https://i.postimg.cc/g0JVGby6/Screenshot-1588411575.png)](https://postimg.cc/cvpgcjbs)

SimpleLocationApp is a demo app to show **A Clean Approach  to Request Location Updates using ReactiveX + Dagger 2**, which we use in DANA.

## Project Scope
The main goal of this project is create a simple app, which displays location data for demo purpose, just to show the clean approach we use in DANA. Therefore, the project scope is limited to the following functionality:
* **Requesting Location Permission**
* **Requesting Location Data**: Latitude & Longitude
* **Cache Location Data**
* **Load Cached Location**
* **Display Location Data to a TextView**

## Architecture
[![image.png](https://i.postimg.cc/sx34WGdv/image.png)](https://postimg.cc/FdnS5RK4)


**Clean Architecture** is used to create this app, where the project is separated into three different modules: **Data**, **Domain**, and **App (Presentation)** to match Clean Architecture design. This project uses MVP as modular architecture which affects only Presentation layer.

## Technologies
SimpleLocationApp is created using:
* **IDE**: Android Studio 3.6.3
* **Language**: Kotlin 1.3
* **Dependency Injenction**: Dagger 2
* **Async**: RxJava + RxAndroid
* **Logger**: Timber