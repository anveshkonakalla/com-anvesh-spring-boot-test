pipeline{
    //agent any
    agent {
        docker {
            image 'maven:3.6.3'
        }
    }
    stages{
        stage("Build"){
            steps{
                echo "========executing Build========"
                 echo "mvn --version"
            }            
        }
        stage("Test"){
            steps{
                echo "========executing Test========"
            }            
        }
        stage("Integration Test"){
            steps{
                echo "========executing Integration Test========"
            }            
        }
    }
    post{
        always{
            echo "========always========"
        }
        success{
            echo "========pipeline executed successfully ========"
        }
        failure{
            echo "========pipeline execution failed========"
        }
    }
}