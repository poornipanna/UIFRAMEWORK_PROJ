pipeline {
    agent any
    tools{
        maven 'maven_3_6_1'
    }

    stages {
        stage ('compile stage'){

            steps {

                    sh "mvn compile"
                }
            }



        stage ('Testing stage') {
            steps {

                  sh "mvn test"
                }

             }
           }
    }