package com.workshop

import com.workshop.Config
import com.workshop.Pipeline

def createConfig() {
	return new Config()
}

def createPipeline() {
	def repository_name = ("${repository_name}" != "null") ? "${repository_name}" : ""
	def branch_name = ("${branch_name}" != "null") ? "${branch_name}" : ""
	def git_user = ("${git_user}" != "null") ? "${git_user}" : ""
	def docker_user = ("${docker_user}" != "null") ? "${docker_user}" : ""
	def app_port = ("${app_port}" != "null") ? "${app_port}" : ""
	def pr_num = ("${params.pr_num}" != "null") ? "${params.pr_num}" : ""

	return new Pipeline(repository_name, branch_name, git_user, docker_user, app_port, pr_num)
}

