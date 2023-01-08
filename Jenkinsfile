pipeline{
    agent{
        label "any"
    }
    stages{
        stage("Build"){
            steps{
                echo "========executing Build========"
            }            
        }
    }
    stages{
        stage("Test"){
            steps{
                echo "========executing Test========"
            }            
        }
    }
    stages{
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