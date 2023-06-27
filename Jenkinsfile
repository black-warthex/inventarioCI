pipeline {
    agent any
    environment{
        DOCKERHUB_CREDENTIALS = credentials('docker')
    }
    stages {
        stage('check changes on repository') {
            steps {
                git 'https://github.com/black-warthex/inventarioCI.git'
            }
        }
        
        stage('create build') {
            steps {
                bat 'docker start ci-db'
                bat 'gradle build'
                bat 'docker stop ci-db'
                bat 'docker remove ci-db'
            }
        }

        stage('Build and Up docker image') {
            steps {
                bat 'docker build -t warthex/ci_app:latest .'
                bat 'docker login -u %DOCKERHUB_CREDENTIALS_USR% -p %DOCKERHUB_CREDENTIALS_PSW%'
                bat 'docker push warthex/ci_app:latest'
            }
        }

        stage('Deploy') {
            steps {
                bat 'docker-compose down'
                bat 'docker-compose up -d'
            }
        }
    }
}
