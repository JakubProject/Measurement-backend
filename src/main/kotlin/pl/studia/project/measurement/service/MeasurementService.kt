package pl.studia.project.measurement.service

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import pl.studia.project.measurement.dao.Measurement
import pl.studia.project.measurement.exeption.MeasurementNotFoundException
import pl.studia.project.measurement.repository.MeasurementRepository
import java.time.LocalDate


// LOGIKA BIZNESOWA APLIKACJI DO POMIARÓW
@Service
class MeasurementService(private val measurementRepository: MeasurementRepository) {

    fun getAllEmployees(): List<Measurement> = measurementRepository.findAll()

    fun getEmployeesById(employeeId: Long): Measurement = measurementRepository.findById(employeeId)
        .orElseThrow { MeasurementNotFoundException(HttpStatus.NOT_FOUND, "No matching employee was found") }

    fun createEmployee(employee: Measurement) {
        employee.date = LocalDate.now()
        measurementRepository.save(employee)
    }

    fun updateEmployeeById(employeeId: Long, employee: Measurement): Measurement {
         if (measurementRepository.existsById(employeeId)) {
            var updateClient = measurementRepository.getById(employeeId)
            updateClient.weight = employee.weight;
            updateClient.pressure = employee.pressure;
            updateClient.status = employee.status
            updateClient.woman = employee.woman
            return measurementRepository.save(
               updateClient
            )
        } else throw MeasurementNotFoundException(HttpStatus.NOT_FOUND, "No matching client was found")
    }

    fun deleteEmployeesById(employeeId: Long) {
        return if (measurementRepository.existsById(employeeId)) {
            measurementRepository.deleteById(employeeId)
        } else throw MeasurementNotFoundException(HttpStatus.NOT_FOUND, "No matching client was found")
    }
}