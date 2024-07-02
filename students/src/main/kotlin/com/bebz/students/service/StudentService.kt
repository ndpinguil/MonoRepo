package com.bebz.students.service

import com.bebz.students.model.Student
import com.bebz.students.repository.StudentRepository
import org.springframework.stereotype.Service

@Service
class StudentService(private val studentRepository: StudentRepository) {

    fun findAll(): List<Student> = studentRepository.findAll()

    fun findById(id: Long): Student? = studentRepository.findById(id).orElse(null)

    fun save(student: Student): Student = studentRepository.save(student)

    fun deleteById(id: Long) = studentRepository.deleteById(id)
}