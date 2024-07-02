package com.bebz.grades.service

import com.bebz.grades.model.Grade
import com.bebz.grades.repository.GradeRepository
import org.springframework.stereotype.Service

@Service
class GradeService(private val gradeRepository: GradeRepository) {

    fun findAll(): List<Grade> = gradeRepository.findAll()

    fun findById(id: Long): Grade? = gradeRepository.findById(id).orElse(null)

    fun save(grade: Grade): Grade = gradeRepository.save(grade)

    fun deleteById(id: Long) = gradeRepository.deleteById(id)
}