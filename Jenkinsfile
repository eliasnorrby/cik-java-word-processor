// Template Jenkinsfile for CI of Java based exercises
node {
    def display_name = "${JOB_NAME}-${BUILD_NUMBER}"
    display_name = display_name.replace("%2F", "-")
    slackSend color: 'good', message: "${display_name} : Build Started"
    stage('Checkout') {
        //slackSend color: 'good', message: "${display_name} : Checking out source code"
        checkout scm
    }

    stage('Compile') {
        try {
            sh 'mvn clean compile'
        } catch (err) {
            currentBuild.result='FAILURE'
        }
    }

    stage('Test') {
        try {
            sh 'mvn test'
        } catch (err) {
            currentBuild.result='FAILURE'
        }
    }
        
    if (currentBuild.resultIsBetterOrEqualTo('SUCCESS')) {
        slackSend color: 'good', message: "${display_name} : Build SUCCESS"
    } else {
        slackSend color: 'danger', message: "${display_name} : Build FAILURE"
    }
}
