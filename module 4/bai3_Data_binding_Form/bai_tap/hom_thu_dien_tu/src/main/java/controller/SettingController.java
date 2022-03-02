package controller;

import model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("setting/")
public class SettingController {
    @RequestMapping(value = "showForm", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("setting", new Setting());
        return "setting/create";
    }

    @RequestMapping(value = "/addSetting", method = RequestMethod.POST)
    public String submit(@ModelAttribute("setting") Setting setting, ModelMap model) {
        model.addAttribute("languages", setting.getLanguages());
        model.addAttribute("pagesize", setting.getPagesize());
        model.addAttribute("spamsfilter", setting.isSpamsfilter());
        model.addAttribute("signature", setting.getSignature());
        return "setting/index";
    }
}

