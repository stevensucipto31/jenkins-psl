#!/usr/bin/groovy
package com.workshop

import com.workshop.Config
import com.workshop.stages.*
import com.workshop.Factory

def main(script) {
    // Object initialization
    factory = new Factory()
	prebuildStage = new prebuild()

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
		}

		stage('Merge') {
			println "Merge Code"
		}

		stage('Deploy') {
			println "Deliver to the world"
		}
    }
}
return this
