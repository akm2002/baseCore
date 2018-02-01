pipeline {
  agent any
  stages {
    stage('InstallAndAnalysis') {
      steps {
        sh 'mvn clean install'
        hygieiaBuildPublishStep(buildStatus: 'Success')
      }
    }
    stage('CheckStyle') {
      steps {
        hygieiaSonarPublishStep(ceQueryIntervalInSeconds: '2', ceQueryMaxAttempts: '10')
      }
    }
  }
}