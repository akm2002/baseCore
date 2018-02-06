pipeline {
  agent any
  def version = '1.0-SNAPSHOT'
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
        hygieiaArtifactPublishStep(artifactVersion: ${version}, artifactGroup: 'com.coding', artifactDirectory: 'target', artifactName: 'baseCore-*.war')
      }
    }
    stage('LaunchNexusArtifact') {
      steps {
      nexusArtifactUploader {
        nexusVersion('nexus2')
        protocol('http')
        nexusUrl('172.21.16.193:8080/nexus')
        groupId('com.coding')
        version(${version})
        repository('releases')
        artifact {
            artifactId('baseCore')
            type('war')
            classifier('debug')
            file('target/')
        }
      }
    }
    }
  }
}