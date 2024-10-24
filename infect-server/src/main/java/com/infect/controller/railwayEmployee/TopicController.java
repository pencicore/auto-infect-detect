package com.infect.controller.railwayEmployee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController("/task")
public class TopicController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

//    public void notifyUsers(Task task) {
//        String message = "你有一个新的打分任务，请完成: " + task.getTitle();
//        // 推送消息到订阅的用户
//        messagingTemplate.convertAndSend("/topic/notifications", message);
//    }
    @GetMapping("/new")
    public String get() {
        notifyUsers("打分任务");
        return "hello";
    }
    @PostConstruct
    public void init(){
        notifyUsers("打分任务");
    }

    public void  notifyUsers(String message) {
        message = "你有一个新的打分任务，请完成: " + message;
        System.out.println(message);
        // 推送消息到订阅的用户
        messagingTemplate.convertAndSend("/topic/notifications", message);
    }
}
