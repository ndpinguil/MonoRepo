package com.example.students.Controller

import com.example.students.model.Student
import com.example.students.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/students")
class StudentController @Autowired constructor(
    private val studentService: StudentService
) {

    @GetMapping
    fun getAllStudents(): List<Student> = studentService.getAllStudents()

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long): ResponseEntity<Student> {
        return studentService.getStudentById(id).map { student ->
            ResponseEntity.ok(student)
        }.orElseGet { ResponseEntity.notFound().build() }
    }

    @PostMapping
    fun createStudent(@RequestBody student: Student): Student = studentService.createStudent(student)

    @PutMapping("/{id}")
    fun updateStudent(@PathVariable id: Long, @RequestBody updatedStudent: Student): ResponseEntity<Student> {
        return studentService.updateStudent(id, updatedStudent).map { student ->
            ResponseEntity.ok(student)
        }.orElseGet { ResponseEntity.notFound().build() }
    }

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Long): ResponseEntity<Void> {
        return studentService.getStudentById(id).map {
            studentService.deleteStudent(id)
            ResponseEntity<Void>(HttpStatus.NO_CONTENT)
        }.orElseGet { ResponseEntity.notFound().build() }
    }
}