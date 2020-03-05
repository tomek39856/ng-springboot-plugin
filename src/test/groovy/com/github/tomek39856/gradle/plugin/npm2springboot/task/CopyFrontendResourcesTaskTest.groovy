package com.github.tomek39856.gradle.plugin.npm2springboot.task

import com.github.tomek39856.gradle.plugin.npm2springboot.NgSpringBootPlugin
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification

import static java.io.File.*

class CopyFrontendResourcesTaskTest extends Specification {

    public static final String PROJECT_DIRECTORY = "projectDir"

    def "should configure destination directory"() {
        given:
        def project = ProjectBuilder
                .builder()
                .withName("testProject")
                .withProjectDir(new File(PROJECT_DIRECTORY))
                .build()

        when:
        new NgSpringBootPlugin().apply(project)
        def copyFrontendResourcesTask = project.getTasksByName(CopyFrontendResourcesTask.TASK_NAME, true)[0]

        then:
        def destinationDir = copyFrontendResourcesTask.rootSpec.destinationDir.toString()
        destinationDir.contains(
                PROJECT_DIRECTORY + separator +
                        'build' + separator +
                        'resources' + separator +
                        'main' + separator +
                        'static'
        );
    }

    def "should configure source directory"() {
        given:
        def project = ProjectBuilder
                .builder()
                .withName("testProject")
                .withProjectDir(new File(PROJECT_DIRECTORY))
                .build()
        def webAppProjectName = 'web'

        when:
        new NgSpringBootPlugin().apply(project)
        def copyFrontendResourcesTask = project.getTasksByName(CopyFrontendResourcesTask.TASK_NAME, true)[0]

        then:
        def sourceDir = copyFrontendResourcesTask.mainSpec.sourcePaths[0]
        sourceDir == webAppProjectName + separator + 'dist' + separator + webAppProjectName
    }

    def "should configure dependency on npmBuild task"() {
        given:
        def project = ProjectBuilder
                .builder()
                .withName("testProject")
                .withProjectDir(new File(PROJECT_DIRECTORY))
                .build()

        when:
        new NgSpringBootPlugin().apply(project)
        def copyFrontendResourcesTask = project.getTasksByName(CopyFrontendResourcesTask.TASK_NAME, true)[0]


        then:
        copyFrontendResourcesTask.dependsOn.contains(NpmBuildTask.TASK_NAME)
    }
}
