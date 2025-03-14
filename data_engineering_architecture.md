```mermaid
flowchart TB
    subgraph "Data Sources"
        TransDB["Transaction DB"]
        UserDB["User DB"]
        WalletDB["Wallet DB"]
        Logs["Application Logs"]
        API["API Events"]
    end

    subgraph "Data Ingestion"
        Kafka["Kafka"]
        CDC["Change Data Capture"]
        LogCollector["Log Collector"]
    end

    subgraph "Data Storage"
        DL["Data Lake"]
        DW["Data Warehouse"]
    end

    subgraph "Data Processing"
        Spark["Spark"]
        Stream["Streaming Jobs"]
        Batch["Batch Jobs"]
    end

    subgraph "Data Consumption"
        ML["Machine Learning Models"]
        BI["BI & Reporting"]
        Alert["Alerting System"]
    end

    %% Data Flow Connections
    TransDB --> CDC
    UserDB --> CDC
    WalletDB --> CDC
    CDC --> Kafka
    Logs --> LogCollector
    API --> Kafka
    LogCollector --> Kafka
    Kafka --> Stream
    Kafka --> DL
    DL --> Batch
    Stream --> DL
    Batch --> DW
    DW --> BI
    DW --> ML
    ML --> Alert
