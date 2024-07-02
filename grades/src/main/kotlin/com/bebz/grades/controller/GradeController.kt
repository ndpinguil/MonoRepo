package com.bebz.grades.controller

import com.bebz.grades.model.Grade
import com.bebz.grades.service.GradeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/grades")
class GradeController(private val gradeService: GradeService) {

    @GetMapping
    fun getAllGrades(): ResponseEntity<List<Grade>> = ResponseEntity.ok(gradeService.findAll())

    @GetMapping("/{id}")
    fun getGradeById(@PathVariable id: Long): ResponseEntity<Grade> {
        val grade = gradeService.findById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(grade)
    }

    @PostMapping
    fun createGrade(@RequestBody grade: Grade): ResponseEntity<Grade> = ResponseEntity.ok(gradeService.save(grade))

    @DeleteMapping("/{id}")
    fun deleteGrade(@PathVariable id: Long): ResponseEntity<Void> {
        gradeService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}