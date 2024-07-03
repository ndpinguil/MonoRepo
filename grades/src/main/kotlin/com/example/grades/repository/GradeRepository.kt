package com.example.grades.repository

import com.example.grades.model.Grade
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GradeRepository : JpaRepository<Grade, Long>