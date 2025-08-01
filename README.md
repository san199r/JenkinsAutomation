# Continuous Integration and Delivery with Jenkins for Automated Tests

## 📌 Project Overview

This project demonstrates a CI/CD pipeline setup using Jenkins to automatically run Selenium-based automated tests for a login page (`https://the-internet.herokuapp.com/login`) whenever code is committed to the GitHub repository.

## 🚀 Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Jenkins
- Git & GitHub

---

## 🔧 Project Setup

### 1. Clone the Repository

```bash
git clone https://github.com/san199r/LoginTestAutomation.git
cd LoginTestAutomation

2. Install Required Tools
Ensure the following are installed:

Java (JDK 17)

Maven

Git

Jenkins (with required plugins: Git, Maven Integration, TestNG Results)

🤖 Jenkins CI/CD Pipeline Setup

Jenkins Pipeline

Create a new Pipeline job in Jenkins.

In the Pipeline definition, choose:

Pipeline script from SCM

SCM: Git

Repository URL: https://github.com/san199r/LoginTestAutomation.git

Branch: main (or your working branch)

Jenkins will use the Jenkinsfile in the root directory.

Build will:

Clone the repo

Run mvn clean test

Generate TestNG reports

✅ Test Cases Implemented
Selenium Test Scenarios:
✅ Valid Login

❌ Invalid Login

⚠️ Empty Fields

All tests use TestNG annotations and are written in Java.

<img width="1365" height="596" alt="image" src="https://github.com/user-attachments/assets/0f4db2cd-2578-4556-816e-6473681d1a01" />


<img width="1365" height="593" alt="image" src="https://github.com/user-attachments/assets/019dacd4-1b9f-42e9-9a86-7dbd71ec3489" />

<img width="1365" height="601" alt="image" src="https://github.com/user-attachments/assets/34dafc85-aaef-4a1c-9b06-9b3a51420b2e" />

<img width="1365" height="597" alt="image" src="https://github.com/user-attachments/assets/d8e867c5-f483-43b2-bd00-2077f3e92e21" />

<img width="1365" height="600" alt="image" src="https://github.com/user-attachments/assets/a06e320e-e87f-49f9-b436-eebdb16b77b3" />

<img width="1365" height="599" alt="image" src="https://github.com/user-attachments/assets/36e0c322-7d03-4057-b9c8-29658e00b548" />







<img width="1365" height="590" alt="image" src="https://github.com/user-attachments/assets/9aa1806e-c8d1-47fc-af07-372ba347c1ba" />
