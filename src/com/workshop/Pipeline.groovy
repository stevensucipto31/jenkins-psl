package com.workshop

import com.workshop.Config

class Pipeline {
    // Set pipeline struct
    String repository_name
    String branch_name
    String git_user
    String docker_user
    String app_port
    String pr_num
    String docker_tool
    String timeout_hc

    Pipeline(String repository_name, String branch_name, String git_user, String docker_user, String app_port, String pr_num, String docker_tool, String timeout_hc){
        this.repository_name = repository_name
        this.branch_name = branch_name
        this.git_user = git_user
        this.docker_user = docker_user
        this.app_port = app_port
        this.pr_num = pr_num
        this.docker_tool = docker_tool
        this.timeout_hc = timeout_hc
    }
}
