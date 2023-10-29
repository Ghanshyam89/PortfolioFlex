package com.challengersx.portfolioflex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challengersx.portfolioflex.entities.Project;
import com.challengersx.portfolioflex.entities.ProjectImage;
import com.challengersx.portfolioflex.entities.UserProfile;
import com.challengersx.portfolioflex.services.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	@PostMapping
	public ResponseEntity<Project> createProject(@RequestBody Project project) {
		Project createdProject = projectService.createProject(project);
		projectService.createProjectImage(project);
		return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Project> getProject(@PathVariable Long id) {
		Project project = projectService.getProject(id);
		if (project != null) {
			return new ResponseEntity<>(project, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
		Project updatedProject = projectService.updateProject(id, project);
//		projectService.updateProjectImage(project);
		if (updatedProject != null) {
			return new ResponseEntity<>(updatedProject, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
		if (projectService.deleteProject(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

//	End-point to Add image in project 
	@PostMapping("/{id}/addimage")
	public ResponseEntity<Project> updateProfileImage(@PathVariable Long id, @RequestBody ProjectImage projectImage) {
		Project updatedProject = projectService.updateProjectImage(id, projectImage);
		if (updatedProject != null) {
			return new ResponseEntity<>(updatedProject, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
//	End-point to Add images in project 
	@PostMapping("/{id}/addimages")
	public ResponseEntity<Project> updateProfileImages(@PathVariable Long id, @RequestBody List<ProjectImage> projectImages) {
		Project updatedProject = projectService.updateProjectImages(id, projectImages);
		if (updatedProject != null) {
			return new ResponseEntity<>(updatedProject, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
