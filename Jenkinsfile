node {
    stage('Configure') {
        env.PATH = "${tool 'maven-3.3.9'}/bin:${env.PATH}"
        version = '1.0.' + env.BUILD_NUMBER
        currentBuild.displayName = version

        properties([
                buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '10')),
                [$class: 'GithubProjectProperty', displayName: '', projectUrlStr: 'https://github.com/nilofarsulaiman/fsdspringbootapp/'],
                pipelineTriggers([[$class: 'GitHubPushTrigger']])
            ])
    }

    stage('Checkout') {
        git 'https://github.com/nilofarsulaiman/fsdspringbootapp'
    }

  
    stage('Build') {
        sh 'mvn -B -V -U -e clean package'
    }

    stage('Archive') {
      
    }

    stage('Deploy') {
     
        }
    }
}
