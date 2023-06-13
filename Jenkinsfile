pipeline {
    agent any

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

        stage('Dockerize') {
            steps {
                bat 'docker build -t warthex/ci_app .'
                bat 'docker push warthex/ci_app'
            }
        }

        stage('Deploy') {
            steps {
                bat 'docker-compose up -d'
            }
        }
    }
}
