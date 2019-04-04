package common.rabbit.controller;

import common.rabbit.dao.HellowSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:sgyt
 * @Description:
 * @Date:2019/4/4 16:41
 */
@Controller
@RequestMapping("/rabbit")
public class rabbitController {
    @Autowired
    private HellowSender hellowSender;

    @RequestMapping("/send")
    @ResponseBody
    public String send(){
        hellowSender.send();
        return "OK";
    }
}
