package com.codegym.back_end_sprint_2.controller;

import com.codegym.back_end_sprint_2.model.dto.ConcernDto;
import com.codegym.back_end_sprint_2.model.dto.MessageResponse;
import com.codegym.back_end_sprint_2.model.entities.Concern;
import com.codegym.back_end_sprint_2.service.IConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RequestMapping(value = "/api/concern")
public class ConcernController {

    @Autowired
    private IConcernService concernService;

    @GetMapping("/student-concern-list")
    public ResponseEntity<List<ConcernDto>> getListConcern() {
        List<ConcernDto> concernList = concernService.findAll();
        if (concernList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(concernList, HttpStatus.OK);
    }

    @PostMapping("/student-concern-save")
    public ResponseEntity<MessageResponse> saveConcern(@RequestBody ConcernDto concern) {
        Byte concernEnable = 1;
        ConcernDto concernDto = new ConcernDto();
        concernDto.setAttachFile(concern.getAttachFile());
        concernDto.setContent(concern.getContent());
        concernDto.setTitle(concern.getTitle());
        concernDto.setStudentCode(concern.getStudentCode());
        concernService.save(concernDto.getAttachFile(), concernDto.getContent(),
                concernDto.getTitle(),
                concernDto.getStudentCode(),concernEnable);
        return ResponseEntity.ok(new MessageResponse("Thêm mới thành công !"));
    }
}
