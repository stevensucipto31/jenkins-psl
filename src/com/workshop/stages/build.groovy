#!/usr/bin/groovy
package com.workshop.stages

import com.workshop.Pipeline
import com.workshop.Config

def bakeImage(Pipeline pipeline) {
    config = new Config()

    docker.withTool("${config.default_docker_jenkins_tool}") {
       docker.withRegistry("${config.default_docker_registry}", "${config.default_docker_registry_jenkins_credential}") {
           def image = docker.build("${pipeline.docker_username}/${pipeline.repository_name}:build-$BUILD_NUMBER")
           image.push()
           image.push('latest')
       }
   }
}
