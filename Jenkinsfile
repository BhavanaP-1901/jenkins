pipeline {
    agent any

    tools {
        maven 'Maven 3.9.9' // Make sure this is configured in Global Tool Configuration
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: 'github-creds', url: 'https://github.com/BhavanaP-1901/jenkins.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Run') {
            steps {
                bat 'java -cp target/classes jenkins_learning.Test 42'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
                    bat "mvn sonar:sonar -Dsonar.projectKey=jenkins-project -Dsonar.projectName='Sonar' -Dsonar.login=${SONAR_TOKEN}"
                }
            }
        }
    }

    post {
        success {
            echo '🎉 Build Successful!'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}

