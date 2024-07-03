package com.example.students.service

import com.example.students.model.Student
import com.example.students.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class StudentService @Autowired constructor(
    private val studentRepository: StudentRepository
) {

    fun getAllStudents(): List<Student> = studentRepository.findAll()

    fun getStudentById(id: Long): Optional<Student> = studentRepository.findById(id)

    fun createStudent(student: Student): Student = studentRepository.save(student)

    fun updateStudent(id: Long, updatedStudent: Student): Optional<Student> {
        return studentRepository.findById(id).map { existingStudent ->
            val studentToUpdate = existingStudent.copy(
                firstName = updatedStudent.firstName,
                lastName = updatedStudent.lastName,
                email = updatedStudent.email
            )
            studentRepository.save(studentToUpdate)
        }
    }

    fun deleteStudent(id: Long) {
        studentRepository.deleteById(id)
    }
}