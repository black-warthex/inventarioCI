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

        stage('Build image') {
            steps {
                bat 'docker build -t warthex/ci_app:latest .'
                withCredentials([usernamePassword(credentialsId: 'dckr_pat_vDyxXX5p8cvwFSl66xGCH1a9hzs', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    bat 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                }
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
