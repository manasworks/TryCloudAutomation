node {
    stage('Clone code') {
        git 'https://github.com/manasworks/TryCloudAutomation.git'
    }

    stage('Run tests'){
        if(isUnix()){
            sh "mvn clean install Dselenide.browserSize=1900x1200 test"
        } else {
            bat "mvn clean install Dselenide.browserSize=1900x1200 test"
        }
    }

    stage('Generate report'){
           cucumber failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
    }
}