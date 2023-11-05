package com.example.demo.web;


import com.example.demo.dto.AutoDTO;
import com.example.demo.form.AutoForm;
import com.example.demo.service.AutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AutoController {

    private final AutoService autoService;

    @GetMapping("/all")
    public ResponseEntity<List<AutoDTO>> getAutos(){
        return ResponseEntity.ok(autoService.getAll());
    }

    @GetMapping("/auto")
    public String viewHomePage(Model model) {
        model.addAttribute("autos", autoService.getAll());
        return "auto";
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutoDTO> getAutoByID(@PathVariable long id){
        return ResponseEntity.ok(autoService.getAutoDTOById(id));
    }

    @PostMapping
    public ResponseEntity<AutoDTO> create(@RequestBody AutoForm autoForm){
        return ResponseEntity.status(HttpStatus.CREATED).body(autoService.create(autoForm));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutoDTO> update(@PathVariable long id,@RequestBody AutoForm autoForm){
        return ResponseEntity.status(HttpStatus.OK).body(autoService.create(autoForm));
    }


}
