package com.example.grades.service

import com.example.grades.model.Grade
import com.example.grades.repository.GradeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class GradeService @Autowired constructor(
    private val gradeRepository: GradeRepository
) {

    fun getAllGrades(): List<Grade> = gradeRepository.findAll()

    fun getGradeById(id: Long): Optional<Grade> = gradeRepository.findById(id)

    fun createGrade(grade: Grade): Grade = gradeRepository.save(grade)

    fun updateGrade(id: Long, updatedGrade: Grade): Optional<Grade> {
        return gradeRepository.findById(id).map { existingGrade ->
            val gradeToUpdate = existingGrade.copy(
                course = updatedGrade.course,
                subject = updatedGrade.subject
            )
            gradeRepository.save(gradeToUpdate)
        }
    }

    fun deleteGrade(id: Long) {
        gradeRepository.deleteById(id)
    }
}