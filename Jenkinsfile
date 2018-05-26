pipeline {
    agent any
	tools{
      maven 'LocalMaven'
    }
    stages{
        stage('Build'){
            steps {
                bat 'mvn clean package checkstyle:checkstyle'
            }
            post {
                success {
                    archiveArtifacts artifacts: '**/target/*.war'
					echo 'Archived successfully'
                }
				failure {
                    echo 'Archived failed'
                }
			}
        }
        stage ('Deploy to Staging'){
            steps {
                build job: 'deploy-staging-vinculum'
            }
			post {
                success {
                    echo 'Deployed to Staging successfully'
                }
                failure {
                    echo 'Deployed to Staging failed'
                }
            }
        }
        stage ('Deploy to Production'){
            steps{
                timeout(time:7, unit:'DAYS'){
                    input message:'Deploy to Production'
                }

                build job: 'deploy-production-vinculum'
            }
            post {
                success {
                    echo 'Deployed to Production successfully'
                }
                failure {
                    echo 'Deployed to Production failed'
                }
            }
        }
    }
}
