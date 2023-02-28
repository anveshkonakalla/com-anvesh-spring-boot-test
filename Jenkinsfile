pipeline{
    agent any
    //agent {
       // docker {
         //   image 'maven:3.6.3'
        //}
   // }
    environment {
        dockerHome= tool 'myDocker'
        mavenHome= tool 'myMaven'
        PATH="$mavenHome/bin:$PATH"
    }
    stages{
        stage("Build"){
            steps{
	                echo "========executing Build========"
	                echo "PATH - $PATH"
	                echo "BUILD_NUMBER - $env.BUILD_NUMBER"
	                echo "JOB_NAME - $env.JOB_NAME"
	                echo "BUILD_TAG - $env.BUILD_TAG"
	                echo "BUILD_URL - $env.BUILD_URL"
	                echo "GIT_COMMIT - $env.GIT_COMMIT"
	                echo "GIT_BRANCH - $env.GIT_BRANCH"
                    echo "mavenHome - $mavenHome"
                    sh(returnStdout: true, script: 'git rev-parse --abbrev-ref HEAD').trim()
                   
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