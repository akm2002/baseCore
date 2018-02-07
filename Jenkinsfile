pipeline {
  agent any
  stages {
    stage('BuildArtifact') {
      steps {
        sh '''#mvn clean  install  -DskipTests
mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=true

mvn sonar:sonar'''
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
      parallel {
        stage('PublishHygieia') {
          steps {
            hygieiaArtifactPublishStep(artifactVersion: '1.0-SNAPSHOT', artifactGroup: 'com.coding', artifactDirectory: 'target', artifactName: 'baseCore-*.war')
          }
        }
        stage('PublishDeploymentHygieia') {
          steps {
            hygieiaDeployPublishStep(artifactDirectory: 'target', artifactName: 'baseCore-1.0-SNAPSHOT.war', artifactGroup: 'com.coding', artifactVersion: '1.0-SNAPSHOT', applicationName: 'BASECODE', environmentName: 'SIT', buildStatus: 'Success')
          }
        }
      }
    }
    stage('LaunchNexusArtifact') {
      steps {
        sh 'mvn deploy -DskipTests'
      }
    }
    stage('LaunchPODServer') {
      steps {
        sh '''mv target/baseCore-1.0-SNAPSHOT.war target/baseCore.war
scp target/baseCore.war root@120.78.64.14:/opt/tomcat/webapps'''
      }
    }
  }
}