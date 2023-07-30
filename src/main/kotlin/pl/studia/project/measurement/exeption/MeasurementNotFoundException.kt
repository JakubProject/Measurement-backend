package pl.studia.project.measurement.exeption

import org.springframework.http.HttpStatus

class MeasurementNotFoundException(val statusCode: HttpStatus, val reason: String) : Exception()