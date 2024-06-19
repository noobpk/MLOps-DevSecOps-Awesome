pipeline {
    agent any

    environment {
        //Ubuntu
        SSH_SERVER = '172.17.0.4'
        SSH_USER = 'root'
        CREDENTIALS_ID = '7458c9b4-2e01-4ad5-919f-e5e518f8f3ae'
        REMOTE_DIR = '/tmp/dataset'
        FILE1_URL = 'http://172.17.0.3:8081/repository/mlops/dataset-evaluation.csv'
        FILE2_URL = 'http://172.17.0.3:8081/repository/mlops/dataset-train.csv'
        FILE1_NAME = 'dataset-evaluation.csv'
        FILE2_NAME = 'dataset-train.csv'
        REMOTE_FILE1_PATH = "${REMOTE_DIR}/${FILE1_NAME}"
        REMOTE_FILE2_PATH = "${REMOTE_DIR}/${FILE2_NAME}"
        GIT_REPO_URL = 'https://github.com/noobpk/MLOps-Awesome.git'
        GIT_CLONE_DIR = '/tmp/MLOps-Awesome'
        //Neuxs
        MODEL_FILE = '/tmp/model/text_classification_cnn_model.h5'
        NEXUS_URL = 'http://172.17.0.3:8081/repository/'
        NEXUS_REPO_PATH = 'mlops/'
        NEXUS_USERNAME = 'admin'
        NEXUS_PASSWORD = credentials('ae97292e-b285-4785-a415-d87304c6a51d')
    }

    stages {
        stage('Load Dataset from Nexus') {
            steps {
                script {
                    // Retrieve the password from Jenkins credentials
                    withCredentials([string(credentialsId: CREDENTIALS_ID, variable: 'SSH_PASS')]) {
                        def remote = [:]
                        remote.name = 'test'
                        remote.host = SSH_SERVER
                        remote.user = SSH_USER
                        remote.password = SSH_PASS
                        remote.allowAnyHosts = true

                        // Execute SSH commands
                        sshCommand remote: remote, command: "mkdir -p ${REMOTE_DIR}"
                        sshCommand remote: remote, command: "wget -O ${REMOTE_FILE1_PATH} ${FILE1_URL}"
                        sshCommand remote: remote, command: "wget -O ${REMOTE_FILE2_PATH} ${FILE2_URL}"
                    }
                }
            }
        }

        stage('Clone Git Repository') {
            steps {
                script {
                    // Retrieve the password from Jenkins secret text credentials
                    withCredentials([string(credentialsId: CREDENTIALS_ID, variable: 'SSH_PASS')]) {
                        def remote = [:]
                        remote.name = 'test'
                        remote.host = SSH_SERVER
                        remote.user = SSH_USER
                        remote.password = SSH_PASS
                        remote.allowAnyHosts = true

                        // Clone the Git repository to the specified directory
                        sshCommand remote: remote, command: """
                        rm -rf ${GIT_CLONE_DIR}
                        git clone ${GIT_REPO_URL} ${GIT_CLONE_DIR}
                        """
                        // Install requirements.txt
                        sshCommand remote: remote, command: """
                        cd ${GIT_CLONE_DIR}/code-example
                        pip3 install -r requirements.txt
                        """
                    }
                }
            }
        }

        stage('Train Model') {
            steps {
                script {
                    // Retrieve the password from Jenkins secret text credentials
                    withCredentials([string(credentialsId: CREDENTIALS_ID, variable: 'SSH_PASS')]) {
                        def remote = [:]
                        remote.name = 'test'
                        remote.host = SSH_SERVER
                        remote.user = SSH_USER
                        remote.password = SSH_PASS
                        remote.allowAnyHosts = true

                        // Train model
                        sshCommand remote: remote, command: """
                        cd ${GIT_CLONE_DIR}/code-example
                        python3 train.py
                        """
                    }
                }
            }
        }

        stage('Evaluation Model') {
            steps {
                script {
                    // Retrieve the password from Jenkins secret text credentials
                    withCredentials([string(credentialsId: CREDENTIALS_ID, variable: 'SSH_PASS')]) {
                        def remote = [:]
                        remote.name = 'test'
                        remote.host = SSH_SERVER
                        remote.user = SSH_USER
                        remote.password = SSH_PASS
                        remote.allowAnyHosts = true

                        // Evaluate trained model and capture accuracy
                        def result = sshCommand remote: remote, command: """
                            cd ${GIT_CLONE_DIR}/code-example
                            python3 evaluation.py
                            """

                        // Parse accuracy from the result
                        def accuracyLine = result.split('\n').find { it.startsWith('Evaluation Accuracy:') }
                        def accuracy = accuracyLine ? accuracyLine.replaceAll('Evaluation Accuracy: ', '').toFloat() : null

                        // Check if accuracy meets quality gate (example: > 80%)
                        if (accuracy != null && accuracy > 0.8) {
                            echo "Accuracy (${accuracy}%) meets the threshold. Proceeding to upload."
                        } else {
                            error "Accuracy (${accuracy}%) is below the threshold. Quality gate failed."
                        }
                    }
                }
            }
        }

        stage('Upload Trained Mode to Nexus') {
                steps {
                    script {
                        // Retrieve the password from Jenkins secret text credentials
                        withCredentials([string(credentialsId: CREDENTIALS_ID, variable: 'SSH_PASS')]) {
                            def remote = [:]
                            remote.name = 'test'
                            remote.host = SSH_SERVER
                            remote.user = SSH_USER
                            remote.password = SSH_PASS
                            remote.allowAnyHosts = true

                            // Construct the upload URL
                            def uploadUrl = "${NEXUS_URL}${NEXUS_REPO_PATH}${env.BUILD_NUMBER}/text_classification_cnn_model.h5"

                            // Use curl to upload the file to Nexus
                            sshCommand remote: remote, command: """
                                curl -v -u admin:admin --upload-file ${MODEL_FILE} ${uploadUrl}
                            """
                        }
                    }
                }
            }
    }
}