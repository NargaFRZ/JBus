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

-`Account.java` Represents user accounts within the system. 

-`BaseResponse.java` A generic class used to structure the response returned from the server. 

-`Bus.java` Encapsulates all details related to a bus, such as its name, type, capacity, and associated facilities

-`BusType.java` An enumeration that defines the various types of buses available.

-`City.java` An enumeration of cities or a class that represents a city where the buses operate.

`Facility.java` An enumeration or a class that represents the different amenities or services provided on the bus.

-`Invoice.java` Represents an invoice generated for a transaction, possibly containing details like invoice ID, buyer and renter information, status, and timestamp.

-`Payment.java` Describes a payment transaction, including details such as the amount, payment status, and associated booking details.

-`Predicate.java` An interface that represents a condition or expression that can be true or false based on the provided object. Used for filtering or matching objects.

-`Price.java` Manages pricing information.

-`Rating.java` Manages ratings given by users or customers.

-`Renter.java` Represents entities (users or companies) that rent out buses, including their details such as name, contact information, and a list of buses they offer.

-`Review.java` Represents customer reviews, including the date of the review, its content, and the associated rating.

-`Schedule.java` Details of a bus's schedule, including departure times and seat availability. Methods may include scheduling operations and conflict resolution.

-`Station.java` Represents a physical bus station, with properties like its name, location, and the city it's associated with.

-`Type.java` Likely an enumeration that categorizes different types or categories within the system, such as ticket types, user roles, etc.

-`Validate.java` A utility class containing methods to validate various inputs or data against predefined rules or patterns.

-`Voucher.java` Represents vouchers that may be used in the system, containing information such as voucher code, type, applicable discount or rebate, and validity status.

## Usage
To use the system, compile and run the `JBus.java` as the entry point. The Android app can be installed and run on an Android device to interact with the system.

## Development
The project is structured to allow for easy expansion and integration of additional features. This was also a part of my final project for Object Oriented Programming class in University.
