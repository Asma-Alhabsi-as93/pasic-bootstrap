package com.example.demo.Services;

import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {
    @Autowired
    MarkRepository markRepository;

    public List<Mark> gettAllMarks() {
        return markRepository.getAllMarks();
    }

    public Mark getMarkById(Integer markId){
  Mark mark= markRepository.getMarkById(markId);
    return mark;
}
    public List<Mark> getByActive(){
       return markRepository.getByActive();

    }
    public List<Mark> getByInActive(){
        return markRepository.getByInActive();

    }
}