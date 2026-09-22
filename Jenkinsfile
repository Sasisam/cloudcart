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

        stage('SonarQube Analysis') {
            steps {
                dir('backend') {
                    withSonarQubeEnv('SonarQube') {
                        sh '''
                            mvn org.sonarsource.scanner.maven:sonar-maven-plugin:sonar \
                              -Dsonar.projectKey=CloudCart \
                              -Dsonar.host.url=$SONAR_HOST_URL \
                              -Dsonar.token=$SONAR_AUTH_TOKEN
                        '''
                    }
                }
            }
	stage('Quality Gate') {
    	    steps {
        	timeout(time: 5, unit: 'MINUTES') {
            	 waitForQualityGate abortPipeline: true
        	   }	
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
