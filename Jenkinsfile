pipeline {
    agent any

    tools {
        maven 'Maven 3.9.9' // Ensure this is correctly configured in Jenkins global tool config
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: 'github-creds', url: 'https://github.com/BhavanaP-1901/jenkins.git'
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


