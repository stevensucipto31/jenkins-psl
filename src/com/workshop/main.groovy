#!/usr/bin/groovy
package com.workshop

import com.workshop.Config
import com.workshop.stages.*
import com.workshop.Factory

def main(script) {
    // Object initialization
    pipeline = Factory.createPipeline(script)

    // Pipeline object

    ansiColor('xterm') {
        stage('Pre Build Details') {
            println "Details Here..."
	    pipeline.printDetails()
        }

	stage('Checkout & Test') {
	   println "Check,check, 1,2,3"
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
