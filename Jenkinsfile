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
                echo '📥 Cloning GitHub repo...'
                git branch: 'main', url: 'https://github.com/san199r/LoginTestAutomation.git'
            }
        }

        stage('Build Project') {
            steps {
                echo '🔨 Building Maven project...'
                bat 'mvn clean install'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                echo '🧪 Running Selenium TestNG tests...'
                bat 'mvn test'
            }
        }

        stage('Run Postman Collection') {
            steps {
                echo '📡 Running Postman API tests using Newman...'
                bat "dir postman"  // Debug: confirm file exists

                timeout(time: 3, unit: 'MINUTES') {
                    bat """
                        node "D:\\node.js\\node_modules\\newman\\bin\\newman.js" ^
                        run ${env.POSTMAN_COLLECTION} ^
                        --insecure ^
                        --timeout-request 10000 ^
                        --no-color ^
                        --reporters cli,junit ^
                        --reporter-junit-export ${env.POSTMAN_REPORT}
                    """
                }
            }
        }
    }

    post {
        always {
            echo '📤 Publishing test reports...'

            // Selenium TestNG JUnit results
            junit '**/target/surefire-reports/*.xml'

            // Postman (Newman) results
            junit "${env.POSTMAN_REPORT}"

            // Optional: Enable only if Spark.html viewing is needed
            // publishHTML(target: [
            //     reportDir: 'test-output',
            //     reportFiles: 'Spark.html',
            //     reportName: 'Selenium HTML Report'
            // ])
        }
    }
}
