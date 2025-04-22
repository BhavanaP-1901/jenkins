pipeline {
    agent any

    tools {
        maven 'maven' // Make sure this Maven version is configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'github-creds', url: 'https://github.com/BhavanaP-1901/jenkins.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Run') {
            steps {
                sh 'java -cp target/classes jenkins_learning.Test'
            }
        }
    }
}

