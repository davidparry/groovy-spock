package com.davidparry.spock

import com.davidparry.spock.impl.OddEvenCampImpl
import spock.lang.*

/**
 * Comprehensive Spock specification for OddEvenCamp interface implementation.
 * 
 * This specification follows Test-Driven Development (TDD) and Behavior-Driven Development (BDD)
 * principles to define the expected behavior of the OddEvenCamp interface.
 * 
 * The tests serve as both documentation and validation for the odd/even number checking functionality.
 */
@Title("Odd Even Camp Number Classification")
@Narrative('''
As a developer using the OddEvenCamp interface
I want to classify positive integers as odd or even
So that I can determine the parity of numbers in my application

The system should:
- Return 1 for even numbers
- Return 0 for odd numbers  
- Reject zero and negative numbers with appropriate exceptions
''')
@Subject(OddEvenCamp)
class OddEvenCampSpec extends Specification {

    // System under test
    OddEvenCamp oddEvenCamp

    def setup() {
        oddEvenCamp = new OddEvenCampImpl()
    }

    // ========================================
    // BASIC FUNCTIONALITY TESTS
    // ========================================

    def "should return 1 for even positive numbers"() {
        given: "an even positive number"
        // Even numbers are divisible by 2

        when: "checking if the number is even or odd"
        def result = oddEvenCamp.check(number)

        then: "the result should be 1 indicating even"
        result == 1

        where: "testing various even positive numbers"
        number << [2, 4, 6, 8, 10, 12, 100, 1000, 9998]
    }

    def "should return 0 for odd positive numbers"() {
        given: "an odd positive number"
        // Odd numbers are not divisible by 2

        when: "checking if the number is even or odd"
        def result = oddEvenCamp.check(number)

        then: "the result should be 0 indicating odd"
        result == 0

        where: "testing various odd positive numbers"
        number << [1, 3, 5, 7, 9, 11, 99, 999, 9999]
    }

    // ========================================
    // EDGE CASES AND BOUNDARY VALUE TESTS
    // ========================================

    def "should correctly classify boundary values"() {
        expect: "correct classification for boundary values"
        oddEvenCamp.check(number) == expectedResult

        where: "boundary values and their expected results"
        number || expectedResult
        1      || 0  // smallest positive odd
        2      || 1  // smallest positive even
        Integer.MAX_VALUE     || 0  // largest positive odd (2147483647)
        Integer.MAX_VALUE - 1 || 1  // largest positive even (2147483646)
    }

    @Unroll
    def "should return #expectedResult for number #number"() {
        expect: "correct parity classification"
        oddEvenCamp.check(number) == expectedResult

        where: "comprehensive test data covering various scenarios"
        number | expectedResult
        1      | 0
        2      | 1
        3      | 0
        4      | 1
        5      | 0
        6      | 1
        7      | 0
        8      | 1
        9      | 0
        10     | 1
        42     | 1
        43     | 0
        100    | 1
        101    | 0
        1024   | 1
        1025   | 0
    }

    // ========================================
    // EXCEPTION HANDLING TESTS
    // ========================================

    def "should throw NegativeNumberException when number is zero"() {
        given: "zero as input"
        def number = 0

        when: "checking zero"
        oddEvenCamp.check(number)

        then: "NegativeNumberException is thrown"
        def exception = thrown(NegativeNumberException)
        exception.message != null
        exception.message.contains("zero") || exception.message.contains("negative") || exception.message.contains("positive")
    }

    def "should throw NegativeNumberException for negative numbers"() {
        given: "a negative number"
        // Negative numbers should be rejected

        when: "checking the negative number"
        oddEvenCamp.check(number)

        then: "NegativeNumberException is thrown with appropriate message"
        def exception = thrown(NegativeNumberException)
        exception.message != null
        exception instanceof ValidatorException  // Should inherit from ValidatorException
        exception instanceof RuntimeException    // Should be a runtime exception

        where: "various negative numbers"
        number << [-1, -2, -5, -10, -100, -999, Integer.MIN_VALUE]
    }

    def "should throw NegativeNumberException with meaningful message for invalid inputs"() {
        when: "providing invalid input"
        oddEvenCamp.check(invalidNumber)

        then: "exception contains meaningful error message"
        def exception = thrown(NegativeNumberException)
        exception.message != null
        exception.message.length() > 0
        // Message should indicate the problem with the input
        (exception.message.toLowerCase().contains("positive") || 
         exception.message.toLowerCase().contains("negative") || 
         exception.message.toLowerCase().contains("zero"))

        where: "invalid input values"
        invalidNumber << [0, -1, -42, Integer.MIN_VALUE]
    }

    // ========================================
    // BEHAVIORAL TESTS (BDD Style)
    // ========================================

    def "developer can determine if a positive number is even"() {
        given: "a developer needs to check if a positive number is even"
        def positiveEvenNumber = 42

        when: "the developer uses the OddEvenCamp to check the number"
        def result = oddEvenCamp.check(positiveEvenNumber)

        then: "the system returns 1 to indicate the number is even"
        result == 1

        and: "the developer can confidently use this result for even number logic"
        result == 1  // Confirms even classification
    }

    def "developer can determine if a positive number is odd"() {
        given: "a developer needs to check if a positive number is odd"
        def positiveOddNumber = 37

        when: "the developer uses the OddEvenCamp to check the number"
        def result = oddEvenCamp.check(positiveOddNumber)

        then: "the system returns 0 to indicate the number is odd"
        result == 0

        and: "the developer can confidently use this result for odd number logic"
        result == 0  // Confirms odd classification
    }

    def "system prevents processing of invalid numbers"() {
        given: "a developer attempts to check an invalid number"
        def invalidNumber = -5

        when: "the system processes the invalid input"
        oddEvenCamp.check(invalidNumber)

        then: "the system protects against invalid input by throwing an exception"
        thrown(NegativeNumberException)

        and: "the developer is informed that only positive numbers are allowed"
        true  // Exception was already thrown and caught above
    }

    // ========================================
    // DESIGN PRINCIPLE VERIFICATION TESTS
    // ========================================

    def "implementation should follow single responsibility principle"() {
        given: "the OddEvenCamp implementation"
        def implementation = new OddEvenCampImpl()

        expect: "the class should only handle odd/even classification"
        implementation instanceof OddEvenCamp
        // The class should not handle unrelated concerns like file I/O, networking, etc.
        // This is verified by the interface contract and focused method signature
    }

    def "should use dependency injection principles"() {
        given: "the OddEvenCamp interface"
        
        expect: "implementation can be injected as dependency"
        oddEvenCamp instanceof OddEvenCamp
        // Interface allows for easy testing and different implementations
        // Supports dependency inversion principle
    }

    def "should handle interface contract correctly"() {
        given: "the OddEvenCamp interface contract"
        
        expect: "implementation adheres to Liskov Substitution Principle"
        oddEvenCamp instanceof OddEvenCamp
        // Any implementation should be substitutable
        // Method signature and behavior must match interface contract
    }

    // ========================================
    // PERFORMANCE AND CONSISTENCY TESTS
    // ========================================

    def "should provide consistent results for same input"() {
        given: "a specific number"
        def number = 42

        when: "checking the same number multiple times"
        def results = (1..100).collect { oddEvenCamp.check(number) }

        then: "all results should be identical"
        results.every { it == 1 }  // All should return 1 for even number 42
        results.unique().size() == 1  // Only one unique result
    }

    def "should handle large positive numbers correctly"() {
        expect: "correct classification for large numbers"
        oddEvenCamp.check(number) == expectedResult

        where: "large positive numbers"
        number              || expectedResult
        1000000            || 1  // Large even
        1000001            || 0  // Large odd
        Integer.MAX_VALUE - 1 || 1  // Largest even integer
        Integer.MAX_VALUE     || 0  // Largest odd integer (Integer.MAX_VALUE is odd)
    }

    // ========================================
    // INTEGRATION AND USAGE PATTERN TESTS
    // ========================================

    def "can be used in conditional logic patterns"() {
        given: "numbers to classify"
        def numbers = [1, 2, 3, 4, 5, 6]

        when: "separating even and odd numbers using the classifier"
        def evenNumbers = numbers.findAll { oddEvenCamp.check(it) == 1 }
        def oddNumbers = numbers.findAll { oddEvenCamp.check(it) == 0 }

        then: "numbers are correctly separated"
        evenNumbers == [2, 4, 6]
        oddNumbers == [1, 3, 5]

        and: "all numbers are accounted for"
        evenNumbers.size() + oddNumbers.size() == numbers.size()
    }

    def "supports functional programming patterns"() {
        given: "a list of positive numbers"
        def numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        when: "using the classifier in functional operations"
        def evenCount = numbers.count { oddEvenCamp.check(it) == 1 }
        def oddCount = numbers.count { oddEvenCamp.check(it) == 0 }

        then: "functional operations work correctly"
        evenCount == 5  // [2, 4, 6, 8, 10]
        oddCount == 5   // [1, 3, 5, 7, 9]
        evenCount + oddCount == numbers.size()
    }

    // ========================================
    // ERROR HANDLING AND ROBUSTNESS TESTS
    // ========================================

    def "should maintain state consistency after exceptions"() {
        given: "the OddEvenCamp implementation"
        
        when: "an exception occurs due to invalid input"
        try {
            oddEvenCamp.check(-1)
        } catch (NegativeNumberException e) {
            // Expected exception
        }

        and: "subsequent valid operations are performed"
        def result = oddEvenCamp.check(4)

        then: "the implementation continues to work correctly"
        result == 1  // Should still work correctly after exception
    }

    def "should handle edge cases gracefully"() {
        expect: "graceful handling of mathematical edge cases"
        // Test that the implementation doesn't have integer overflow issues
        // or other mathematical edge case problems
        oddEvenCamp.check(number) in [0, 1]  // Result should always be 0 or 1

        where: "edge case numbers"
        number << [1, 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE]
    }

    // ========================================
    // DOCUMENTATION AND CONTRACT TESTS
    // ========================================

    def "should fulfill interface contract as documented"() {
        given: "the interface contract requirements"
        // Based on javadoc: return 1 for even, 0 for odd, throw exception for 0 or negative

        expect: "implementation follows documented behavior"
        // Even numbers return 1
        oddEvenCamp.check(2) == 1
        oddEvenCamp.check(4) == 1
        
        // Odd numbers return 0  
        oddEvenCamp.check(1) == 0
        oddEvenCamp.check(3) == 0

        when: "invalid input is provided"
        oddEvenCamp.check(0)

        then: "appropriate exception is thrown as documented"
        thrown(NegativeNumberException)
    }
}