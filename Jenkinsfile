pipeline {
    agent any
    
    environmet{
        DATA_DOCKER = credentials('dckr_pat_vDyxXX5p8cvwFSl66xGCH1a9hzs')
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
                bat 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
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
