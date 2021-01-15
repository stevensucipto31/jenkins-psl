#!/usr/bin/groovy
package com.workshop

class Config {
    // Place Default Variable Here
    // Docker related default variable
   def default_docker_jenkins_tool = 'docker'
   def default_docker_registry = "https://hub.docker.com"
   def default_docker_registry_jenkins_credential = "docker-credentials"
 
   // Golang related default variable
   def default_golang_base_image = "tobapramudia/tkpd-demo:onbuild"

}