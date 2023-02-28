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
                    script {
                    	BRANCH_NAME=sh(script: "echo $env.GIT_BRANCH | sed -e 's|origin/||g'", returnStdout:true).trim()
                    	echo "Branch name: ${BRANCH_NAME}" 
                    	if("${BRANCH_NAME}" == 'master'){
                    		echo "Branch name: ${BRANCH_NAME}"
                    		BUILD_VERSION='2023.99.0'
                    		echo "Build version: ${BUILD_VERSION}"
                    	}
                        
                    }
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