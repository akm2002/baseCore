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
      steps {
        script {
          def sonarqubeScannerHome = tool 'SonarQube Scanner'
          
          withSonarQubeEnv('SonarQube') {
            sh "${sonarqubeScannerHome}/bin/sonar-scanner"
          }
        }
        
      }
    }
    stage('PublishHygieia') {
      steps {
        hygieiaArtifactPublishStep(artifactVersion: '1.0-SNAPSHOT', artifactGroup: 'com.coding', artifactDirectory: 'target', artifactName: 'baseCore-*.war')
      }
    }
    stage('LaunchNexusArtifact') {
      steps {
        sleep 1
      }
    }
  }
}