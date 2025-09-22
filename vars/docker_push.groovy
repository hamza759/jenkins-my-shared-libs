def call (String credId String imageName) {
     withCredentials([usernamePassword(
                    credentialsId:"${credId}",    // .... here i used demohub  .....
                    passwordVariable:"dockerHubPass",
                    usernameVariable:"dockerHubUser"
                    )]){
                sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
                sh "docker image tag "${imageName}" ${env.dockerHubUser}/${imageName} "  // here the the image name is two-tier-flask-app
                sh "docker push ${env.dockerHubUser}/${imageName}"
            }
}
