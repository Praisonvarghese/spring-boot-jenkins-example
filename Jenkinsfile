pipeline {
  environment {
    imagename = "praisonvarghese/spring-boot-jenkins-example"
    registryCredential = 'praison-dockerhub-id'
    dockerImage = ''
  }
  agent any
  stages {
    stage('Build') {
      steps {
        echo "Building the Code.........."
        sh "mvn clean"
      }
    }
    stage('Test') {
      steps {
        echo "Testing the Code.........."
        sh "mvn test"
      }
    }
    stage('Compile') {
      steps {
        echo "Compiling the Project.........."
        sh "mvn compile"
      }
    }
    stage('Package') {
      steps {
        echo "Packaging the project"
        sh "mvn install"
      }
    }
    stage('Building image') {
      steps {
        script {
          dockerImage = docker.build imagename
        }
      }
    }
    stage('Deploy Image') {
      steps {
        script {
          docker.withRegistry('', registryCredential) {
            dockerImage.push("$BUILD_NUMBER")
          }
        }
      }
    }
  }
}