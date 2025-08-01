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

