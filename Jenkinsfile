pipeline{
    agent any
    //agent {
       // docker {
         //   image 'maven:3.6.3'
        //}
   // }
    stages{
        stage("Build"){
            steps{
                echo "========executing Build========"
                echo "PATH - $PATH"
                echo "BUILD_NUMBER - $env.BUILD_NUMBER"
                echo "JOB_NAME - $env.JOB_NAME"
                echo "BUILD_TAG - $env.BUILD_TAG"
                echo "BUILD_URL - $env.BUILD_URL"
                def scmVars = checkout([
        			$class: 'GitSCM',
      			])
			    echo "scmVars.GIT_COMMIT"
			    echo "${scmVars.GIT_COMMIT}"
  		        env.GIT_COMMIT = scmVars.GIT_COMMIT
			    echo "env.GIT_COMMIT"
			    echo "${env.GIT_COMMIT}"
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