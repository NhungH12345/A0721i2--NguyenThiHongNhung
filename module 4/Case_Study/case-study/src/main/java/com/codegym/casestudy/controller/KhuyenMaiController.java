package com.codegym.casestudy.controller;


import com.codegym.casestudy.model.KhuyenMai;
import com.codegym.casestudy.repository.KhuyenMaiRespository;
import com.codegym.casestudy.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class KhuyenMaiController {
    @Autowired
    private KhuyenMaiRespository khuyenMaiService;
    @Autowired
    private KhuyenMaiService khuyenmaiService;

    @GetMapping
    public ModelAndView GetHomePage() {
        return new ModelAndView("home");
    }

    @GetMapping("")
    public ModelAndView ModelAndView(@ModelAttribute("khuyenMais") @RequestParam("search") Optional<Integer> search) {
        List<KhuyenMai> khuyenMaiList;
        if (search.isPresent()) {
            khuyenMaiList = khuyenMaiService.findKhuyenMaiBySale(search.get());
        } else {
            khuyenMaiList = khuyenMaiService.findAll();
        }
        return new ModelAndView("/list", "khuyenMais", khuyenMaiList);
    }
}
//    @GetMapping("/create")
//    public ModelAndView getCreatePage() {
//        return new ModelAndView("create", "khuyenMais", new KhuyenMai());
//    }
//    @PostMapping("/create")
//    public ModelAndView saveKhuyenMai(@Valid @ModelAttribute("khuyenMais") KhuyenMai khuyenMai, BindingResult bindingResult, RedirectAttributes redirectAttributes){
//        khuyenMaiService.saveKhuyenMai(khuyenMai);
//        redirectAttributes.addFlashAttribute("message", "success");
//        return new ModelAndView("redirect:/khuyenmai");
//        if(bindingResult.hasErrors()){
//
//        }
//    }
//    @GetMapping("/delete-khuyenmai/{id}")
//    public ModelAndView showDeleteForm(@ModelAttribute("khuyenMais") KhuyenMai khuyenMai){
//        khuyenMaiService.deleteKhuyenMai(khuyenMai.getId());
//        return new ModelAndView("redirect:/khuyenmai");
//    }
//}


//}
//
//    @GetMapping("/edit-question/{id}")
//    public ModelAndView showEditForm(@PathVariable Long id, Model model) {
//        List<QuestionType> questionTypes = questionTypeService.findAll();
//        model.addAttribute("questionTypes", questionTypes);
//        Optional<Question> question = questionService.findQuestionById(id);
//        if (question != null) {
//            ModelAndView modelAndView = new ModelAndView("question/edit");
//            modelAndView.addObject("question", question);
//            return modelAndView;
//        } else {
//            ModelAndView modelAndView = new ModelAndView("error");
//            return modelAndView;
//        }
//    }
//
//    @PostMapping("/edit-question")
//    public ModelAndView updateQuestion(@ModelAttribute("question") Question question) {
//        questionService.saveQuestion(question);
//        ModelAndView modelAndView = new ModelAndView("question/edit");
//        modelAndView.addObject("question", question);
//        modelAndView.addObject("message", "Question updated successfully");
//        return new ModelAndView("redirect:/questions");
//    }
//
//    @PostMapping("/delete-question/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id ) {
////        List<QuestionType> questionTypes = questionTypeService.findAll();
////        model.addAttribute("questionTypes", questionTypes);
////        Optional<Question> question = questionService.findQuestionById(id);
////        if (question != null) {
////            ModelAndView modelAndView = new ModelAndView("question/delete");
////            modelAndView.addObject("question", question);
////            return modelAndView;
////        } else {
////            ModelAndView modelAndView = new ModelAndView("error");
////            return modelAndView;
////        }
//        questionService.deleteQuestion(id);
//        return  new ModelAndView("redirect:/questions");
//    }
//
//}
//
//
////    @PostMapping("/delete-question")
////    public ModelAndView deleteQuestion(@ModelAttribute("question") Question question, long id) {
////        questionService.deleteQuestion(id);
////        return new ModelAndView("redirect:/questions");
////    }
////}
////
//////
//////    @PostMapping("create")
//////    public String saveCustomer(@Validated @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
//////        if (bindingResult.hasFieldErrors()) {
//////            List<Customer> customerTypes = customerTypeService.findAll();
//////            model.addAttribute("customerTypes", customerTypes);
//////            //  model.addAttribute("customer", new Customer());
//////            return "create";
//////        } else {
//////            customerService.saveCustomer(customer);
//////            redirectAttributes.addFlashAttribute("message", "Create success");
//////            return "redirect:/";
//////        }
////    }
