pipeline {
    agent any
    environment{
        DOCKERHUB_CREDENTIALS = credentials('docker')
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/black-warthex/inventarioCI.git'
            }
        }

        stage('Build') {
            steps {
                 bat 'gradle build'
            }
        }

        stage('Build image') {
            steps {
                bat 'docker build -t warthex/ci_app:latest .'
            }
        }
        stage('Login') {
            steps {
                  bat 'docker login -u %DOCKERHUB_CREDENTIALS_USR% -p %DOCKERHUB_CREDENTIALS_PSW%'
            }
        }
        
        stage('push'){
            steps{
                bat 'docker push warthex/ci_app:latest'
            }
        }
        
        stage('Stop') {
            steps {
                bat 'docker-compose down'
            }
        }
        stage('Deploy') {
            steps {
                bat 'docker-compose up -d'
            }
        }
    }
}
