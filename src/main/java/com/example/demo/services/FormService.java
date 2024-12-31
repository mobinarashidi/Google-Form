package com.example.demo.services;

import com.example.demo.models.Form;
import com.example.demo.models.Field;
import com.example.demo.repositories.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;

    public List<Form> getAllForms() {
        return formRepository.findAll();
    }

    public Form getFormById(String id) {
        return formRepository.findById(id).orElse(null);
    }

    public Form createForm(Form form) {
        return formRepository.save(form);
    }

    public Form updateForm(String id, Form form) {
        Form existingForm = formRepository.findById(id).orElse(null);
        if (existingForm != null) {
            existingForm.setTitle(form.getTitle());
            existingForm.setDescription(form.getDescription());
            existingForm.setFields(form.getFields());
            existingForm.setPublished(form.isPublished());
            return formRepository.save(existingForm);
        } else {
            return null;
        }
    }

    public void deleteForm(String id) {
        formRepository.deleteById(id);
    }

    public List<Field> getFormFields(String id) {
        Form form = formRepository.findById(id).orElse(null);
        return form != null ? form.getFields() : null;
    }

    public Form updateFormFields(String id, List<Field> fields) {
        Form form = formRepository.findById(id).orElse(null);
        if (form != null) {
            form.setFields(fields);
            return formRepository.save(form);
        } else {
            return null;
        }
    }

    public Form publishForm(String id) {
        Form form = formRepository.findById(id).orElse(null);
        if (form != null) {
            form.setPublished(true);
            return formRepository.save(form);
        } else {
            return null;
        }
    }

    public boolean isFormPublished(String id) {
        Form form = formRepository.findById(id).orElse(null);
        return form != null && form.isPublished();
    }
}
