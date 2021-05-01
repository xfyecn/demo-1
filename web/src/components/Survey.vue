<template>
  <div class="container merkez d-flex justify-content-md-center" @click="getAllSurvey">
        <div class="col-md-8 bg-anketColor" >
          <br>
          <div v-if="completed" >
            <h6 class="alert alert-success" role="alert" @click="newSurvey" >Anketiniz Başarıyla Alınmıstır!</h6>
          </div>

          <div class="form-group">
            <label v-if="nullError" class="alert alert-danger">
             Boş alanları doldurunuz <br></label>

            <label v-if="nicknameError" class="alert alert-danger" for="nickname">
              baska bir kulanıcı ismi seçini</label>
            <label v-else for="nickname">bir nickname giriniz</label>
            <input
                class="form-control"
                id="nickname"
                required
                v-model="survey.nickname"
                name="nickname"
            />
          </div>
          <div class="form-group">

            <label for="plaka">bir plaka giriniz</label>
            <input
                class="form-control"
                id="plaka"
                required
                v-model="survey.plaka"
                name="nickname"
            />
          </div>

          <form name="ililce" method="POST">
            <div class="form-group" >
              <label for="province">il giriniz</label>
              <select class="form-control"
                      id="province"
                      required
                      v-model="survey.province"
                      name="province"
                     @click="city">
                  <option selected="selected"></option>
                  <option value="Ankara">Ankara</option>
                  <option value="İstanbul">İstanbul</option>
                  <option value="İzmir">İzmir</option>
                  <option value="Adana">Adana</option>
                  <option value="Adıyaman">Adıyaman</option>
                  <option value="Afyon">Afyon</option>
                  <option value="Ağrı">Ağrı</option>
                  <option value="Aksaray">Aksaray</option>
                  <option value="Amasya">Amasya</option>
                  <option value="Antalya">Antalya</option>
                  <option value="Ardahan">Ardahan</option>
                  <option value="Artvin">Artvin</option>
                  <option value="Aydın">Aydın</option>
                  <option value="Balıkesir">Balıkesir</option>
                  <option value="Bartın">Bartın</option>
                  <option value="Batman">Batman</option>
                  <option value="Bayburt">Bayburt</option>
                  <option value="Bilecik">Bilecik</option>
                  <option value="Bingöl">Bingöl</option>
                  <option value="Bitlis">Bitlis</option>
                  <option value="Bolu">Bolu</option>
                  <option value="Burdur">Burdur</option>
                  <option value="Bursa">Bursa</option>
                  <option value="Çanakkale">Çanakkale</option>
                  <option value="Çankırı">Çankırı</option>
                  <option value="Çorum">Çorum</option>
                  <option value="Denizli">Denizli</option>
                  <option value="Diyarbakır">Diyarbakır</option>
                  <option value="Düzce">Düzce</option>
                  <option value="Edirne">Edirne</option>
                  <option value="Elazığ">Elazığ</option>
                  <option value="Erzincan">Erzincan</option>
                  <option value="Erzurum">Erzurum</option>
                  <option value="Eskişehir">Eskişehir</option>
                  <option value="Gaziantep">Gaziantep</option>
                  <option value="Giresun">Giresun</option>
                  <option value="Gümüşhane">Gümüşhane</option>
                  <option value="Hakkari">Hakkari</option>
                  <option value="Hatay">Hatay</option>
                  <option value="Iğdır">Iğdır</option>
                  <option value="Isparta">Isparta</option>
                  <option value="Kahramanmaraş">Kahramanmaraş</option>
                  <option value="Karabük">Karabük</option>
                  <option value="Karaman">Karaman</option>
                  <option value="Kars">Kars</option>
                  <option value="Kastamonu">Kastamonu</option>
                  <option value="Kayseri">Kayseri</option>
                  <option value="Kırıkkale">Kırıkkale</option>
                  <option value="Kırklareli">Kırklareli</option>
                  <option value="Kırşehir">Kırşehir</option>
                  <option value="Kilis">Kilis</option>
                  <option value="Kocaeli">Kocaeli</option>
                  <option value="Konya">Konya</option>
                  <option value="Kütahya">Kütahya</option>
                  <option value="Malatya">Malatya</option>
                  <option value="Manisa">Manisa</option>
                  <option value="Mardin">Mardin</option>
                  <option value="Mersin">Mersin</option>
                  <option value="Muğla">Muğla</option>
                  <option value="Muş">Muş</option>
                  <option value="Nevşehir">Nevşehir</option>
                  <option value="Niğde">Niğde</option>
                  <option value="Ordu">Ordu</option>
                  <option value="Osmaniye">Osmaniye</option>
                  <option value="Rize">Rize</option>
                  <option value="Sakarya">Sakarya</option>
                  <option value="Samsun">Samsun</option>
                  <option value="Siirt">Siirt</option>
                  <option value="Sinop">Sinop</option>
                  <option value="Sivas">Sivas</option>
                  <option value="Şanlıurfa">Şanlıurfa</option>
                  <option value="Şırnak">Şırnak</option>
                  <option value="Tekirdağ">Tekirdağ</option>
                  <option value="Tokat">Tokat</option>
                  <option value="Trabzon">Trabzon</option>
                  <option value="Tunceli">Tunceli</option>
                  <option value="Uşak">Uşak</option>
                  <option value="Van">Van</option>
                  <option value="Yalova">Yalova</option>
                  <option value="Yozgat">Yozgat</option>
                  <option value="Zonguldak">Zonguldak</option>
                </select>
            </div>

            <div class="form-group">
              <label for="county">ilce giriniz</label>
              <select  class="form-control"
                         id="county"
                         required
                         v-model="survey.county"
                         name="county">
              <option>Önce İl Seçiniz</option>
              </select>
            </div>
          </form>

          <div class="form-group">
            <label v-if="bookError" class="alert alert-danger" for="book">Hatalı girdi</label>
            <label v-else for="book">Lütfen bu ay okudugunuz kitap satısını giriniz </label>
            <input
                class="form-control"
                id="book"
                required
                v-model="survey.book"
                name="book"
            />
          </div>

          <button @click="clickButton" class="btn btn-outline-primary">Anketi Tamamla</button>
          <br><br>
        </div>
      </div>
</template>

<script>
import DataService from "../services/DataService";

export default {
  name: 'Survey',
  props: {
    msg: String
  },
  data() {
    return {
      surveys: [],
      survey: {
        id: null,
        nickname: "",
        province: "",
        county: "",
        book: null,
        plaka: "",
      },
      completed: false,
      nicknameError: false,
      bookError: false,
      nullError : false
    };
  },
  methods: {
    saveSurvey() {
      const data1 = {
        nickname: this.survey.nickname,
        province: this.survey.province,
        county: this.survey.county,
        book: this.survey.book,
        plaka: this.survey.plaka
      };

      DataService.create(data1)
          .then(response => {
            this.survey.id = response.data.id;
            console.log(response.data);
            this.completed = true;
            this.nicknameError = false;
            this.bookError = false;
            this.nullError = false;
            this.newSurvey();
          })
          .catch(e => {
            console.log(e);
          });

    },

    newSurvey() {
      this.complated= false;
      this.survey = {};
    },

    getAllSurvey() {
      DataService.getAll()
          .then(response => {
            this.surveys = response.data;
          })
          .catch(e => {
            console.log(e);
          });
    },

    clickButton(){
      this.getAllSurvey();

       var nicknameErrorCount = false;

      for(let key in this.surveys){
        let test = this.surveys[key].nickname;
        if (test == this.survey.nickname) {
          nicknameErrorCount= true;
          break;
        }
      }


      if(nicknameErrorCount) {
        this.nicknameError = true;
      } else {
        this.nicknameError = false;
      }

      if(isNaN(this.survey.book)) {
        this.bookError = true;
      } else{
        this.bookError = false;
      }

      if(this.survey.nickname == "" || this.survey.province == ""
          || this.survey.county == "" || this.survey.book == null) {
        this.nullError = true;
      } else {
        this.nullError = false;
      }


      if(!this.nicknameError && !this.bookError && !this.nullError){
        this.saveSurvey();
      }
      this.survey = {};
    },

    city(){
      var ank				= new Array("Altındağ", "Ayaş", " Bala", "Beypazarı", "Çamlıdere", "Çankaya", "Çubuk", "Etimesgut", "Haymana", "Kalecik", "Keçiören", "Kızılcahamam", "Mamak", "Nallıhan", "Polatlı", "Şereflikoçhisar", "Sincan", "Yenimahalle");
      var ist	 			= new Array("Adalar", "Bağcılar", "Bahçelievler", "Bakırköy", "Beşiktaş", "Beykoz", "Beyoğlu", "Büyükçekmece", "Çatalca", "Eminönü", "Esenler", "Eyüp", "Fatih", "Gaziosmanpaşa", "Güngören", "Kadıköy", "Kağıthane", "Kartal", "Küçükçekmece", "Maltepe", "Pendik", "Sarıyer", "Silivri", "Şile", "Şişli", "Sultanbeyli", "Tuzla", "Ümraniye", "Üsküdar", "Zeytinburnu");
      var izmr 			= new Array("Aliağa", "Balçova", "Bayındır", "Bergama", "Beydağ", "Bornova", "Buca", "Çeşme", "Dikili", "Foça", "Güzelbahçe", "Karaburun", "Karşıyaka", "Kemalpaşa", "Kınık", "Kiraz", "Konak", "Menderes","Menemen", "Narlıdere", "Ödemiş", "Seferihisar", "Selçuk", "Tire", "Torbalı", "Urla");
      var adna 			= new Array("Aladağ", "Ceyhan", "Feke", "Karaisalı", "Kozan", "Pozantı", "Saimbeyli", "Seyhan", "Yumurtalı", "Yüreğir");
      var adymn 			= new Array("Besni", "Gölbaşı", "Kahta", "Merkez");
      var afyn 			= new Array("Başmakçı", "Bolvadin", "Çay", "Çobanlar", "Dinar", "Emirdağ", "İhsaniye", "Kızılören", "Merkez", "Sandıklı", "Sincanlı", "Suhut", "Sultandağı");
      var agri 			= new Array("Diyadin", "Doğubeyazıt", "Merkez", "Patnos", "Tutak");
      var aksry 			= new Array("Eskil", "Gülağaç", "Güzelyurt", "Merkez");
      var amsya 			= new Array("Göynücek", "Gümüşhacıköy", "Merkez", "Merzifon", "Suluova", "Taşova");
      var ant 			= new Array("Akseki", "Alanya", "Elmalı", "Finike", "Gazipaşa", "İbradi", "Kale", "Kaş", "Korkuteli", "Kumluca", "Manavgat", "Merkez", "Serik");
      var ardhn 			= new Array("Çıldır", "Göle", "Merkez");
      var artvn 			= new Array("Ardanuc", "Arhavi", "Hopa", "Merkez", "Murgül", "Savsat", "Yusufeli");
      var aydn 			= new Array("Bozdoğan", "Buharkent", "Çine", "Germencik", "İncirliova", "Karacasu", "Karpuzlu", "Koçarlı", "Köşk", "Kuşadası", "Kuyucak", "Merkez", "Nazilli", "Söke", "Sultanhisar", "Yenihisar", "Yenipazar");
      var baliksr			= new Array("Ayvalık", "Balya", "Bandırma", "Bigadiç", "Burhaniye", "Dursunbey", "Edremit", "Erdek", "Gömeç", "Gönen", "Havran", "İvrindi", "Kepsut", "Manyas", "Merkez", "Savaştepe", "Sındırgı", "Susurluk");
      var brtn 			= new Array("Amasra", "Merkez", "Ulus");
      var btmn 			= new Array("Hasankeyf", "Merkez");
      var bybrt 			= new Array("Aydıntepe", "Demirözü", "Merkez");
      var bilck 			= new Array("Bozhüyük", "Gölpazarı", "Merkez", "Osmaneli", "Pazaryeri", "Söğüt");
      var bngl 			= new Array("Adaklı", "Genç", "Karlıova", "Kiğı", "Merkez", "Solhan", "Yayladere", "Yedisu");
      var btls 			= new Array("Adilcevaz", "Ahlat", "Güloymak", "Merkez", "Mutki", "Tatvan");
      var blu 			= new Array("Dörtdivan", "Gerede", "Göynük", "Mengen", "Merkez", "Mudurnu", "Yeniçağa");
      var brdr 			= new Array("Ağlasun", "Bucak", "Çavdır", "Gölhisar", "Karamanlı", "Merkez", "Tefenni", "Yeşilova");
      var brsa			= new Array("Gemlik", "Gürsu", "İnegöl", "İznik", "Karacabey", "Keleş", "Kestel", "Mudanya", "Mustafa Kemal Paşa", "Nilüfer", "Orhaneli", "Orhangazi", "Osmangazi", "Yenişehir", "Yıldırım");
      var cnk 			= new Array("Ayvacık", "Bayramiç", "Biga", "Bozcaada", "Çan", "Eceabat", "Ezine", "Gölbaşı", "Gökçeada", "Lapseki", "Merkez", "Yenice");
      var cnkri 			= new Array("Atkaracalar", "Bayramören", "Çerkeş", "Eldivan", "Ilgaz", "Kurşunlu", "Merkez", "Orta", "Şabanözü", "Yapraklı");
      var crm 			= new Array("Alaca", "Boğazkale", "Iskılıp", "Kargı", "Mecitözü", "Merkez", "Oğuzlar", "Osmancık", "Sungurlu", "Uğurludağ");
      var dnzli 			= new Array("Acıpayam", "Babadağ", "Buldan", "Çal", "Çardak", "Çivril", "Güney", "Holaz", "Kale", "Merkez", "Sarayköy", "Tavaş");
      var dyrbkr 			= new Array("Çermik", "Eğil", "Ergani", "Hani", "Hazro", "Kocaköy", "Lice", "Merkez", "Silvan");
      var dzce 			= new Array("Akçakoca", "Çilimli", "Merkez", "Yığılca");
      var edrne 			= new Array("Enes", "Havsa", "İpsala", "Keşan", "Lalapaşa", "Meriç", "Merkez", "Uzunköprü");
      var elzg 			= new Array("Ağin", "Arıcak", "Baskıl", "Karakoçan", "Keban", "Kovancılar", "Maden", "Merkez", "Palu", "Sivrice");
      var erzncn 			= new Array("Çayırlı", "Ilıç", "Kemah", "Kemaliye", "Merkez", "Refahiye", "Tercan", "Üzümlü");
      var erzrm 			= new Array("Aşkale", "Hınıs", "Horasan", "Ilıca", "İspir", "Narman", "Oltu", "Olur", "Pasinler", "Tortum");
      var eskishr			= new Array("Alpu", "Beylikova", "Çifteler", "Günyüzü", "Han", "İnönü", "Mahmudiye", "Merkez", "Mihalıçcık", "Seyitgazi", "Sivrihisar");
      var gantep			= new Array("Araban", "Islahiye", "Nizip", "Nurdağı", "Oğuzeli", "Şahinbey", "Şehitkamil", "Yavuzeli");
      var grsn			= new Array("Alucra", "Bulancak", "Dereli", "Espiye", "Eynesil", "Görele", "Keşap", "Merkez", "Şebinkarahisar", "Tirebolu");
      var ghane			= new Array("Kelkit", "Kurtun", "Merkez", "Şiran");
      var hkkri			= new Array("Çukurca", "Merkez", "Şemdilli", "Yüksekova");
      var hty				= new Array("Altınözü", "Belen", "Dörtyol", "Yüksekova", "Erzin", "İskenderun", "Kırıkhan", "Kumlu", "Merkez", "Reyhanlı", "Samandağı", "Yayladağı");
      var igdr			= new Array("Aralık", "Karakoyunlu", "Merkez", "Tuzluca");
      var isprta			= new Array("Aksu", "Atabey", "Eğirdir", "Gelendost", "Gönen", "Keçiborlu", "Merkez", "Sarkıkaraağaç", "Senirkent", "Sütçüler", "Uluborlu", "Yalvaç");
      var kmaras			= new Array("Afşın", "Andırın", "Çağlayancerit", "Elbistan", "Göksun", "Merkez", "Pazarcık");
      var krbk			= new Array("Eskipazar", "Merkez", "Safranbolu");
      var krmn			= new Array("Ayrancı", "Başyayla", "Ermenek", "Merkez");
      var krs				= new Array("Kağızman", "Merkez", "Sarıkamış");
      var kstmn			= new Array("Abana", "Arac", "Bozkurt", "Çatalzeytin", "Cide", "Daday", "Devrenkanı", "Hanönü", "İhsangazi", "İnebolu", "Küre", "Merkez", "Taşköprü", "Tosya");
      var kysr			= new Array("Akkışla", "Bünyan", "Develi", "Felahiye", "Hacılar", "İncesu", "Kocasinan", "Melekgazi", "Özvatan", "Pınarbaşı", "Talas", "Tomarza", "Yahyalı", "Yeşilhisar");
      var kls				= new Array("Elbeyli", "Merkez", "Musabeyli", "Polateli");
      var krkkale			= new Array("Karakeçili", "Keskin", "Merkez", "Sulakyurt");
      var krklreli		= new Array("Babaski", "Lüleburgaz", "Merkez", "Pehlivanköy", "Pınarhisar", "Vize");
      var krshr			= new Array("Akpınar", "Çiçekdağı", "Kaman", "Merkez", "Mucur");
      var kceli			= new Array("Derince", "Gebze", "Gölcük", "Kandıra", "Karamürsel", "Merkez");
      var knya			= new Array("Akören", "Akşehir", "Altınekin", "Beyşehir", "Bozkır", "Çeltik", "Cihanbeyli", "Çumra", "Derbent", "Doğanhisar", "Emirgazi", "Ereğli", "Hadım", "Hüyük", "Ilgın", "Kadınhanı", "Karapınar", "Karatay", "Meram", "Sarayönü", "Selçuklu", "Seydişehir", "Taşkent", "Yunak");
      var kthya			= new Array("Altıntaş", "Domaniç", "Dumlupınar", "Emet", "Gediz", "Merkez", "Pazarlar", "Simav", "Tavşanlı");
      var mltya			= new Array("Akçadağ", "Arapkır", "Arguvan", "Battalgazi", "Darende", "Doğanşehir", "Hekimhan", "Merkez", "Pötürge", "Yazıhan", "Yeşilhan");
      var mnsa			= new Array("Ahmetli", "Akhisar", "Alaşehir", "Demirci", "Gölmarmara", "Gördes", "Kırkağaç", "Kula", "Merkez", "Salihli", "Sarıhanlı", "Soma", "Turgutlu");
      var mrdn			= new Array("Derik", "Kızıltepe", "Mazıdağı", "Merkez", "Midyat", "Nusaybin", "Ömerli", "Savur");
      var mrsn			= new Array("Anamur", "Bozyazı", "Çamlıyayla", "Erdemli", "Gülnar", "Merkez", "Mut", "Silifke", "Tarsus");
      var mgla			= new Array("Bodrum", "Datça", "Fathiye", "Kavaklıdere", "Köyceğiz", "Marmaris", "Merkez", "Milas", "Ortaca", "Ula", "Yatağan");
      var ms				= new Array("Bulanık", "Korkut", "Malazgirt", "Merkez");
      var nvshr			= new Array("Avanos", "Derinkuyu", "Gülşehir", "Hacıbektaş", "Kozaklı", "Merkez", "Ürgüp");
      var ngde			= new Array("Altunhisar", "Bor", "Çamardı", "Çiftlik", "Ulukışla");
      var ord				= new Array("Akkuş", "Fatsa", "Görköy", "Kabadüz", "Merkez", "Mesudiye", "Perşembe", "Ulubey", "Ünye");
      var osmnye			= new Array("Bahçe", "Kadirli", "Merkez");
      var rze				= new Array("Ardeşen", "Çayeli", "Fındıklı", "Merkez", "Pazar", "Çamlıhemşin");
      var skrya			= new Array("Akyazı", "Geyve", "Hendek", "Karasu", "Kaynarca", "Merkez", "Sapanca", "Taraklı");
      var smsn			= new Array("Alaçam", "Bafra", "Çarşamba", "Havza", "Kavak", "Ladik", "Merkez", "Salıpazarı", "Tekkeköy", "Terme", "Vezirköprü");
      var snlrf			= new Array("Akçakale", "Birecik", "Bozova", "Halfeti", "Harran", "Hilvan", "Merkez", "Siverek", "Suruç", "Viranşehir");
      var srt				= new Array("Aydınlar", "Baykan", "Eruh", "Kurtalan", "Merkez");
      var snp				= new Array("Ayancık", "Boyabat", "Durağan", "Elfelek", "Gerze", "Merkez");
      var srnk			= new Array("Cizre", "İdil", "Merkez", "Silopi");
      var svs				= new Array("Altınyayla", "Divriği", "Doğansar", "Gemerek", "Hafik", "Kangal", "Merkez", "Şarkışla", "Suşehri", "Yılızeli", "Zara");
      var tkrdg			= new Array("Çerkezköy", "Çorlu", "Hayrabolu", "Malkara", "Marmara Ereğlisi", "Merkez", "Muratlı", "Saray", "Şarköy");
      var tkt				= new Array("Almuz", "Erbaa", "Merkez", "Niksar", "Pazar", "Reşadiye", "Sulusaray", "Turhal", "Zile");
      var trbzn			= new Array("Akçabat", "Araklı", "Arşin", "Beşikdüzü", "Çarşıbaşı", "Çaykara", "Dernekpazarı", "Maçka", "Merkez", "Of", "Sürmene", "Tonya", "Vakfıkebir", "Yomra");
      var tncli			= new Array("Çemişgezek", "Hozat", "Mazgirt", "Merkez", "Nazimiye", "Pertek");
      var usk				= new Array("Banaz", "Eşme", "Merkez", "Sivaslı", "Ulubey");
      var vn				= new Array("Başkale", "Çaldıran", "Çatak", "Erciş", "Gevaş", "Gürpınar", "Merkez", "Muradiye", "Özalp");
      var ylva			= new Array("Altınova", "Armutlu", "Merkez");
      var yzgt			= new Array("Boğazlıyan", "Çandır", "Çayıralan", "Merkez", "Sarıkaya", "Sefaatli", "Sorgun", "Yenifakili", "Yerköy");
      var zngldk			= new Array("Araplı", "Çaycuma", "Devrek", "Ereğli", "Merkez");

      var select_il = document.ililce.province;
      var select_ilce = document.ililce.county;
      var selected_il = select_il.options[select_il.selectedIndex].value;

      select_ilce.options.length=0;
      if (selected_il == "Ankara"){
        for(let i=0; i<ank.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(ank[i]);
      }
      if (selected_il == "İstanbul"){
        for(let i=0; i<ist.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(ist[i]);
      }
      if (selected_il == "İzmir"){
        for(let i=0; i<izmr.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(izmr[i]);
      }
      if (selected_il == "Adana"){
        for(let i=0; i<adna.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(adna[i]);
      }
      if (selected_il == "Adıyaman"){
        for(let i=0; i<adymn.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(adymn[i]);
      }
      if (selected_il == "Afyon"){
        for(let i=0; i<afyn.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(afyn[i]);
      }
      if (selected_il == "Ağrı"){
        for(let i=0; i<agri.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(agri[i]);
      }
      if (selected_il == "Aksaray"){
        for(let i=0; i<aksry.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(aksry[i]);
      }
      if (selected_il == "Amasya"){
        for(let i=0; i<amsya.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(amsya[i]);
      }
      if (selected_il == "Antalya"){
        for(let i=0; i<ant.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(ant[i]);
      }
      if (selected_il == "Ardahan"){
        for(let i=0; i<ardhn.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(ardhn[i]);
      }
      if (selected_il == "Artvin"){
        for(let i=0; i<artvn.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(artvn[i]);
      }
      if (selected_il == "Aydın"){
        for(let i=0; i<aydn.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(aydn[i]);
      }
      if (selected_il == "Balıkesir"){
        for(let i=0; i<baliksr.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(baliksr[i]);
      }
      if (selected_il == "Bartın"){
        for(let i=0; i<brtn.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(brtn[i]);
      }
      if (selected_il == "Batman"){
        for(let i=0; i<btmn.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(btmn[i]);
      }
      if (selected_il == "Bayburt"){
        for(let i=0; i<bybrt.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(bybrt[i]);
      }
      if (selected_il == "Bilecik"){
        for(let i=0; i<bilck.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(bilck[i]);
      }
      if (selected_il == "Bingöl"){
        for(let i=0; i<bngl.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(bngl[i]);
      }
      if (selected_il == "Bitlis"){
        for(let i=0; i<btls.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(btls[i]);
      }
      if (selected_il == "Bolu"){
        for(let i=0; i<blu.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(blu[i]);
      }
      if (selected_il == "Burdur"){
        for(let i=0; i<brdr.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(brdr[i]);
      }
      if (selected_il == "Bursa"){
        for(let i=0; i<brsa.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(brsa[i]);
      }
      if (selected_il == "Çanakkale"){
        for(let i=0; i<cnk.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(cnk[i]);
      }
      if (selected_il == "Çankırı"){
        for(let i=0; i<cnkri.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(cnkri[i]);
      }
      if (selected_il == "Çorum"){
        for(let i=0; i<crm.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(crm[i]);
      }
      if (selected_il == "Denizli"){
        for(let i=0; i<dnzli.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(dnzli[i]);
      }
      if (selected_il == "Diyarbakır"){
        for(let i=0; i<dyrbkr.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(dyrbkr[i]);
      }
      if (selected_il == "Düzce"){
        for(let i=0; i<dzce.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(dzce[i]);
      }
      if (selected_il == "Edirne"){
        for(let i=0; i<edrne.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(edrne[i]);
      }
      if (selected_il == "Elazığ"){
        for(let i=0; i<elzg.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(elzg[i]);
      }
      if (selected_il == "Erzincan"){
        for(let i=0; i<erzncn.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(erzncn[i]);
      }
      if (selected_il == "Erzurum"){
        for(let i=0; i<erzrm.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(erzrm[i]);
      }
      if (selected_il == "Eskişehir"){
        for(let i=0; i<eskishr.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(eskishr[i]);
      }
      if (selected_il == "Gaziantep"){
        for(let i=0; i<gantep.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(gantep[i]);
      }
      if (selected_il == "Giresun"){
        for(let i=0; i<grsn.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(grsn[i]);
      }
      if (selected_il == "Gümüşhane"){
        for(let i=0; i<ghane.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(ghane[i]);
      }
      if (selected_il == "Hakkari"){
        for(let i=0; i<hkkri.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(hkkri[i]);
      }
      if (selected_il == "Hatay"){
        for(let i=0; i<hty.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(hty[i]);
      }
      if (selected_il == "Iğdır"){
        for(let i=0; i<igdr.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(igdr[i]);
      }
      if (selected_il == "Isparta"){
        for(let i=0; i<isprta.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(isprta[i]);
      }
      if (selected_il == "Kahramanmaraş"){
        for(let i=0; i<kmaras.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(kmaras[i]);
      }
      if (selected_il == "Karabük"){
        for(let i=0; i<krbk.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(krbk[i]);
      }
      if (selected_il == "Karaman"){
        for(let i=0; i<krmn.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(krmn[i]);
      }
      if (selected_il == "Kars"){
        for(let i=0; i<krs.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(krs[i]);
      }
      if (selected_il == "Kastamonu"){
        for(let i=0; i<kstmn.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(kstmn[i]);
      }
      if (selected_il == "Kayseri"){
        for(let i=0; i<kysr.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(kysr[i]);
      }
      if (selected_il == "Kilis"){
        for(let i=0; i<kls.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(kls[i]);
      }
      if (selected_il == "Kırıkkale"){
        for(let i=0; i<krkkale.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(krkkale[i]);
      }
      if (selected_il == "Kırklareli"){
        for(let i=0; i<krklreli.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(krklreli[i]);
      }
      if (selected_il == "Kırşehir"){
        for(let i=0; i<krshr.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(krshr[i]);
      }
      if (selected_il == "Kocaeli"){
        for(let i=0; i<kceli.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(kceli[i]);
      }
      if (selected_il == "Konya"){
        for(let i=0; i<knya.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(knya[i]);
      }
      if (selected_il == "Kütahya"){
        for(let i=0; i<kthya.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(kthya[i]);
      }
      if (selected_il == "Malatya"){
        for(let i=0; i<mltya.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(mltya[i]);
      }
      if (selected_il == "Manisa"){
        for(let i=0; i<mnsa.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(mnsa[i]);
      }
      if (selected_il == "Mardin"){
        for(let i=0; i<mrdn.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(mrdn[i]);
      }
      if (selected_il == "Mersin"){
        for(let i=0; i<mrsn.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(mrsn[i]);
      }
      if (selected_il == "Muğla"){
        for(let i=0; i<mgla.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(mgla[i]);
      }
      if (selected_il == "Muş"){
        for(let i=0; i<ms.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(ms[i]);
      }
      if (selected_il == "Nevşehir"){
        for(let i=0; i<nvshr.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(nvshr[i]);
      }
      if (selected_il == "Niğde"){
        for(let i=0; i<ngde.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(mgla[i]);
      }
      if (selected_il == "Ordu"){
        for(let i=0; i<ord.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(ord[i]);
      }
      if (selected_il == "Osmaniye"){
        for(let i=0; i<osmnye.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(osmnye[i]);
      }
      if (selected_il == "Rize"){
        for(let i=0; i<rze.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(rze[i]);
      }
      if (selected_il == "Sakarya"){
        for(let i=0; i<skrya.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(skrya[i]);
      }
      if (selected_il == "Samsun"){
        for(let i=0; i<smsn.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(smsn[i]);
      }
      if (selected_il == "Şanlıurfa"){
        for(let i=0; i<snlrf.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(snlrf[i]);
      }
      if (selected_il == "Siirt"){
        for(let i=0; i<srt.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(srt[i]);
      }
      if (selected_il == "Sinop"){
        for(let i=0; i<snp.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(snp[i]);
      }
      if (selected_il == "Şırnak"){
        for(let i=0; i<srnk.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(srnk[i]);
      }
      if (selected_il == "Sivas"){
        for(let i=0; i<svs.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(svs[i]);
      }
      if (selected_il == "Tekirdağ"){
        for(let i=0; i<tkrdg.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(tkrdg[i]);
      }
      if (selected_il == "Tokat"){
        for(let i=0; i<tkt.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(tkt[i]);
      }
      if (selected_il == "Trabzon"){
        for(let i=0; i<trbzn.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(trbzn[i]);
      }
      if (selected_il == "Tunceli"){
        for(let i=0; i<tncli.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(tncli[i]);
      }
      if (selected_il == "Uşak"){
        for(let i=0; i<usk.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(usk[i]);
      }
      if (selected_il == "Van"){
        for(let i=0; i<vn.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(vn[i]);
      }
      if (selected_il == "Yalova"){
        for(let i=0; i<ylva.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(ylva[i]);
      }
      if (selected_il == "Yozgat"){
        for(let i=0; i<yzgt.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(yzgt[i]);
      }
      if (selected_il == "Zonguldak"){
        for(let i=0; i<zngldk.length; i++)
          select_ilce.options[select_ilce.options.length] = new Option(zngldk[i]);
      }

    }
  }
};
</script>


<style scoped>

.bg-anketColor {
  background-color: #98D8EF;
}
.bg-successColor {
  background-color: #e4eaec;
}
.merkez {
  margin-top: 3%;
}

</style>
