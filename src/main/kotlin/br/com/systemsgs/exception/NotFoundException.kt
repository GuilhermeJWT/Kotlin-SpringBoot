package br.com.systemsgs.exception

import java.lang.RuntimeException

class NotFoundException(message: String?): RuntimeException(message) {

}