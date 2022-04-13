package br.com.systemsgs.mapper

interface Mapper<T, U> {

    fun map(t: T) :U

}
