package com.ramu.showcase.service.impl;

import com.ramu.showcase.dto.ProjectCreateDto;
import com.ramu.showcase.dto.ProjectDto;
import com.ramu.showcase.exception.ResourceNotFoundException;
import com.ramu.showcase.model.Project;
import com.ramu.showcase.repository.ProjectRepository;
import com.ramu.showcase.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repo;

    @Autowired
    public ProjectServiceImpl(ProjectRepository repo) {
        this.repo = repo;
    }

    @Override
    public ProjectDto create(ProjectCreateDto dto) {
        Project p = new Project(dto.getTitle(), dto.getDescription(), dto.getTechStack(), dto.getRepoUrl(), dto.getLiveUrl());
        Project saved = repo.save(p);
        return toDto(saved);
    }

    @Override
    public ProjectDto update(Long id, ProjectCreateDto dto) {
        Project existing = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found: " + id));
        existing.setTitle(dto.getTitle());
        existing.setDescription(dto.getDescription());
        existing.setTechStack(dto.getTechStack());
        existing.setRepoUrl(dto.getRepoUrl());
        existing.setLiveUrl(dto.getLiveUrl());
        Project saved = repo.save(existing);
        return toDto(saved);
    }

    @Override
    public void delete(Long id) {
        Project existing = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project not found: " + id));
        repo.delete(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectDto getById(Long id) {
        return repo.findById(id).map(this::toDto).orElseThrow(() -> new ResourceNotFoundException("Project not found: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectDto> getAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProjectDto> getPage(Pageable pageable) {
        return repo.findAll(pageable).map(this::toDto);
    }

    private ProjectDto toDto(Project p) {
        return new ProjectDto(p.getId(), p.getTitle(), p.getDescription(), p.getTechStack(), p.getRepoUrl(), p.getLiveUrl());
    }
}
