package com.ramu.showcase.dto;

public class ProjectDto {
    private Long id;
    private String title;
    private String description;
    private String techStack;
    private String repoUrl;
    private String liveUrl;

    public ProjectDto() {}

    public ProjectDto(Long id, String title, String description, String techStack, String repoUrl, String liveUrl) {
        this.id = id; this.title = title; this.description = description;
        this.techStack = techStack; this.repoUrl = repoUrl; this.liveUrl = liveUrl;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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
