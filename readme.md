# 🏦 Bank Account REST API

A RESTful Bank Account Management API built using **Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL**.

This project focuses on building REST APIs with a layered architecture and implementing real-world banking operations such as **deposit, withdrawal, and money transfer**.

## 🚀 Features
 
* Create a bank account 
* View all accounts
* View account by ID
* Delete an account
* Deposit money
* Withdraw money
* Transfer money between accounts
* Balance validation
* Positive amount validation
* MySQL database persistence
* REST API testing with Postman

## 🛠️ Technologies Used

* **Java**
* **Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **Hibernate**
* **MySQL**
* **Maven**
* **Postman**
* **IntelliJ IDEA**

## 🏗️ Project Architecture

```text
Controller
     ↓
Service
     ↓
DAO / Repository
     ↓
MySQL Database
```

### Layers

**Controller**

* Handles HTTP requests
* Maps REST endpoints
* Receives request data

**Service**

* Contains banking business logic
* Handles deposit, withdrawal and transfer operations
* Performs balance and amount validation

**DAO / Repository**

* Uses Spring Data JPA
* Handles database operations

**Model**

* Represents the Bank Account entity
* Maps account data to the MySQL table

## 📋 Account Fields

| Field         | Type    | Description             |
| ------------- | ------- | ----------------------- |
| id            | Integer | Unique account ID       |
| accountNumber | String  | Bank account number     |
| holderName    | String  | Account holder name     |
| email         | String  | Account holder email    |
| balance       | Double  | Current account balance |
| accountType   | String  | Savings / Current       |

## 🌐 API Endpoints

| Method | Endpoint                                     | Description          |
| ------ | -------------------------------------------- | -------------------- |
| GET    | `/accounts`                                  | Get all accounts     |
| GET    | `/accounts/{id}`                             | Get account by ID    |
| POST   | `/accounts`                                  | Create a new account |
| DELETE | `/accounts/{id}`                             | Delete an account    |
| PUT    | `/accounts/{id}/deposit?amount=5000`         | Deposit money        |
| PUT    | `/accounts/{id}/withdraw?amount=2000`        | Withdraw money       |
| PUT    | `/accounts/transfer?from=1&to=2&amount=3000` | Transfer money       |

## 💰 Banking Rules

### Deposit

* Account must exist
* Deposit amount must be greater than `0`

### Withdrawal

* Account must exist
* Amount must be greater than `0`
* Account must have sufficient balance
* Balance can become `0`

### Transfer

* Sender account must exist
* Receiver account must exist
* Transfer amount must be greater than `0`
* Sender must have sufficient balance
* Sender balance is reduced
* Receiver balance is increased

## 🧪 Testing

API endpoints can be tested using **Postman**.

Example transfer:

```text
PUT /accounts/transfer?from=1&to=2&amount=3000
```

Before:

```text
Account 1 → ₹10,000
Account 2 → ₹5,000
```

After transferring ₹3,000:

```text
Account 1 → ₹7,000
Account 2 → ₹8,000
```

## ⚙️ Database Configuration

Create a MySQL database and configure the database connection in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bank_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## ▶️ How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA or Eclipse.
3. Configure your MySQL database.
4. Update `application.properties`.
5. Install Maven dependencies.
6. Run the Spring Boot application.
7. Open Postman.
8. Test the REST API endpoints.

## 📚 What I Learned

Through this project, I practiced:

* Spring Boot REST API development
* Layered architecture
* Spring Data JPA
* Hibernate
* CRUD operations
* `Optional`
* REST request parameters
* Business logic in the Service layer
* Database integration
* Money transfer logic
* API testing with Postman

## 🎯 Future Improvements

* Add Spring Security
* Add JWT authentication
* Add proper HTTP response status codes
* Add global exception handling
* Add transaction management using `@Transactional`
* Add account validation
* Add transaction history
* Add JUnit and Mockito tests

---

### 👨‍💻 Author

**Arunkumar S**

Aspiring Java Full Stack Developer 🚀

**Tech Focus:** Java • Spring Boot • React • MySQL
