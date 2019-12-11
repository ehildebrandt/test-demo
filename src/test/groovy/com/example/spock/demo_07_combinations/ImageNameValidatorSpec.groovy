package com.example.spock.demo_07_combinations

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class ImageNameValidatorSpec extends Specification {

    @Subject
    ImageNameValidator imageNameValidator = new ImageNameValidator();

    @Unroll("checking image name #pictureFile")
    def "should accept all kinds of JPEG extensions"() {
        expect:
        imageNameValidator.isValidImageExtension(pictureFile)

        where:
        pictureFile << GroovyCollections.combinations([["sample.", "Sample.", "SAMPLE."], ["j", "J"], ["p", "P"], ["", "e", "E"], ["g", "G"]])*.join()
    }

    @Unroll("checking image name #pictureFile")
    def "should not accept all kinds of other extensions"() {
        expect:
        !imageNameValidator.isValidImageExtension(pictureFile)

        where:
        pictureFile << GroovyCollections.combinations([["sample.", "Sample.", "SAMPLE."], ["gif", "PNG", "pDf", "doc", "docx"]])*.join()
    }

}
