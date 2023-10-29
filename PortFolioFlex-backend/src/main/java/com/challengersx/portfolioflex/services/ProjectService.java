package com.challengersx.portfolioflex.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challengersx.portfolioflex.entities.Project;
import com.challengersx.portfolioflex.entities.ProjectImage;
import com.challengersx.portfolioflex.repository.ProjectImageRepository;
import com.challengersx.portfolioflex.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ProjectImageRepository projectImageRepository;

	public Project createProject(Project project) {
		Project createdProject = projectRepository.save(project);
		List<ProjectImage> createdProjectImagesList = new ArrayList<ProjectImage>();
		for (ProjectImage projectImage : project.getProjectImages()) {
			projectImage.setProject(project);
			createdProjectImagesList.add(projectImage);
		}
		projectImageRepository.saveAll(createdProjectImagesList);
		return createdProject;
	}

	public Project getProject(Long id) {
		return projectRepository.findById(id).orElse(null);
	}

	public Project updateProject(Long id, Project project) {
		List<ProjectImage> projectImageList = project.getProjectImages();
		for (ProjectImage projectImage : projectImageList) {
			projectImage.setProject(project);
			projectImageRepository.save(projectImage);
		}
		if (projectRepository.existsById(id)) {
			project.setId(id);
			return projectRepository.save(project);
		}
		return null; // Not found
	}

	public boolean deleteProject(Long id) {
		if (projectRepository.existsById(id)) {
			projectRepository.deleteById(id);
			return true;
		}
		return false; // Not found
	}

	public List<ProjectImage> createProjectImage(Project project) {
		List<ProjectImage> createdProjectImagesList = new ArrayList<ProjectImage>();
		for (ProjectImage projectImage : project.getProjectImages()) {
			projectImage.setProject(project);
			createdProjectImagesList.add(projectImage);
		}
		return projectImageRepository.saveAll(createdProjectImagesList);
	}

	public Project updateProjectImage(Long id, ProjectImage projectImage) {
		
		Project project = getProject(id);
		if(project != null) {			
			projectImage.setProject(project);
			if(project.getProjectImages().add(projectImage)) {
				projectImageRepository.save(projectImage);
				return projectRepository.save(project);
			}
		}
		return null;
	}
	
	public Project updateProjectImages(Long id, List<ProjectImage> projectImages) {
		Project project = getProject(id);
		if(project != null) {
			for (ProjectImage projectImage : projectImages) {
				projectImage.setProject(project);
				projectImageRepository.save(projectImage);
			}
			return project;
		}

		return null; // Not found
	}
	
}
