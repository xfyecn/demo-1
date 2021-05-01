package com.demo.controller;

import com.demo.entity.Survey;
import com.demo.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:8081") // It is for configuring allowed origins.
@RestController()
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;

    public SurveyController(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @GetMapping("api/surveyResults")
    public ResponseEntity<Object> getAllSurvey(@RequestParam(value = "id", required = false, defaultValue = "0") long id) {

        try{
            return new ResponseEntity<>(surveyRepository.findAll(), HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }

    }

    @GetMapping("api/surveyResults/{id}")
    public ResponseEntity<Object> getSurveyById(@PathVariable("id") long id) {

        try{
            return new ResponseEntity<>(surveyRepository.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("api/survey")
    public ResponseEntity<Survey> createSurvey(@RequestBody Survey survey) {

        // İlin ilk harfini db'ye büyük olacak şekilde kaydetme.

        try{
            String province = survey.getProvince();
            String ilkHarf = province.substring(0,1).toUpperCase();
            province = ilkHarf + province.substring(1,province.length());
            survey.setProvince(province);

        return new ResponseEntity<>(surveyRepository.save(survey), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping("api/surveyResults/{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable("id") long id,@RequestBody Survey detailSurvey) {

        try{
            Survey survey = surveyRepository.findById(id).get();

            survey.setNickname(detailSurvey.getNickname());
            survey.setCounty(detailSurvey.getCounty());
            survey.setProvince(detailSurvey.getProvince());
            survey.setBook(detailSurvey.getBook());


            final  Survey updateSurvey = surveyRepository.save(survey);

            return new ResponseEntity<>(updateSurvey, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("api/surveyResults/{id}")
    public ResponseEntity<HttpStatus> deleteSurvey(@PathVariable("id") long id) {

        try{
            Survey survey = surveyRepository.findById(id).get();

            surveyRepository.delete(survey);

            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}