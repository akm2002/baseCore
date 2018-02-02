pipeline {
  agent any
  stages {
    stage('BuildArtifact') {
      steps {
        sh 'mvn clean install -DskipTests'
        hygieiaBuildPublishStep(buildStatus: 'Success')
      }
    }
    stage('UnitTest') {
      steps {
        sh 'mvn test'
      }
    }
    stage('SonarQube analysis') {
    	def sonarqubeScannerHome = tool name: 'SonarQube Scanner'
    	
        withSonarQubeEnv('SonarQube') { 
          sh "${sonarqubeScannerHome}/bin/sonar-scanner"
        }
    }
    stage('SonarQube Quality Gate') {
 		steps {
        waitForQualityGate()
      }
    }
  }
}