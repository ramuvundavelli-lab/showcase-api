package com.ramu.showcase.service;

import com.ramu.showcase.dto.ProjectCreateDto;
import com.ramu.showcase.dto.ProjectDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
    ProjectDto create(ProjectCreateDto dto);
    ProjectDto update(Long id, ProjectCreateDto dto);
    void delete(Long id);
    ProjectDto getById(Long id);
    List<ProjectDto> getAll();
    Page<ProjectDto> getPage(Pageable pageable);
}
