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
                withCredentials([usernamePassword(credentialsId: 'dckr_pat_VmO3MjtAjIV3umf21WV1xe0aUL8', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    bat 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'
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
