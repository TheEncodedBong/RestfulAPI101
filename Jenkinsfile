/* restful-api-101 */
pipeline {
    agent any
    tools {
    	maven 'Maven 3.5.4'
    	jdk 'Java 13'
    }
    stages {
        stage('Initialize') {
            steps {
                echo "PATH: ${PATH}"
                echo "MAVEN: ${M2_HOME}"
            }
        }
        stage('Build') {
            steps {
            	echo "Start of build..."
                sh 'mvn clean install'
            }
        }
    }
}