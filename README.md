# UberApp (Spring Boot Uber Clone)

A full-stack Uber-like ride-hailing application built with Spring Boot. This project demonstrates a scalable backend for a ride-sharing platform, including user authentication, ride management, driver/rider roles, payments, and more.

## Features
- User authentication and signup (riders & drivers)
- Requesting and matching rides
- Driver and rider profiles
- Ride management (accept, start, end, cancel)
- Ratings for drivers and riders
- Payment and wallet management
- Surge pricing and driver-matching strategies
- PostgreSQL database integration

## Tech Stack
- **Java 22**
- **Spring Boot 3.3.2**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Maven**

## Project Structure
```
uberApp/
├── src/
│   ├── main/
│   │   ├── java/com/anurag/project/uber/uberApp/
│   │   │   ├── controllers/   # REST API controllers
│   │   │   ├── services/      # Business logic (interfaces & implementations)
│   │   │   ├── entities/      # JPA Entities
│   │   │   ├── repositories/  # Spring Data Repositories
│   │   │   ├── dto/           # Data Transfer Objects
│   │   │   ├── strategies/    # Matching & pricing strategies
│   │   │   ├── advices/       # Exception handling
│   │   │   ├── configs/       # Configuration classes
│   │   │   ├── utils/         # Utility classes
│   │   │   └── UberAppApplication.java # Main entry point
│   │   ├── resources/
│   │   │   ├── application.properties  # App configuration
│   │   │   ├── data.sql               # DB seed data
│   │   │   ├── static/                # Static resources
│   │   │   └── templates/             # Templates (if any)
│   └── test/                          # Tests
├── pom.xml                            # Maven build file
└── README.md
```

## Getting Started

### Prerequisites
- Java 22+
- Maven
- PostgreSQL (running on `localhost:5432` with a `postgres` database, user: `anurag`, password: `anu123` by default)

### Setup & Run
1. **Clone the repository:**
   ```bash
   git clone <your-repo-url>
   cd uberApp
   ```
2. **Configure the database:**
   - Update `src/main/resources/application.properties` if your DB credentials differ.
3. **Build the project:**
   ```bash
   mvn clean install
   ```
4. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```
5. **API Usage:**
   - Main endpoints:
     - `/auth/signup` — User registration
     - `/riders/requestRide` — Rider requests a ride
     - `/drivers/acceptRide/{rideRequestId}` — Driver accepts ride
     - `/drivers/startRide/{rideRequestId}` — Driver starts ride
     - ...and more (see controllers for details)

## Testing
- Run tests with:
  ```bash
  mvn test
  ```

## Contributing
Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

## License
This project is for educational/demo purposes.
