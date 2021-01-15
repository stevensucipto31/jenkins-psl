package com.workshop

import com.workshop.Config

class Pipeline {
    // Set pipeline struct
    String repositoryName
    String branchName
    String gitUsername
    String dockerUsername
    String appPort
    String pullRequestNumber

    Pipeline(String repositoryName, String branchName, String gitUsername, String dockerUsername, String appPort, String pullRequestNumber){
        this.repositoryName = repositoryName
        this.branchName = branchName
        this.gitUsername = gitUsername
        this.dockerUsername = dockerUsername
        this.appPort = appPort
        this.pullRequestNumber = pullRequestNumber
    }
    
    def printDetails() {
        println("Repository Name: ${repositoryName}")
        println("Branch Name: ${branchName}")
        println("Git Username: ${gitUsername}")
        println("Docker Username: ${dockerUsername}")
        println("Pull Request Number: ${pullRequestNumber}")
    }
}
