pipeline {
    agent any

    stages {
        stage ('compile stage'){

            steps {
                withMaven(maven : 'maven_3_6_1') {
                    sh 'mvn build'
                }
            }

        }

        stage ('Testing stage') {
            steps {
                  withMaven(maven : 'maven_3_6_1')  {
                  sh 'mvn test'
                }

             }
        }

    }
}