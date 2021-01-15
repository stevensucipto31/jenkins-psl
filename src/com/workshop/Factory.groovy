package com.workshop

import com.workshop.Config
import com.workshop.Pipeline

def createConfig() {
	return new Config()
}

def createPipeline() {
	
	def repository_name = ("${env.repository_name}" != "null") ? "${repository_name}" : ""
	def branch_name = ("${env.branch_name}" != "null") ? "${env.branch_name}" : ""
	def git_user = ("${env.git_user}" != "null") ? "${env.git_user}" : ""
	def docker_user = ("${env.docker_user}" != "null") ? "${env.docker_user}" : ""
	def app_port = ("${env.app_port}" != "null") ? "${env.app_port}" : ""
	def pr_num = ("${params.pr_num}" != "null") ? "${params.pr_num}" : ""

	return new Pipeline(repository_name, branch_name, git_user, docker_user, app_port, pr_num)
}

