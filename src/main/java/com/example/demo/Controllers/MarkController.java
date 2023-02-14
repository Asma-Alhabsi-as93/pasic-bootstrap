package com.example.demo.Controllers;

import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "mark")

public class MarkController {
    @Autowired
    MarkService markService;

    @RequestMapping(value = "mark/getAll", method = RequestMethod.GET)

    public List<Mark> getAllMark() {

        List<Mark> marks = markService.gettAllMarks();
        return marks;
    }

    @RequestMapping(value = "mark/getById", method = RequestMethod.GET)
    public Mark getMarkById(@RequestParam Integer markId) {
        Mark mark = markService.getMarkById(markId);
        return mark;
    }

    @RequestMapping(value = "getByActive")
    public List<Mark> getByInActive() {
        List<Mark> InActiveMarkList = markService.getByInActive();
        return InActiveMarkList;

    }

//    @RequestMapping(value = "getByMarkName", method = RequestMethod.GET)
//    public Mark getByMarkName(@RequestParam String MarklName) {
//        Mark mark = markService.getByMarkName(MarklName);
//        return mark;
//
//    }

    @GetMapping(value = "deleteById")
    public String deleteMarkById(@RequestParam Integer id) {

        markService.deleteMarkById(id);
        return "Record Deleted Successfully :)";
    }
}
