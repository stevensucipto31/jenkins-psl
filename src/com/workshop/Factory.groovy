package com.workshop

import com.workshop.Config
import com.workshop.Pipeline

class Factory {

  def createConfig(script) {
     return new Config()
  }

  def createPipeline(script) {
    println script
    def repository_name = ("${script.env.repository_name}" != "null") ? "${script.env.repository_name}" : ""
    def branch_name = ("${script.env.branch_name}" != "null") ? "${script.env.branch_name}" : ""
    def git_user = ("${script.env.git_user}" != "null") ? "${script.env.git_user}" : ""
    def docker_user = ("${script.env.docker_user}" != "null") ? "${script.env.docker_user}" : ""
    def app_port = ("${script.env.app_port}" != "null") ? "${script.env.app_port}" : ""
    def pr_num = ("${script.env.pr_num}" != "null") ? "${script.env.pr_num}" : ""

    return new Pipeline(repository_name, branch_name, git_user, docker_user, app_port, pr_num)
  }

}
