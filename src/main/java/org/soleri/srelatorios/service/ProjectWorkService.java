package org.soleri.srelatorios.service;

import org.soleri.srelatorios.dto.request.ProjectWorkRequestDTO;
import org.soleri.srelatorios.dto.response.ProjectWorkResponseDTO;
import org.soleri.srelatorios.model.ProjectWork;
import org.soleri.srelatorios.repository.ProjectWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectWorkService {

    @Autowired
    private ProjectWorkRepository projectWorkRepository;

    public ProjectWorkResponseDTO getProjectWorkById(ProjectWorkRequestDTO requestDTO) {
        ProjectWork projectWork = projectWorkRepository.findById(requestDTO.id())
                .orElseThrow(() -> new RuntimeException("ProjectWork not found"));
        return convertProjectWorkToDTO(projectWork);
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
