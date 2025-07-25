pipeline {
    agent any

    tools {
        jdk 'JDK 21'
        maven 'Maven 3.9.9'
    }

    environment {
        POSTMAN_COLLECTION = 'postman/LoginTests.postman_collection.json'
        POSTMAN_REPORT = 'results/postman-report.xml'
    }

    stages {
        stage('Clone Repository') {
            steps {
                // Explicitly specify the 'main' branch for cloning
                git branch: 'main', url: 'https://github.com/san199r/LoginTestAutomation.git'
            }
        }

        stage('Build Project') {
            steps {
                echo 'Building project with Maven...'
                // Changed 'sh' to 'bat' for Windows compatibility
                bat 'mvn clean install'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                echo 'Running Selenium TestNG tests...'
                // Changed 'sh' to 'bat' for Windows compatibility
                bat 'mvn test'
            }
        }

        stage('Run Postman Collection') {
            steps {
                echo 'Running Postman API tests using Newman...'
                // Changed 'sh' to 'bat' for Windows compatibility
                // Note: Ensure Newman is installed and available in the PATH of the Jenkins agent
                bat "newman run ${env.POSTMAN_COLLECTION} --reporters cli,junit --reporter-junit-export ${env.POSTMAN_REPORT}"
            }
        }
    }

    post {
        always {
            echo 'Publishing test reports...'
            // Ensure these paths are correct relative to your workspace
            // Spark.html might not be a standard JUnit report, verify its format
            junit 'test-output/Spark.html'
            junit "${env.POSTMAN_REPORT}"
        }
    }
}
