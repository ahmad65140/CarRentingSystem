# Car Renting System 🚗💨

![Golden Car Rental System](https://via.placeholder.com/150) <!-- Consider adding a logo/banner here -->

## Project Description

This is a Java-based desktop application for managing a car rental system. It allows users to rent and return cars (including normal cars and buses), add new vehicles to the fleet, view available cars, and check transaction history within specified date ranges. The application features a graphical user interface (GUI) built with Swing.

## Features ✨

- **Car Management**: Add new normal cars and buses with details like:
  - Name, color, ID, chassis number
  - Regular renting price
  - Maximum allowed rentals
  - Specific attributes (max rent duration and discount for normal cars, capacity for buses)

- **Car Rental**: Rent available cars to clients, capturing:
  - Client details (name, SNN, phone number, address)

- **Car Return**: Mark rented cars as returned

- **View Available Cars**: Display a list of all cars in the fleet with availability status

- **Transaction History**: View rental transactions between specified dates

- **Data Persistence**: Car data is saved to and loaded from `Car.dat` file

- **User-Friendly GUI**: Intuitive Swing interface for easy navigation

## How to Run ▶️

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Apache Maven (for building the project)

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/CarRentingSystem.git
Build the project using Maven:

bash
mvn clean install
Run the application:

bash
java -jar target/your-application.jar
Project Structure 📂
text
oopProjectCarRent/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── mycompany/
│   │               └── oopprojectcarrent/
│   │                   ├── Bus.java
│   │                   ├── Car.java
│   │                   ├── Client.java
│   │                   ├── NormalCar.java
│   │                   ├── OopProjectCarRent.java
│   │                   └── RentTransaction.java
│   └── test/
│       └── java/
└── Car.dat (generated after first run)
Class Descriptions 🧩
Class	Description
OopProjectCarRent.java	Main application class with GUI and event handling
Car.java	Abstract base class for all vehicles (implements Comparable and Serializable)
NormalCar.java	Extends Car with maxRentDuration and discount properties
Bus.java	Extends Car with capacity property
Client.java	Represents a client with personal details
RentTransaction.java	Represents a rental transaction between Car and Client
Usage 🖥️
Upon launching, you'll see the main menu with these options:

Rent a car:

Enter client details

Select available car

Return a car:

Select rented car to mark as returned

Add a car:

Choose 'Normal Car' or 'Bus'

Provide required details

See cars:

View comprehensive car list

Check history:

Enter date range to view transactions

Persistence 💾
The application uses Java serialization to save/load ArrayList<Car> objects to/from Car.dat, preserving car fleet data and transaction histories across sessions.

Contributing 🤝
Contributions are welcome! Please:

Fork the repository

Create your feature branch (git checkout -b feature/AmazingFeature)

Commit your changes (git commit -m 'Add some AmazingFeature')

Push to the branch (git push origin feature/AmazingFeature)

Open a Pull Request
