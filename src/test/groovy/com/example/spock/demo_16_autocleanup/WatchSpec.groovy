package com.example.spock.demo_16_autocleanup

import spock.lang.AutoCleanup
import spock.lang.Specification

import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.WatchKey
import java.nio.file.WatchService
import java.util.concurrent.TimeUnit

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE

class WatchSpec extends Specification {

    @AutoCleanup
    private WatchService watchService = FileSystems.default.newWatchService()

    @AutoCleanup(value = 'delete', quiet = true)
    private WorkDir testPath = new WorkDir('test-dir')

    Path testFile = testPath.path.resolve('test-file')

    def setup() {
        // Register for events when a new file is created in the testPath directory.
        testPath.path.register(watchService, ENTRY_CREATE)
    }

    def "get notification when file is created"() {
        given:
        testFile << 'sample'

        and:
        final WatchKey watchKey = watchService.poll(10, TimeUnit.SECONDS)

        when:
        final events = watchKey.pollEvents()

        then:
        events.size() == 1
        events[0].kind() == ENTRY_CREATE

        cleanup:
        Files.delete(testFile)
    }

}
