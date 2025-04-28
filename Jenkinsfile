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

        stage('Run Pre-Commit Hooks') {
            steps {
                script {
                    // Install pre-commit if not already installed (use pip or any package manager)
                    sh '''
                    if ! command -v pre-commit &> /dev/null; then
                        echo "pre-commit not found, installing..."
                        pip install pre-commit
                    fi
                    '''
                    // Run pre-commit hooks
                    sh 'pre-commit run --all-files'
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

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
                        bat "mvn sonar:sonar -Dsonar.login=${SONAR_TOKEN} -Dsonar.projectKey=jenkins-project -Dsonar.projectName='Sonar' -Dsonar.host.url=http://localhost:9000"
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
