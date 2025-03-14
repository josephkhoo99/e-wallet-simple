# System Architecture Overview

This diagram illustrates the high-level architecture of our application, encompassing the frontend, backend, database, and data engineering components.

```mermaid
flowchart TB
    User[User]

    subgraph "Frontend (Next.js)"
        UI[UI Components]
        State[State Management]
        API_Client[API Client]
    end

    subgraph "Backend (Spring Boot)"
        API[RESTful API]
        Service[Service Layer]
        Repository[Repository Layer]
        Security[Security Layer]
    end

    subgraph "Database"
        SQL[(SQL Database)]
        Redis[(Redis Cache)]
    end

    subgraph "Data Engineering"
        ETL[ETL Processes]
        Analytics[Analytics Engine]
        Reporting[Reporting Dashboard]
        DataLake[(Data Lake)]
    end

    User --> UI
    UI --> State
    State --> API_Client
    API_Client --> API
    API --> Security
    Security --> Service
    Service --> Repository
    Repository --> SQL
    Service --> Redis
    SQL --> ETL
    ETL --> DataLake
    DataLake --> Analytics
    Analytics --> Reporting
```

# Backend (Spring Boot)
i) Complete API for user management, wallet operations, and transactions <br>
ii) Secure authentication with JWT <br>
iii) Transaction processing logic for deposits, withdrawals, and transfers <br>
iv) Database models and repositories

# Frontend (Next.js)
i) User authentication screens (login/register) <br> 
ii) Dashboard with wallet overview and transaction history <br>
iii) Deposit, withdrawal, and transfer functionality <br>
iv) Interactive charts for transaction visualization

# Data Engineering Pipeline
i) Comprehensive data flow from operational database to data warehouse <br>
ii) Change Data Capture (CDC) for real-time data streaming <br>
iii) Apache Kafka for event messaging <br>
iv) Data Lake architecture with landing, processed, and curated zones <br>
v) ETL processes using Apache
