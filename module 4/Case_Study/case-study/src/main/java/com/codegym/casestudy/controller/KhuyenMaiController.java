package com.codegym.casestudy.controller;


import com.codegym.casestudy.model.KhuyenMai;
import com.codegym.casestudy.repository.KhuyenMaiRepository;
import com.codegym.casestudy.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class QuestionController {
    @Autowired
    private KhuyenMaiService khuyenmaiService;

    @GetMapping
    public ModelAndView GetHomePage() {
        return new ModelAndView("home");
    }

    @GetMapping("khuyenmais")
    public ModelAndView listQuestions(@PageableDefault(size = 4) Pageable pageable, @RequestParam("search") Optional<String> search) {
        Page<KhuyenMai> khuyenmais;
        if (search.isPresent()) {
            khuyenmais = khuyenmaiService.findAllByTieuDeContaining(search.get(), pageable);
        } else {
            khuyenmais = khuyenmaiService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("khuyenmais", khuyenmais);
        return modelAndView;
    }
}

//
//    @GetMapping("create")
//    public ModelAndView getCreatePage(Model model) {
//        List<QuestionType> questionTypes = questionTypeService.findAll();
//        model.addAttribute("questionTypes", questionTypes);
//        return new ModelAndView("question/create", "question1s", new Question());
//    }
//
//    @PostMapping("create")
//    public ModelAndView saveQuestion(@Valid @ModelAttribute Question question, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) { //BindingResult bindingResult kiểm tra có lỗi không
//        if (bindingResult.hasFieldErrors()) { // nếu có lỗi thì trả về trang create
//            List<QuestionType> questionTypes = questionTypeService.findAll();
//            model.addAttribute("questionTypes", questionTypes);
//            //model.addAttribute("customer", new Customer());
//            return new ModelAndView("question/create");
//        } else { // còn ko thì trả về trang chủ
//            questionService.saveQuestion(question);
//            redirectAttributes.addFlashAttribute("message", "Create question success");
//            return new ModelAndView("redirect:/questions");
//        }
//    }
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
