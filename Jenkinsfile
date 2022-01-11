node {
    stage("checkout") {
        git branch: 'jenkins', credentialsId: '126d52dc-a66b-4444-a35e-ec39c948b427', url: 'https://github.com/Keshaun1222/yastah-api.git'
    }
    stage("build") {
        sh 'mvn clean package -DskipTests=true'
    }
    stage("archive") {
        archiveArtifacts 'target/*.jar'
    }
    stage("publish") {
        //s3Upload consoleLogLevel: 'INFO', dontSetBuildResultOnFailure: false, dontWaitForConcurrentBuildCompletion: false, entries: [[bucket: 'keshaun-artifact-storage', excludedFile: '', flatten: false, gzipFiles: false, keepForever: false, managedArtifacts: false, noUploadOnFailure: false, selectedRegion: 'us-east-2', showDirectlyInBrowser: false, sourceFile: 'target/*.jar', storageClass: 'STANDARD', uploadFromSlave: false, useServerSideEncryption: false]], pluginFailureResultConstraint: 'FAILURE', profileName: 'Keshaun', userMetadata: []
        s3Upload acl: 'Private', bucket: 'keshaun-artifact-storage', cacheControl: '', excludePathPattern: '', file: 'target/*.jar', includePathPattern: '', metadatas: [''], redirectLocation: '', sseAlgorithm: '', tags: '', text: '', workingDir: ''
    }
}