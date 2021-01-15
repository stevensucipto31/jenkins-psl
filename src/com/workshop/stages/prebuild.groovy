#!/usr/bin/groovy

package com.workshop.stages

import com.workshop.Config
import com.workshop.Pipeline

def details(Pipeline p) {
   println("Repository Name : ${p.repository_name}")
   println("Branch Name : ${p.branch_name}")
   println("Application Port : ${p.app_port}")
   println("")
   println("Testing this PR : #${p.pr_num} - https://github.com/${p.git_username}/${p.repository_name}/pull/${p.pr_num}")
   println("Merging to branch : ${p.branch_name}")
}

def validation(Pipeline p) {
   if(!p.repository_name) {
       "Repository name can't be empty"
       error("ERROR101 - MISSING REPOSITORY_NAME")
   }
   if(!p.branch_name) {
       "Branch name can't be empty"
       error("ERROR101 - MISSING BRANCH_NAME")
   }
   if(!p.app_port) {
       "Application port can't be empty"
       error("ERROR101 - MISSING APP_PORT")
   }
   if(!p.pr_num) {
       "PR Number can't be empty"
       error("ERROR101 - MISSING PR_NUM")
   }
}
