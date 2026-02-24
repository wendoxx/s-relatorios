package org.soleri.srelatorios.service;

import org.soleri.srelatorios.dto.request.ProjectWorkRequestDTO;
import org.soleri.srelatorios.dto.response.ProjectWorkResponseDTO;
import org.soleri.srelatorios.model.ProjectWork;
import org.soleri.srelatorios.repository.ProjectWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectWorkService {

    @Autowired
    private ProjectWorkRepository projectWorkRepository;

    public ProjectWorkResponseDTO createProjectWork(ProjectWorkRequestDTO requestDTO) {
        ProjectWork projectWork = new ProjectWork();
        projectWork.setName(requestDTO.name());
        projectWork.setCode(requestDTO.code());
        projectWork.setClient(requestDTO.client());
        projectWork.setDescription(requestDTO.description());
        ProjectWork savedProjectWork = projectWorkRepository.save(projectWork);
        return convertProjectWorkToDTO(savedProjectWork);
    }

    public ProjectWorkResponseDTO updateProjectWork(ProjectWorkRequestDTO requestDTO) {
        ProjectWork projectWork = projectWorkRepository.findById(requestDTO.id())
                .orElseThrow(() -> new RuntimeException("ProjectWork not found"));
        projectWork.setName(requestDTO.name());
        projectWork.setCode(requestDTO.code());
        projectWork.setClient(requestDTO.client());
        projectWork.setDescription(requestDTO.description());
        ProjectWork updatedProjectWork = projectWorkRepository.save(projectWork);
        return convertProjectWorkToDTO(updatedProjectWork);
    }

    public ProjectWorkResponseDTO getProjectWorkById(ProjectWorkRequestDTO requestDTO) {
        ProjectWork projectWork = projectWorkRepository.findById(requestDTO.id())
                .orElseThrow(() -> new RuntimeException("ProjectWork not found"));
        return convertProjectWorkToDTO(projectWork);
    }

    public List<ProjectWorkResponseDTO> getAllProjectWorks() {
        List<ProjectWork> projectWorks = projectWorkRepository.findAll();
        return projectWorks.stream()
                .map(this::convertProjectWorkToDTO)
                .toList();
    }

    public void deleteProjectWork(ProjectWorkRequestDTO requestDTO) {
        ProjectWork projectWork = projectWorkRepository.findById(requestDTO.id())
                .orElseThrow(() -> new RuntimeException("ProjectWork not found"));
        projectWorkRepository.delete(projectWork);
    }

    public ProjectWorkResponseDTO convertProjectWorkToDTO(ProjectWork projectWork) {
        return new ProjectWorkResponseDTO(
                projectWork.getId(),
                projectWork.getName(),
                projectWork.getCode(),
                projectWork.getClient(),
                projectWork.getDescription()
        );
    }
}
