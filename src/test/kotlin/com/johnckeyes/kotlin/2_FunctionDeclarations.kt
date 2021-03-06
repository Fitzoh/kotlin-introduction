package com.johnckeyes.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class FunctionDeclarations {

    /**
     * methods are declared with the 'fun' keyword.
     */
    fun voidMethod() {
        assertThat(true).isTrue()
    }




    /**
     * Similar to variables, parameters types are declared after the param name
     */
    fun voidMethod(param: String) {
        assertThat(param).isNotNull()
    }

    /**
     * You can include spaces in method names if you quote them with backticks
     * This is very nice for tests (but should probably only be used there)
     */
    @Test
    fun `call void method`() {
        voidMethod()
        voidMethod("foo")
    }




    /**
     * Similar to variables, method types are declared after the method name
     */
    fun stringMethod(): String {
        return "something"
    }

    @Test
    fun `call String method`() {
        val result = stringMethod()
        assertThat(result).isEqualTo("something")
    }




    /**
     * Parameters can be give default values.
     */
    fun defaultParameters(param: String = "something"): String {
        return param
    }

    @Test
    fun `call default parameters`() {
        val one = defaultParameters()
        assertThat(one).isEqualTo("something")

        val two = defaultParameters("something else")
        assertThat(two).isEqualTo("something else")
    }




    /**
     * When a method is called, parameters can be specified by name
     * allowing them to be provided in any order (see test)
     */
    fun namedParameters(first: String, second: String): String {
        return first + second
    }

    @Test
    fun `call named parameters`() {
        val one = namedParameters("A", "B")
        assertThat(one).isEqualTo("AB")

        val two = namedParameters(first = "A", second = "B")
        assertThat(two).isEqualTo("AB")

        val three = namedParameters(second = "B", first = "A")
        assertThat(three).isEqualTo("AB")
    }




    /**
     * Method bodies can skip the braces if they are a single expression
     */
    fun singleExpressionMethod(vararg list: Int) = list.map { it + 10 }.sum()

    @Test
    fun `call single expression method`() {
        val result = singleExpressionMethod(1, 2, 3)
        assertThat(result).isEqualTo(36)
    }


    /**
     * Functions can have other functions nested inside them to encapsulate logic
     * Inner functions have access to variables from the outer function
     */
    fun outerFunction(message: String) : String{
        fun innerFunction(punctuation: Char): String {
            return "$message$punctuation"
        }
        return "${innerFunction('?')} ${innerFunction('!')}"
    }

    @Test
    fun `call inner function`() {
        val result = outerFunction("Kotlin")
        assertThat(result).isEqualTo("Kotlin? Kotlin!")
    }
}