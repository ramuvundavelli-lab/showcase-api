package com.ramu.showcase.dto;

import jakarta.validation.constraints.NotBlank;

public class ProjectCreateDto {
    @NotBlank(message = "title is required")
    private String title;

    private String description;
    private String techStack;
    private String repoUrl;
    private String liveUrl;

    public ProjectCreateDto() {}

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getTechStack() { return techStack; }
    public void setTechStack(String techStack) { this.techStack = techStack; }
    public String getRepoUrl() { return repoUrl; }
    public void setRepoUrl(String repoUrl) { this.repoUrl = repoUrl; }
    public String getLiveUrl() { return liveUrl; }
    public void setLiveUrl(String liveUrl) { this.liveUrl = liveUrl; }
}
