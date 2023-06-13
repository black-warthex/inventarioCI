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
                bat 'start /B docker build -t warthex/ci_app .'
                bat 'start /B docker push warthex/ci_app'
            }
        }

        stage('Deploy') {
            steps {
                bat 'start /B docker-compose up -d'
            }
        }
    }
}
