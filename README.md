# Costume Rental Management System

## Project Overview

The Costume Rental Management System is a comprehensive desktop application developed using **Java Swing** for the frontend and **MySQL** for persistent data storage. It is designed to modernize and manage all core operations of a costume rental business, including inventory control, client management, booking transactions, and statistical reporting.

This project is built following the **Data Access Object (DAO) pattern** to ensure a clear separation of concerns, improve code modularity, and facilitate maintainability and future upgrades.

## Key Features

* **Secure Authentication:** User login screen with role-based access control for administrators and staff.
* **Costume Inventory Management:** CRUD (Create, Read, Update, Delete) operations for costume records, including detailed information such as rental price, quantity, and status.
* **Booking and Transaction System:**
    * Create and manage rental (Borrow) tickets.
    * Process costume returns, including calculation of late penalties (if applicable).
    * Generate financial invoices for completed transactions.
* **Client Management:** Maintain a database of clients, tracking their contact information and rental history.
* **Statistical Reporting:**
    * Generate reports on revenue statistics over selected time periods.
    * Identify the most frequently rented costumes (Costume Statistics).
    * Provide detailed transaction history drill-down capability.

## Technology Stack

| Category | Technology | Description |
| :--- | :--- | :--- |
| **Language** | Java | Core programming language (JDK 8+ recommended). |
| **GUI Framework** | Java Swing / AWT | Used for building the desktop user interface. |
| **Database** | MySQL | Relational database management system. |
| **Connectivity** | JDBC (MySQL Connector) | Java Database Connectivity for communication with MySQL. |
| **Testing** | JUnit 4 | Used for implementing unit tests for DAO and business logic. |
| **Architecture** | MVC / DAO Pattern | Design pattern for structuring the application logic. |

## Project Structure

The project follows a standard Java package structure:

* `model`: Contains Plain Old Java Objects (POJOs) representing the database entities (e.g., `Costume`, `Client`, `BorrowTicket`, `User`).
* `dao`: Implements the Data Access Objects, which handle all database interactions and SQL queries (e.g., `CostumeStatDAO`, `UserDAO`).
* `view`: Contains all Java Swing form classes (`.java` files) that make up the graphical user interface (e.g., `LoginFrm`, `ManagerHomeFrm`).
* `test`: Holds unit testing classes (e.g., `CostumeDaoTest`).
* `config`: Stores external libraries (JARs) required for compilation and runtime.

## Installation and Setup

### Prerequisites

1.  **Java Development Kit (JDK):** Version 8 or higher.
2.  **MySQL Server:** Version 8.0 or compatible.
3.  **Integrated Development Environment (IDE):** IntelliJ IDEA, Eclipse, or NetBeans.

### 1. Database Configuration

1.  Start your local MySQL server instance.
2.  Open a database management tool (e.g., MySQL Workbench, DBeaver, or command line).
3.  Create a new database schema, for example: `costume_rental_db`.
4.  Import the provided SQL script to initialize the necessary tables and populate sample data:
    * File location: `./all db and structure.sql`
5.  **Update Connection Details:** Locate the core DAO class (e.g., `dao/DAO.java`) and update the database connection string, username, and password to match your local MySQL configuration:

    ```java
    // Example: Update the connection details in DAO.java
    private static final String DB_URL = "jdbc:mysql://localhost:3306/costume_rental_db";
    private static final String USER = "your_mysql_username";
    private static final String PASS = "your_mysql_password";
    ```

### 2. Dependency Setup

The project requires the following external libraries (JAR files), which are located in the `config` folder:

* `config/mysql_jdbc/mysql-connector-java-8.0.30.jar`
* `config/Junit/junit-4.13.2.jar`
* `config/Junit/hamcrest-core-1.3.jar`

**In your IDE (e.g., IntelliJ IDEA):**
1.  Go to **Project Structure** > **Modules** > **Dependencies**.
2.  Add the three `.jar` files listed above to the project's classpath.

## Running the Application

1.  Ensure all dependencies are correctly added and the database is running.
2.  Navigate to the entry point of the application: `view/user/LoginFrm.java`.
3.  Run the `main` method of the `LoginFrm` class.
4.  The application's login screen will appear. Use the credentials defined in the `tblUser` table of your imported database for initial access.

## Unit Testing

Unit tests are provided to verify the core business and data logic.

1.  Navigate to the `test/unit` package.
2.  Right-click on `CostumeDaoTest.java` (or the entire `test` package).
3.  Select **Run Tests**. All tests should pass if the database connection is correctly configured.
