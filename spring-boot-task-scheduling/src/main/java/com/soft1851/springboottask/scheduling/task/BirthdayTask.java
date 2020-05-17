package com.soft1851.springboottask.scheduling.task;

import com.soft1851.springboottask.scheduling.model.UserMail;
import com.soft1851.springboottask.scheduling.repository.UserRepository;
import com.soft1851.springboottask.scheduling.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ke
 * @ClassName BirthdayTask
 * @Description TOOD
 * @Date 2020/5/16
 * @Version 1.0
 **/
//@Slf4j
//@Component
//public  class BirthdayTask {
//    @Resource
//    private UserRepository userRepository;
//
//    @Resource
//    private MailService mailService;
//
//    @Resource
//    private TemplateEngine templateEngine;
//    /**
//     * 每天凌晨执行
//     * @throws Exception
//     */
//    @Scheduled(cron ="0 0 0 * * ?")
//    private void process() throws  Exception{
//        List<UserMail> userList = userRepository.findUsersByBirthday();
//
//        for(UserMail user : userList){
//            String to = user.getMail();
//            String subject = "一份生日祝福,请注意查收";
//            Context context = new Context();
//            context.setVariable("userName", user.getUsername());
//
//            String content = templateEngine.process("Template", context);
//
//            String imgPath ="C:\\Users\\wdf\\Pictures\\Camera Roll\\123.jpg";
//            Map<String,String> birthday = new HashMap<>();
//            birthday.put("img01",imgPath);
//            mailService.sendImgMail(to, subject, content, birthday);
//            log.info("【生日邮件】邮件发送成功");
//        }
//    }
//}
