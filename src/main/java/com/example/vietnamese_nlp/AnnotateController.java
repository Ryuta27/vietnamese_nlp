package com.example.vietnamese_nlp;

import com.example.vietnamese_nlp.handlers.AnnotateHandler;
import com.example.vietnamese_nlp.models.AnnotateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.pipeline.Sentence;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AnnotateController {

    private final AnnotateHandler annotateHandler;


    @Autowired
    public AnnotateController(AnnotateHandler annotateHandler) {
        this.annotateHandler = annotateHandler;

    }

    @PostMapping("/annotate")
    public List<Sentence> annotate(@RequestBody AnnotateRequest request) throws IOException {
        return annotateHandler.handle(request.getText());
    }



}
