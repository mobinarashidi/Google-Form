package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.Form;
import com.example.demo.models.Field;
import com.example.demo.services.FormService;

import java.util.List;

@RestController
@RequestMapping("/forms")
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping
    public List<Form> getAllForms() {
        return formService.getAllForms();
    }

    @GetMapping("/{id}")
    public Form getFormById(@PathVariable String id) {
        return formService.getFormById(id);
    }

    @PostMapping
    public Form createForm(@RequestBody Form form) {
        return formService.createForm(form);
    }

    @PutMapping("/{id}")
    public Form updateForm(@PathVariable String id, @RequestBody Form form) {
        return formService.updateForm(id, form);
    }

    @DeleteMapping("/{id}")
    public void deleteForm(@PathVariable String id) {
        formService.deleteForm(id);
    }

@GetMapping("/{id}/fields")
public List<Field> getFormFields(@PathVariable String id) {
    return formService.getFormFields(id);
}

@PutMapping("/{id}/fields")
public Form updateFormFields(@PathVariable String id, @RequestBody List<Field> fields) {
    return formService.updateFormFields(id, fields);
}


    @PostMapping("/{id}/publish")
    public Form publishForm(@PathVariable String id) {
        return formService.publishForm(id);
    }

    @GetMapping("/{id}/published")
    public boolean isFormPublished(@PathVariable String id) {
        return formService.isFormPublished(id);
    }
}
