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
	println("Repository Name: ${this.repositoryName}")
	println("Branch Name: ${this.branchName}")
	println("Git Username: ${this.gitUsername}")
	println("Docker Username: ${this.dockerUsername}")
	println("Pull Request Number: ${this.pullRequestNumber}")
    }
}
