package com.bebz.students.controller

import com.bebz.students.model.Student
import com.bebz.students.service.StudentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/students")
class StudentController(private val studentService: StudentService) {

    @GetMapping
    fun getAllStudents(): ResponseEntity<List<Student>> = ResponseEntity.ok(studentService.findAll())

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long): ResponseEntity<Student> {
        val student = studentService.findById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(student)
    }

    @PostMapping
    fun createStudent(@RequestBody student: Student): ResponseEntity<Student> = ResponseEntity.ok(studentService.save(student))

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Long): ResponseEntity<Void> {
        studentService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}