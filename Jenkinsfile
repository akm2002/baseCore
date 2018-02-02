pipeline {
  agent any
  stages {
    stage('CheckoutAndBuild') {
      steps {
        sh 'mvn clean install -DskipTests'
        hygieiaBuildPublishStep(buildStatus: 'Success')
      }
    }
    stage('UnitTest') {
      steps {
        sh 'mvn '
      }
    }
    stage('SonarQube Analysis') {
      steps {
        waitForQualityGate()
      }
    }
  }
}