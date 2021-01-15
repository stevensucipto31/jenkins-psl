package com.workshop

import com.workshop.Config

class Pipeline {
    // Set pipeline struct
    String repository_name
    String branch_name
    String git_username
    String docker_username
    String app_port
    String pr_num
    String docker_tool

    Pipeline(String repository_name, String branch_name, String git_username, String docker_username, String app_port, String pr_num, String docker_tool){
        this.repository_name = repository_name
        this.branch_name = branch_name
        this.git_username = git_username
        this.docker_username = docker_username
        this.app_port = app_port
        this.pr_num = pr_num
        this.docker_tool = docker_tool
    }
}
