package com.example.demo.Controllers;

import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Models.course;
import com.example.demo.Services.MarkService;
import com.example.demo.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
@RestController
@RequestMapping(value = "mark")

public class MarkController {
    @Autowired
    MarkService markService;
    @Autowired
    SlackClient slackClient;

    @RequestMapping(value = "mark/getAll", method = RequestMethod.GET)

    public List<Mark> getAllMark() {

        List<Mark> marks = markService.gettAllMarks();
        for (Mark s : marks) {
//            slackClient.sendMessage("Mark id:" + s.getId());
//            slackClient.sendMessage("Mark Grade:" + s.getGrade());
//            slackClient.sendMessage("Mark ObtainedMarks:" + s.getObtainedMarks());
//            slackClient.sendMessage("Mark Active:" + s.getActive());
//            slackClient.sendMessage("Mark CreatedDate:" + s.getCreatedDate());
//            slackClient.sendMessage("Mark UpdatedDate:" + s.getUpdatedDate());
        }
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


    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public Mark getLatestRow() {
        Mark mark = markService.getLatestRow();
        return mark;

    }

    @RequestMapping(value = " getLatestUpdated", method = RequestMethod.GET)
    public Mark getLatestUpdated() {
        Mark mark = markService.getLatestUpdated();
        return mark;
    }

    @RequestMapping(value = "getMarkCreatedAfterDate" ,method = RequestMethod.GET)
    public List<Mark> getMarkCreatedAfterDate(@RequestParam String createdDate ) throws ParseException {
        List<Mark> marks = markService.getMarkCreatedAfterDate(createdDate);
        return marks;

    }

}
