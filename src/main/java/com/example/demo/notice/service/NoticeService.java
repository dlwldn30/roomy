package com.example.demo.notice.service;

import com.example.demo.notice.domain.Notice;
import com.example.demo.notice.dto.NoticeRequest;
import com.example.demo.notice.dto.NoticeResponse;
import com.example.demo.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public void create(NoticeRequest request) {
        Notice notice = new Notice(
                request.getTitle(),
                request.getContent(),
                request.isPinned()
        );
        noticeRepository.save(notice);
    }

    public List<NoticeResponse> findAll() {
        return noticeRepository.findAll()
                .stream()
                .map(NoticeResponse::new)
                .toList();
    }

    public NoticeResponse findOne(Long id) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow();
        return new NoticeResponse(notice);
    }
}
