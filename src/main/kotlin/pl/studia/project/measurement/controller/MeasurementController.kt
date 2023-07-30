package pl.studia.project.measurement.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pl.studia.project.measurement.dao.Measurement
import pl.studia.project.measurement.repository.MeasurementRepository
import pl.studia.project.measurement.service.MeasurementService
import java.time.LocalDate
import java.util.Objects

@RestController
@CrossOrigin("http://localhost:8080/")
class MeasurementController(private val measurementService: MeasurementService, private val
measurementRepository: MeasurementRepository) {



    // LISTA WSZYSTKICH POMIARÓW
    @GetMapping("/measurement")
    fun getAllMeasurement(): List<Measurement> = measurementService.getAllEmployees().subList(measurementRepository.findAll().size-5,
        measurementRepository.findAll().size)

    @GetMapping("/getLast")
    fun getLastMeasurement(): Measurement = measurementRepository.findAll().last()

    @DeleteMapping("/delete")
    fun deleteAll(){
        measurementRepository.deleteAll()
    }

    // DODAJ POMIAR
    @PostMapping("/measurement")
    fun createMeasurement(@RequestBody payload: Measurement): ResponseEntity<Unit> {
        var list = measurementRepository.findAll();
        var last : Measurement? = null;
        if(list.isNotEmpty()){
            last = list.last();
        }

        if(last != null && last.date ==  LocalDate.now()){
            return ResponseEntity.status(400).build();
        }
        return ResponseEntity.status(200).body(measurementService.createEmployee(payload))
    }

}