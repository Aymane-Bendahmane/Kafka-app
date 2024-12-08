# Kafka Integration Project

This project demonstrates a simple integration with Kafka, including event production and consumption. It uses **Docker Compose** to set up the **Zookeeper** and **Kafka server**.

---

## 🐋 Docker Configuration

We use a `docker-compose.yml` file to configure and start the Zookeeper and Kafka server.

---

## 📡 How to View Events Inside Kafka

To view events in Kafka, you need to locate the Kafka consumer script and then access the container to run it.

### 1️⃣ Get the Kafka consumer script path

Run the following command to find the consumer script inside the Kafka container:

```bash
docker container exec -it kafka-kafka-1 find / -name "kafka-console-consumer*"
```
You should see a result similar to:

bash
```
/opt/kafka_2.13-2.8.1/bin/kafka-console-consumer.sh
```
### 2️⃣ Access the Kafka container
Run this command to open a bash session inside the Kafka container:
```bash
docker container exec -it kafka-kafka-1 /bin/bash
```
### 3️⃣ View the events in a specific topic
Use the following command to view messages from a specific Kafka topic (replace my-topic with the topic name):
```bash
/opt/kafka_2.13-2.8.1/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my-topic --from-beginning
```
### 🚀 API for Event Production
This project includes an API to push events to a Kafka topic. The event is produced to Kafka and then consumed by a listener.

📢 Endpoint Details
```http request
POST http://localhost:8080/publish
{
  "message": "test"
}

```