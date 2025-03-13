# System Architecture Overview

This diagram illustrates the high-level architecture of our application, encompassing the frontend, backend, database, and data engineering components.

```mermaid
flowchart TD
    subgraph "Frontend (Next.js)"
        A[User Interface] --> B[Authentication]
        B --> C[Transaction Management]
        C --> D[Account Management]
        D --> E[Analytics Dashboard]
    end

    subgraph "Backend (Spring Boot)"
        F[REST API] --> G[Security Layer]
        G --> H[Business Logic]
        H --> I[Data Access Layer]
    end

    subgraph "Database"
        J[(PostgreSQL)]
    end

    subgraph "Data Engineering"
        K[Data Collection] --> L[Data Processing]
        L --> M[Data Storage]
        M --> N[Data Analytics]
    end

    A <--> F
    I <--> J
    J <-.-> K
