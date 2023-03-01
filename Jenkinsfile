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
        stage("Build Setup"){
            steps{
	                echo "========executing Build Setup========"
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
                    		echo "BUILD_VERSION: ${BUILD_VERSION}"
                    	} else {
                    		BUILD_VERSION = sh(script: "echo $env.GIT_BRANCH | sed -e 's|origin/||g'", returnStdout:true).trim()
                    		echo "BUILD_VERSION: ${BUILD_VERSION}"
                    	}
                    	GIT_COMMIT= sh([script: "git rev-parse HEAD", returnStdout:true]).trim()
                    	echo "GIT_COMMIT: ${GIT_COMMIT}"
                    	NEXUS_VERSION=sh([script: "git rev-list ${GIT_COMMIT} --count", returnStdout:true]).trim()
                    	echo "NEXUS_VERSION: ${NEXUS_VERSION}"
                    	GIT_SIMPLE=sh([script: "git rev-list ${GIT_COMMIT} | head -n 1| cut -c 1-5", returnStdout:true]).trim()
                    	echo "GIT_SIMPLE: ${GIT_SIMPLE}"
                    	build=currentBuild
                    	while(build !=null && build.result != 'SUCCESS') {
                    		build=build.previousBuild
                    	}
                    	if(build == null) {
                    		PREVIOUS_BUILD_VERSION="none"
                    	} else {
                    		PREVIOUS_BUILD_VERSION = build.displayName
                    	}
                    	echo "LAST Successful Build name: ${PREVIOUS_BUILD_VERSION}"
                    	
                    	currentBuild.displayName="${BUILD_VERSION}.${NEXUS_VERSION}-${GIT_SIMPLE}"
                        
                    }
		       }   
                     
        }
        
        stage("Build"){
            steps{
                echo "========executing Build========"
                echo "BUILD_VERSION: ${BUILD_VERSION}"
                configFileProvider([configFile(fileId:'maven-settings', variable: 'MAVEN_SETTINGS')]) {
                	sh 'mvn -s $MAVEN_SETTINGS clean package'
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