# 🚦 Traffic Light Controller API

A Spring Boot microservice (Java 1.8) that simulates and controls traffic lights at an intersection.  
This project was developed as part of a coding kata exercise.

---

## 📌 Features
- Manage state changes of traffic lights (RED, YELLOW, GREEN) for multiple directions.
- Accept commands to change light sequences, pause, or resume operation.
- Validate that conflicting directions are never GREEN simultaneously.
- Provide the current state and timing history via REST API.
- Designed with concurrency in mind and extensible to multiple intersections.
- Includes unit tests for service and controller layers.

---

## 🏗️ Project Structure
