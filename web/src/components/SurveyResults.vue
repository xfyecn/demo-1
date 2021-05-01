<template>
  <br>
  <div class="container merkez">
    <table class="table table-hover">
      <thead class="bg-topColor" @click="getSurveyResult">
      <tr>
        <th scope="col">#</th>
        <th scope="col">Iller</th>
        <th scope="col">Katılımcı Sayısı</th>
        <th scope="col">Toplam Okunan Kitap Sayısı</th>
        <th scope="col">plaka</th>
      </tr>
      </thead>
      <tbody  v-for="survey in provinces" :key="survey" >
        <tr class="bg-surveyColor">
          <td scope="col">{{provinces.indexOf(survey)}}</td>
          <td scope="col">{{survey[0]}}</td>
          <td scope="col">{{survey[1]}}</td>
          <td scope="col">{{survey[2]}}</td>
          <td scope="col">{{survey[3]}}</td>

          <td scope="col" @click="getSurveyResultDetail(survey[0])">details</td>
        </tr>
        <tr v-for="cnty in counties" :key="cnty">
          <td scope="col" v-if="cnty[3] == survey[0]">{{counties.indexOf(cnty)}}</td>
          <td scope="col" v-if="cnty[3] == survey[0]">{{cnty[0]}}</td>
          <td scope="col" v-if="cnty[3] == survey[0]">{{cnty[1]}}</td>
          <td scope="col" v-if="cnty[3] == survey[0]">{{cnty[2]}}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import DataService from "../services/DataService";

export default {
  name: 'SurveyResults',
  props: {
    msg: String
  },
  data() {
    return {
      surveys: [],
      provinces: [],
      counties: [],
      province : {
        name : "",
        countOfSubscriber : 0,
        countOfBook: 0,
        plakalar: 0
      },
      county : {
        name : "",
        countOfSubscriber : 0,
        countOfBook: 0,
        cProvince: ""
      }
    };
  },
  methods: {
    getAllSurvey() {
      DataService.getAll()
          .then(response => {
            this.surveys = response.data;
          })
          .catch(e => {
            console.log(e);
          });
    },
    getSurveyResult(){

      this.getAllSurvey();

      this.provinces = [];

      var listSurveys = this.surveys;
      console.log(this.surveys, "zxvs",this.surveys)

      for(let key in listSurveys){

        this.province.name = listSurveys[key].province;
        this.province.countOfBook = parseInt(listSurveys[key].book);
        this.province.countOfSubscriber = 1;
        this.province.plakalar = listSurveys[key].plaka;
        console.log( "this.province.plakalar",this.province.plakalar)



        if(this.province.name == null){
          continue;
        }

        for(let key2 in listSurveys){
          if(listSurveys[key2] == listSurveys[key]){
            continue;
          }
          if(this.province.name == listSurveys[key2].province){

            this.province.countOfBook += parseInt(listSurveys[key2].book);
            this.province.countOfSubscriber += 1;

            this.province.plakalar = listSurveys[key2].plaka // onceki db verilerinde plaka bilgiis bulunmadıgından plaka degeri null verir.
                                                             //Bu yuzden; ekrana, aynı ile ait girilen son surveyin plakası yazılır.

            listSurveys[key2].province = null ;
          }
        }

        let name = this.province.name;
        let book = this.province.countOfBook;
        let sub =  this.province.countOfSubscriber;
        let plk =  this.province.plakalar;

        this.provinces.push([name,sub,book,plk]);
      }

    },

    getSurveyResultDetail(dataProvince){
      this.getAllSurvey()

      this.counties = [];

      var listSurveys = this.surveys;

      for(let key in listSurveys ){

        if(dataProvince != listSurveys[key].province){
          continue;
        }

        this.county.name = listSurveys[key].county;
        this.county.countOfBook = parseInt(listSurveys[key].book);
        this.county.countOfSubscriber = 1;
        this.county.cProvince = listSurveys[key].province ;

        if(this.county.name == null){
          continue;
        }

        for(let key2 in listSurveys){

          if(listSurveys[key2] == listSurveys[key]){
            continue;
          }

          if(this.county.name == listSurveys[key2].county){

            this.county.countOfBook += parseInt(listSurveys[key2].book);
            this.county.countOfSubscriber += 1;

            listSurveys[key2].county = null ;
          }
        }

        let name = this.county.name;
        let book = this.county.countOfBook;
        let sub =  this.county.countOfSubscriber;
        let cPov = this.county.cProvince;

        this.counties.push([name, sub, book, cPov]);
      }
    }
  }
}

</script>

<style scoped>

.bg-surveyColor {
  background-color: #e4eaec;
}
.bg-topColor {
  background-color: #98D8EF;
}
</style>

