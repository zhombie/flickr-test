package net.kelmer.android.utils

import java.lang.Exception

class HttpException(val code: Int, message: String) : Exception(message) {
}