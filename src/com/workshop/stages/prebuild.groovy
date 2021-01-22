#!/usr/bin/groovy

package com.workshop.stages

import com.workshop.Config
import com.workshop.Pipeline

def details(Pipeline p) {
   println("================\u001b[44mDetails Of Jobs\u001b[0m===============")
   println("\u001b[36mRepository Name : \u001b[0m${p.repository_name}")
   println("\u001b[36mBranch Name : \u001b[0m${p.branch_name}")
   println("\u001b[36mApplication Port : \u001b[0m${p.app_port}")
   println("")
   println("\u001b[36mTesting this PR : \u001b[0m#${p.pr_num} - https://github.com/${p.git_user}/${p.repository_name}/pull/${p.pr_num}")
   println("\u001b[36mMerging to branch : \u001b[0m${p.branch_name}")
}