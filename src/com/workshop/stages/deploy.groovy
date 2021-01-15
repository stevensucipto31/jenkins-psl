package com.workshop.stages

import com.workshop.Pipeline
import com.workshop.Config

def dockerTool = tool name: 'docker', type: 'dockerTool'

def deploy(Pipeline pipeline) {
   config = new Config()
 
   withEnv(["PATH+DOCKER=${dockerTool}/bin"]){
       println "Take Down previous Deployment"
       def response = sh script: "docker rm -f \$(docker ps -aq -f 'name=${pipeline.repository_name}') &> /dev/null", returnStatus: true
       if ("${response}" == "0") {
           println("Successfuly removing old container")
       } else {
           println("Old version removed")
       }
   }
 
   docker.withTool("${config.default_docker_jenkins_tool}") {
       def image = docker.image("${pipeline.docker_username}/${pipeline.repository_name}:build-$BUILD_NUMBER")
       image.run("--name ${pipeline.repository_name}-$BUILD_NUMBER -p ${pipeline.app_port}:${pipeline.app_port}")
   }
}
