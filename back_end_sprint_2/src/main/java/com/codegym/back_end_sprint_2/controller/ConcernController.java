package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.dto.ConcernDto;
import com.codegym.back_end_sprint_2.model.dto.MessageResponse;
import com.codegym.back_end_sprint_2.model.entities.Concern;
import com.codegym.back_end_sprint_2.service.IConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping(value = "/api/concern")
public class ConcernController {

    @Autowired
    private IConcernService concernService;

    @GetMapping("/concern-list")
    public ResponseEntity<Page<Concern>> getListConcern(Pageable pageable) {
        Page<Concern> concernList = concernService.findAll(pageable);
        if (concernList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(concernList, HttpStatus.OK);
    }

    @PostMapping("/concern-create")
    public ResponseEntity<MessageResponse> saveConcern(@RequestBody ConcernDto concern) {
        Byte concernEnable = 1;
        ConcernDto concernDto = new ConcernDto();
        concernDto.setAttachFile(concern.getAttachFile());
        concernDto.setContent(concern.getContent());
        concernDto.setTitle(concern.getTitle());
        concernDto.setNotificationId(concern.getNotificationId());
        concernDto.setStudentCode(concern.getStudentCode());
        concernDto.setTeacherCode(concern.getTeacherCode());
        concernService.save(concernDto.getAttachFile(), concernDto.getContent(),
                concernDto.getTitle(), concernDto.getNotificationId(),
                concernDto.getStudentCode(),concernDto.getTeacherCode(),concernEnable);
        return ResponseEntity.ok(new MessageResponse("Thêm mới thành công !"));
    }
}
