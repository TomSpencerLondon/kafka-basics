Here’s the updated README with an additional option for submitting orders via the form and an illustrative image.

---

### **Kafka Microservices Example: Summary and Application Overview**

This project demonstrates a simple microservice architecture using **Apache Kafka** for inter-service communication. It includes two services:
- **Order Service**: Produces messages to Kafka when orders are created.
- **Processing Service**: Consumes messages from Kafka and processes the orders.

This README summarizes the first four videos of the **Apache Kafka 101** playlist and explains how this application works, including examples of log messages and instructions for running the application.

---

### **Summary of Kafka Playlist (Videos 1–4)**

**[Apache Kafka 101 Playlist](https://www.youtube.com/watch?v=qu96DFXtbG4&list=PLa7VYi0yPIH0xeDp2Iu1q_esSYeNsIxkZ)**

#### **Video 1: Introduction to Apache Kafka**
- Kafka is an **event streaming platform** designed to handle real-time data streams at scale.
- Core concepts:
    - **Event**: A record of something that happened.
    - **Topic**: The primary unit for organizing events, similar to a table in a database.
    - **Producer**: Writes data (events) to a Kafka topic.
    - **Consumer**: Reads data from a Kafka topic.

#### **Video 2: Kafka Topics**
- Topics are logs that store ordered, immutable records of events.
- Characteristics of a topic:
    - **Append-Only**: Events are added to the end of the log.
    - **Immutable**: Once written, events cannot be changed.
    - **Retention Policy**: Events can expire based on time or storage size.

#### **Video 3: Kafka Partitions**
- Topics are divided into **partitions**, allowing parallelism and scalability.
- Producers decide which partition to send a message to (e.g., using keys or round-robin).
- Consumers read from partitions, and Kafka guarantees **order within a partition**.

#### **Video 4: Kafka Brokers**
- Kafka runs on a cluster of machines called **brokers**.
- Each broker hosts a subset of partitions and handles read/write requests.
- Brokers replicate partitions to ensure fault tolerance.

---

### **Application Overview**

This project consists of the following components:

#### **1. Order Service**
- **Functionality**: Accepts orders via a REST API and an HTML form, then sends them to a Kafka topic (`orders`).
- **Flow**:
    - A user submits an order (via API or form).
    - The order is serialized into JSON and sent to Kafka.

#### **2. Processing Service**
- **Functionality**: Listens to the `orders` topic and processes incoming orders.
- **Flow**:
    - The service consumes messages from the `orders` topic.
    - The messages are deserialized and logged as "processed."

#### **Shared Models**
- The `Order` class, used by both services, is defined in a shared module (`shared-models`).
- Ensures consistency in message structure.

#### **Kafka Configuration**
- The Kafka broker is configured using Docker Compose (`kafka` and `zookeeper` services).
- Topics are automatically created by Spring Boot via `NewTopic` beans.

---

### **Log Examples**

#### **Order Service Logs**
When an order is submitted:
```plaintext
INFO  [main] org.example.orderservice.OrderProducer - Sending order to Kafka: Order{id='123', product='Laptop', quantity=2}
```

#### **Processing Service Logs**
When an order is processed:
```plaintext
INFO  [consumer-order-group-1] org.example.processingservice.OrderConsumer - Processing order: Order{id='123', product='Laptop', quantity=2}
```

---

### **How to Submit an Order**

#### **1. Using the REST API**
- **Method**: `POST`
- **URL**: `http://localhost:8080/orders`
- **Body** (JSON):
  ```json
  {
    "product": "Laptop",
    "quantity": 2
  }
  ```
- **Response**:
  ```plaintext
  Order placed successfully
  ```

---

#### **2. Using the HTML Form**
Access the order submission form at:
```
http://localhost:8080/orders
```

Fill in the form with the product and quantity, then click "Place Order".

Here’s how the form looks:
<img width="1660" alt="image" src="https://github.com/user-attachments/assets/b68b57b6-98d6-42aa-9d92-1a45f09a90e5" />

---

### **Verify the Application**

1. **Order Service**:
    - Open a browser or use a tool like Postman to submit an order.
    - Example: `POST http://localhost:8080/orders`

2. **Processing Service**:
    - Check the logs of `processing-service`:
      ```bash
      docker logs kafka-microservices-processing-service-1
      ```
    - Ensure the order is processed and logged.

---

### **Project Structure**

```
kafka-microservices/
├── shared-models/           # Shared module containing the Order class
├── order-service/           # Service for placing orders
├── processing-service/      # Service for processing orders
├── docker-compose.yml       # Docker Compose configuration for Kafka and services
├── restart.sh               # Script to rebuild and restart the project
```

---

### **How to Run the Application**

#### **1. Prerequisites**
- **Docker**: Ensure Docker and Docker Compose are installed.
- **Java 21**: Required to build and run the application locally.
- **Maven**: Used to build the project.

#### **2. Start the Application**
Run the `restart.sh` script to clean, build, and start the application:
```bash
./restart.sh
```

---

### **Conclusion**
This application demonstrates how to use Apache Kafka for real-time communication between microservices. By combining Kafka's robust event streaming capabilities with Spring Boot's integration, it provides a scalable and fault-tolerant solution for handling events. 🚀
