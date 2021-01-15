#!/usr/bin/groovy
package com.workshop

import com.workshop.Config
import com.workshop.stages.*
import com.workshop.Factory

def main(script) {
    // Object initialization
    factory = new Factory()
	prebuildStage = new prebuild()
	build = new build()
	postbuild = new postbuild()
	deployment = new deploy()
	postdeploy = new postdeploy()

    // Pipeline object
    pipeline = factory.createPipeline()

    ansiColor('xterm') {
        stage('Pre Build Details') {
            println "Details Here..."
	    	prebuildStage.details(pipeline)
			prebuildStage.validation(pipeline)
        }

		stage('Checkout & Test') {
			println "Check,check, 1,2,3"
			prebuildStage.checkoutBuildTest(pipeline)
		}

		stage('Build & Push Image to Registry') {
			println "Baking image"
			build.bakeImage(pipeline)
		}

		stage('Merge') {
			println "Merge Code"
			postbuild.merge(pipeline)
		}

		stage('Deploy') {
			println "Deliver to the world"
			deployment.deploy(pipeline)
		}

		stage('health check') {
			postdeploy.healthcheck(pipeline)
		}

		stage('Cleanup') {
			postdeploy.cleanup(pipeline)
		}
    }
}
return this
