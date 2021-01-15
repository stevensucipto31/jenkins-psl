#!/usr/bin/groovy
package com.workshop.stages

import com.workshop.Pipeline

def healthcheck(Pipeline p) {
    def hostIp = sh script: "ip route show | awk '/default/ {print \$3}' | tr -d '\n'", returnStdout: true
 
    timeout(time: 30, unit: 'SECONDS'){
        waitUntil(quiet: true) {
            def response = sh script: "curl ${hostIp}:${pipeline.app_port}/ping", returnStdout: true
            if (response != "pong!"){
                error("ERROR102 - Service is Unhealthy for last ${p.timeout_hc} Second")
            } else {
                println "Service is Healthy :D"
                return true
            }
        }
    }
}

def cleanup(Pipeline pipeline) {
   withEnv(["PATH+DOCKER=${pipeline.docker_tool}/bin"]){
       def output = sh script: "docker rmi \$(docker images | grep -Ev 'latest|${BUILD_NUMBER}' | awk '/${pipeline.docker_username}\\/${pipeline.repository_name}/ {print \$1\":\"\$2}')", returnStdout: true
       println "Remove old Image"
       println output
   }
}
