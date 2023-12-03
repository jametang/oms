package com.zjjc.oms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: oms
 * Created by tangli on 2023/12/3 17:43
 */
@Controller
public class OrderController {

    @Autowired
    OrderServiceImpl orderServiceImpl;

    @RequestMapping("/process")
    public String showProcessPage(Model model) {
        // 在这里查询流程状态信息，并将其传递到前端
        // 示例数据，实际需要根据流程实例的状态进行查询
        model.addAttribute("processStatus", "流程进行中");

        return "process";
    }
}