package com.codegym.back_end_sprint_2.service;

import com.codegym.back_end_sprint_2.model.dto.AnnouncementDto;

import java.util.List;

public interface IAnnouncementService {

    List<AnnouncementDto> findAll(Long noOfPage);

    void save(AnnouncementDto announcementDto);

    int maxLengthListReview();
}
