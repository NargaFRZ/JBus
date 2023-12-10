# JBus - Bus Booking System

## Overview
JBus is a comprehensive bus booking system that allows users to book bus tickets, manage schedules, and even register as bus renters. It is backed by a robust backend system which stores data in JSON format and a corresponding Android app for a user-friendly interface.

## Features
- **Bus Booking**: Users can search for buses based on names or destination/arrival stations and book tickets.
- **Renter Registration**: Users have the option to register as a renter and manage their own fleet of buses.
- **Schedule Management**: Users can view and manage bus schedules.
- **Data Persistence**: Account, bus, payment, and station data are persistently stored in JSON format.

## Backend Structure
The backend codebase consists of several Java classes, including:

- **Models**: Define the structure of objects such as `Bus`, `Account`, `Payment`, and `Station`.
- **Controllers**: Handle incoming HTTP requests and respond with the appropriate JSON data.
- **Utilities**: Include helper classes such as `Algorithm` for common operations on collections and `Serializable` for object serialization.
- **Database JSON Files**: JSON files for storing persistent data, including `accounts.json`, `buses.json`, `payment.json`, and `station.json`.

## Controllers
The backend controllers include:

- **AccountController**: Manages user registration, login, and renter registration.
- **BusController**: Handles bus creation, schedule addition, and retrieving bus details.
- **PaymentController**: Processes payments and booking requests.
- **StationController**: Manages station details and creation.

## Database JSON Files
Data is stored in the following JSON files:

- `accounts.json` - Stores user account information.
- `buses.json` - Contains details of all buses.
- `payment.json` - Records payment transactions.
- `station.json` - Holds information about stations.

## Usage
To use the system, compile and run the `JBus.java` as the entry point. The Android app can be installed and run on an Android device to interact with the system.

## Development
The project is structured to allow for easy expansion and integration of additional features. This was also a part of my final project for Object Oriented Programming class in University.
