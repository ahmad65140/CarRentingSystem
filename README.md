# CarRentingSystem

Golden Car Rental System

Project Description

This is a Java-based desktop application for managing a car rental system. It allows users to rent and return cars (including normal cars and buses), add new vehicles to the fleet, view available cars, and check transaction history within specified date ranges. The application features a graphical user interface (GUI) built with Swing.

Features

• Car Management: Add new normal cars and buses with details like name, color, ID, chassis number, regular renting price, maximum allowed rentals, and specific attributes (max rent duration and discount for normal cars, capacity for buses).
• Car Rental: Rent available cars to clients, capturing client details (name, SNN, phone number, address).
• Car Return: Mark rented cars as returned.
• View Available Cars: Display a list of all cars in the fleet, showing their availability and other relevant details.
• Transaction History: View rental transactions between two specified dates.
• Data Persistence: Car data is saved to and loaded from a Car.dat file, ensuring data is not lost upon application closure.
• User-Friendly GUI: Intuitive interface for easy navigation and operation.


How to Run

1.Prerequisites:
    • Java Development Kit (JDK) 8 or higher.
    • Apache Maven (for building the project).
2. Clone the repository:
3. Build the project using Maven:
4. Run the application:


Project Structure

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


Class Descriptions

• OopProjectCarRent.java: The main application class, responsible for the GUI, event handling, and overall application flow.
• Car.java: An abstract base class for all vehicles, defining common properties and behaviors (e.g., name, color, ID, rentCar(), returnCar()). Implements Comparable for sorting by dateOfOwning and Serializable for persistence.
• NormalCar.java: Extends Car, representing a standard car with additional properties like maxRentDuration and discount. Overrides calculatePrice() to include discount logic.
• Bus.java: Extends Car, representing a bus with a capacity property. Overrides calculatePrice() based on capacity.
• Client.java: Represents a client with properties like name, SNN (Social Security Number), phoneNumber, and address.
• RentTransaction.java: Represents a rental transaction, linking a Car and a Client with a transactionDate.



Usage

Upon launching the application, you will be presented with the main menu. From there, you can navigate to different sections:

• Rent a car: Enter client details and select an available car to rent.
• Return a car: Select a currently rented car to mark it as returned.
• Add a car: Choose to add either a 'Normal Car' or a 'Bus' and provide the required details.
• See cars: View a comprehensive list of all cars in the system.
• Check history: Enter a date range to view all transactions that occurred within that period.


Persistence

The application uses Java's built-in serialization to save and load ArrayList<Car> objects to/from Car.dat file. This ensures that the car fleet and their associated transaction histories are preserved across application sessions.

Contributing
Contributions are welcome! Please fork the repository and create a pull request with your changes. For major changes, please open an issue first to discuss what you would like to change.

Contributions are welcome! Please fork the repository and create a pull request with your changes. For major changes, please open an issue first to discuss what you would like to change.

