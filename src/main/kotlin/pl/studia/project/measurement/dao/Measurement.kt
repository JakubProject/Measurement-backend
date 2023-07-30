package pl.studia.project.measurement.dao

import org.apache.tomcat.jni.Local
import java.lang.reflect.Constructor
import java.time.LocalDate
import javax.persistence.*

// KLASA REPREZENTUJĄCA POMIAR
@Entity
@Table(name = "measurement")
data class Measurement (


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(name = "pressure", nullable = false)
    var pressure: String,
    @Column(name = "weight", nullable = false)
    var weight: String,
    @Column(name = "status", nullable = false)
    var status: String,
    @Column(name = "dietType", nullable = false)
    var dietType: String,
    @Column(name = "woman", nullable = false)
    var woman: Boolean,
    @Column(name = "date", nullable = false)
    var date: LocalDate
)