package com.example.demo.Services;

import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Models.course;
import com.example.demo.Repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
//    public Mark getByMarkName(String MarklName){
//        Mark mark=  markRepository.getByMarkName(MarklName);
//        return mark;
//    }

    public void deleteMarkById(Integer Id) {
        Mark markToDelete =markRepository.findById(Id).get();
        markRepository.delete(markToDelete);
    }

    public Mark getLatestRow(){
        Mark mark=  markRepository.getLatestRow();
        return mark;
    }

    public Mark getLatestUpdated(){
        Mark mark=  markRepository.getLatestUpdated();
        return mark;
    }

    public List<Mark> getMarkCreatedAfterDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        List<Mark>marks = markRepository.getMarkCreatedAfterDate(convertedDateFromStringToDateFormat);
        return marks;
    }
}