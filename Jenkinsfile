pipeline {
    agent any

    stages {
        stage ('compile stage'){

            steps {
                withMaven(maven : 'maven_3.6.1') {
                    bat "mvn clean compile"
                }
            }

        }

        stage ('Testing stage') {
            steps {
                  withMaven(maven : 'maven_3.6.1')  {
                  bat "mvn test"
                }

             }
        }

    }
}