package com.example.grades.controller

import com.example.grades.model.Grade
import com.example.grades.service.GradeService
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
@RequestMapping("/grades")
class GradeController @Autowired constructor(
    private val gradeService: GradeService
) {

    @GetMapping
    fun getAllGrades(): List<Grade> = gradeService.getAllGrades()

    @GetMapping("/{id}")
    fun getGradeById(@PathVariable id: Long): ResponseEntity<Grade> {
        return gradeService.getGradeById(id).map { grade ->
            ResponseEntity.ok(grade)
        }.orElseGet { ResponseEntity.notFound().build() }
    }

    @PostMapping
    fun createGrade(@RequestBody grade: Grade): Grade = gradeService.createGrade(grade)

    @PutMapping("/{id}")
    fun updateGrade(@PathVariable id: Long, @RequestBody updatedGrade: Grade): ResponseEntity<Grade> {
        return gradeService.updateGrade(id, updatedGrade).map { grade ->
            ResponseEntity.ok(grade)
        }.orElseGet { ResponseEntity.notFound().build() }
    }

    @DeleteMapping("/{id}")
    fun deleteGrade(@PathVariable id: Long): ResponseEntity<Void> {
        return gradeService.getGradeById(id).map {
            gradeService.deleteGrade(id)
            ResponseEntity<Void>(HttpStatus.NO_CONTENT)
        }.orElseGet { ResponseEntity.notFound().build() }
    }
}