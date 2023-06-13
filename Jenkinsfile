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
                bat 'start /B gradle build'
            }
        }

        stage('Dockerize') {
            steps {
                sh 'docker build -t warthex/ci_app .'
                sh 'docker push warthex/ci_app'
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker-compose up -d'
            }
        }
    }
}
