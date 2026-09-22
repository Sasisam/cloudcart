pipeline {
    agent any

    tools {
        jdk 'Java21'
        maven 'Maven3'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                dir('backend') {
                    sh 'mvn clean package -DskipTests=false'
                }
            }
        }

        stage('Test') {
            steps {
                dir('backend') {
                    sh 'mvn test'
                }
            }
        }
    }

    post {
        success {
            echo 'CloudCart CI Pipeline completed successfully!'
        }

        failure {
            echo 'CloudCart CI Pipeline failed. Check the Jenkins console output.'
        }
    }
}
