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
                  bat 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }
        
        stage('push'){
            steps{
                bat 'docker push warthex/ci_app:latest'
            }
        }
        

        stage('Deploy') {
            steps {
                bat 'docker-compose up -d'
            }
        }
    }
}
