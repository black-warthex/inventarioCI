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
        
        stage('Iniciar DB for build') {
            steps {
                 bat 'docker run -d --name ci-db -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_USER=admin -e MYSQL_PASSWORD=root -e MYSQL_DATABASE=app_ci mysql'
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
                bat 'docker-compose up'
            }
        }
    }
}
