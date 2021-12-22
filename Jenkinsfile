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
        bat "mvn clean"
      }
    }
    stage('Test') {
      steps {
        echo "Testing the Code.........."
        bat "mvn test"
      }
    }
    stage('Compile') {
      steps {
        echo "Compiling the Project.........."
        bat "mvn compile"
      }
    }
    stage('Package') {
      steps {
        echo "Packaging the project"
        bat "mvn install"
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
    stage('Remove Unused docker image') {
      steps {
        bat "docker rmi $imagename:$BUILD_NUMBER"
      }
    }
  }
}