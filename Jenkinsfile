pipeline {
    agent any

    tools {
        maven 'Maven 3.9.9'
    }

    environment {
        SONARQUBE_ENV = credentials('sonarqube-token-id') // optional if token injected via server config
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: 'github-creds', url: 'https://github.com/BhavanaP-1901/jenkins.git'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat 'mvn clean verify sonar:sonar -Dsonar.projectKey=jenkins-project -Dsonar.projectName="Jenkins Project"'
                }
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
    }

    post {
        success {
            echo '🎉 Build Successful!'
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
    }
}
