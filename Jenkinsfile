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
    
        stage('Test CMD') {
            steps {
                bat 'echo Hello from CMD'
            }
        }

        stage('Run Pre-Commit Hooks') {
            steps {
                bat '''
                call where pre-commit
                if %ERRORLEVEL% NEQ 0 (
                    echo pre-commit not found, installing...
                    pip install pre-commit
                )
                pre-commit run --all-files
                '''
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Run') {
            steps {
               bat 'mvn exec:java -Dexec.mainClass=jenkins_learning.NumberGuessingGame'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
                        bat "mvn sonar:sonar -Dsonar.login=%SONAR_TOKEN% -Dsonar.projectKey=jenkins-project -Dsonar.projectName='Sonar' -Dsonar.host.url=http://localhost:9000"
                    }
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
