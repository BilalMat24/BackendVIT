package com.example.pubblicazione.Webcam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebcamConfig {


    @Bean //per dire a spring di eseguire questo metodo all'avvio dell'applicazione
    CommandLineRunner configurazioneFotocamere(WebcamRepository repository){
        return args -> {
            if(!repository.existsById(2L)){
                repository.save(new Webcam(2L, "Galleria Rocchetta SS 43 direzione Trento",46.29568056176907, 11.068099141528291));
                repository.save(new Webcam(4L, "PMV CARRELLATO 836 Strada non specificata",null,null));
                repository.save(new Webcam(5L, "PMV CARRELLATO 897 Strada non specificata",null,null));
                repository.save(new Webcam(6L, "Moena nord SS 48 direzione Canazei",45.90313340291597, 10.83648255500479));
                repository.save(new Webcam(8L, "PMV CARRELLATO 834 Strada non specificata",null,null));
                repository.save(new Webcam(10L, "St. Castello innesto / Gal. Brozzin SP 232 direzione Egna",46.27654671772232, 11.431595668512708));
                repository.save(new Webcam(11L, "Castello Molina di Fiemme, innesto dep. SP 232 direzione Predazzo",46.27825213234128, 11.431575697348581));
                repository.save(new Webcam(30L, "Mollaro SS 43 direzione Cles",46.36147257918388, 11.037484697352044));
                repository.save(new Webcam(31L, "Cadino SS 12 direzione Bolzano",46.48716413207695, 11.341824839685614));
                repository.save(new Webcam(32L, "Mostizzolo SS 42 direzione Malè",46.393294870284656, 11.013172597353334));
                repository.save(new Webcam(34L, "Trento Commerciale (U8) SS 12 direzione Bolzano",46.487156745089905, 11.341824839685614));
                repository.save(new Webcam(35L, "Piedicastello SUD (U4-U5) SS 12 direzione Verona",45.40608800097724, 10.990024439641383));
                repository.save(new Webcam(37L, "Borgo Valsugana SS 47 direzione Trento",46.04622215768972, 11.452379526174894));
                repository.save(new Webcam(39L, "San Cristoforo SS 47 direzione Borgo Valsugana",46.04621471104211, 11.4523687973391));
                repository.save(new Webcam(40L, "Mezzolombardo Sud SP 235 direzione Trento",46.19687152372771, 11.091695697345253));
                repository.save(new Webcam(41L, "Mezzolombardo Nord SS 43 direzione Val di Non",46.217174595504154, 11.087088910838677));
                repository.save(new Webcam(42L, "Mattarello Sud SS 12 direzione Rovereto",46.00273987610652, 11.126309997337266));
                repository.save(new Webcam(43L, "Campiello SS 47 direzione Padova",45.45579882276301, 11.856718597314972));
                repository.save(new Webcam(44L, "Totoga SS 50 direzione Imer",46.17899619982761, 11.832435168508676));
                repository.save(new Webcam(45L, "Predazzo SS 48 direzione Predazzo",46.31466550224385, 11.598536897350066));
                repository.save(new Webcam(46L, "Trento Est (U10) SS 47 direzione Trento",46.0844849955615, 11.131255997340638));
                repository.save(new Webcam(47L, "Trento Centro (U6) SS 12 direzione Rovereto",46.081168480305664, 11.113488581358304));
                repository.save(new Webcam(48L, "Mezzolombardo Campo sportivo SS 43 direzione Val di Non",46.29564349701293, 11.068045497349319));
                repository.save(new Webcam(49L, "Ravina Cavalcavia SS 12 direzione Rovereto",45.882788877036916, 11.032404797332351));
                repository.save(new Webcam(50L, "Ravina Cavalcavia SS 12 direzione Bolzano",46.48716413207695, 11.341824839685614));
                repository.save(new Webcam(51L, "Trento Centro SS 45 bis direzione Cadine",null,null));
                repository.save(new Webcam(52L, "Località Martincelli Grigno SS 47 direzione Padova",45.4558138744443, 11.856718597314972));
                repository.save(new Webcam(53L, "Grigno Ovest SS 47 direzione Padova",45.857205966930266, 11.661518931066494));
                repository.save(new Webcam(54L, "Trento Commerciale (U7) SS 12 direzione Rovereto",45.882788877036916, 11.03239406849656));
                repository.save(new Webcam(55L, "Piedicastello SUD (U5) SS 12 direzione Bolzano",46.487156745089905, 11.341824839685614));
                repository.save(new Webcam(56L, "Cadine SS 45 bis direzione Riva",45.62405857108075, 10.572816626157596));
                repository.save(new Webcam(60L, "Stazione Castello SS 48 direzione Passo S.Lugano",46.286772162142185, 11.418753728662166));
                repository.save(new Webcam(61L, "Mori Ovest SS 240 direzione Riva del Garda",45.88976177422461, 10.845624910825313));
                repository.save(new Webcam(62L, "Mori Est SS 240 direzione Riva del Garda",45.88976924193489, 10.845646368496901));
                repository.save(new Webcam(63L, "Storo SS 237 direzione direzione Madonna di Campiglio",null,null));
                repository.save(new Webcam(64L, "Rotatoria Riva del garda direzione Riva del Garda",45.90313340291597, 10.836461097333201));
                repository.save(new Webcam(65L, "Tione- Zuclo SS 237 direzione Saone/Ponte Arche/Trento",46.034109583158894, 10.747099891786915));
                repository.save(new Webcam(66L, "Loppio SS 240 direzione Riva del Garda",45.889754306513304, 10.845635639661106));
                repository.save(new Webcam(67L, "Passo del Tonale SS 42 direzione Brescia",46.25747177110166, 10.576371126183531));
                repository.save(new Webcam(68L, "Nago SS 240 direzione Passo San Giovanni/Mori/Rovereto",45.876353082253395, 10.904766235809825));
                repository.save(new Webcam(69L, "Pergine Centro SS 47 direzione Trento",46.084571875017204, 11.131059771359713));
                repository.save(new Webcam(70L, "Uscita Lavis SP 235 direzione Bolzano",46.161616092038486, 11.079888670372279));
                repository.save(new Webcam(71L, "Marter SS 47 direzione Trento",46.032672316517704, 11.392935039666884));
                repository.save(new Webcam(72L, "Mattarello Sud SS 12 direzione Trento",46.01045103446916, 11.1289292955356));
                repository.save(new Webcam(73L, "Vason SP 85 direzione Viote",46.0214100018499, 11.041176362120376));
                repository.save(new Webcam(74L, "Candriai SP 85 direzione Trento",46.06223498307176, 11.07967658150414));
                repository.save(new Webcam(75L, "Passo Prodoi SS 48 direzione Canazei",46.486200632469576, 11.799688739685564));
                repository.save(new Webcam(76L, "Passo Sella SS 242 direzione Canazei",46.5162225541542, 11.768422097358394));
                repository.save(new Webcam(77L, "Passo San Pellegrino SS 346 direzione Moena",46.377515061803, 11.802126429889585));
                repository.save(new Webcam(78L, "Passo Lavaze SS 620 direzione Cavalese",46.294675697274926, 11.455392897349329));
                repository.save(new Webcam(79L, "Lifano SS 240 direzione Riva del Garda",45.88976177422461, 10.845635639661106));
                repository.save(new Webcam(80L, "Passo Cereda SS 347 direzione Passo Cereda",46.18905645321144, 11.887004426180722));
                repository.save(new Webcam(81L, "Passo Rolle SS 50 direzione Passo Rolle",46.17900362855583, 11.832435168508676));
                repository.save(new Webcam(82L, "Cirè-Civezzano SS 47 direzione Pergine",46.0779921795257, 11.205900510833013));
                repository.save(new Webcam(83L, "Madonna di Campiglio SS 239 direzione Passo C.C. Magno",46.2201112406206, 10.821443397346194));
                repository.save(new Webcam(84L, "Passo Mendola SS 42 direzione Bolzano",46.032384222580866, 10.351084339666922));
                repository.save(new Webcam(85L, "Cadine SS 45 bis direzione Riva del Garda",45.89447727232282, 10.849174226168639));
                repository.save(new Webcam(86L, "Passo Ballino SS 421 direzione Fiavè",45.97472976364547, 10.819833227478009));
                repository.save(new Webcam(87L, "San Martino di Castrozza SS 50 direzione Fiera di Primiero",46.262630071101874, 11.803091826183733));
                repository.save(new Webcam(88L, "PMV CARRELLATO 1014 strada non specificata",null,null));
                repository.save(new Webcam(89L, "PMV CARRELLATO 948 strada non specificata",null,null));
                repository.save(new Webcam(90L, "PMV CARRELLATO 951 strada non specificata",null,null));
                repository.save(new Webcam(91L, "PMV CARRELLATO 950 strada non specificata",null,null));
                repository.save(new Webcam(92L, "Margone SP 18 direzione Vezzano",46.068495788810225, 10.96184419284206));
                repository.save(new Webcam(93L, "Passo San Pellegrino SS 346 direzione Passo San Pellegrino",46.37750765993915, 11.802115701053792));
                repository.save(new Webcam(94L, "Passo Broccon SP 79 direzione Passo Broccon",46.124688435033924, 11.699966768506505));
                repository.save(new Webcam(95L, "Taio Nord SS 43 direzione Cles",46.36147998322104, 11.037463239680454));
                repository.save(new Webcam(96L, "Andalo SP 64 direzione Andalo",null,null));
                repository.save(new Webcam(97L, "Lagolo SP 85 direzione Lagolo",46.03538207487806, 11.022808726174363));
                repository.save(new Webcam(98L, "Pian delle Fugazze SS 46 direzione Pian delle Fugazze",45.81558402644277, 11.096441368493785));
                repository.save(new Webcam(99L, "San Valentino SP 03 direzione San Valentino",45.782491971299216, 10.90662227461767));
                repository.save(new Webcam(100L, "Passo Coe SP 143 direzione Passo Coe",45.87662974056419, 11.2154611973321));
                repository.save(new Webcam(101L, "Passo Predaia SP 13 direzione Passo Predaia",46.3268576455932, 11.140340668232273));
                repository.save(new Webcam(102L, "Sporminore SP 67 direzione Sporminore",46.237988191856104, 11.029214797346917));
                repository.save(new Webcam(103L, "Passo Gobbera SP 79 direzione Canal San Bovo",46.14777711233421, 11.757457205214545));
                repository.save(new Webcam(104L, "Sega di Ala SP 211",45.68409764361725, 10.97863615797403));
                repository.save(new Webcam(105L, "Vigo Cavedine SP 84 direzione Trento",45.977755726962535, 10.976531868500453));
                repository.save(new Webcam(106L, "Folgaria SS 350 direzione Passo Sommo",45.919550325915885, 11.206431468498062));
                repository.save(new Webcam(107L, "Bellaria SP 20 direzione Aldeno",null,null));
                repository.save(new Webcam(108L, "Casa Cantoniera SS 421 direzione Andalo",46.1675627013716, 11.004420697344042));
                repository.save(new Webcam(109L, "Pra Alpesina SP 230 direzione Pra Alpesina",45.75999450222535, 10.877928843521678));
                repository.save(new Webcam(110L, "Passo Fedaia SS 641 direzione Passo Fedaia",46.463496861312066, 11.83167502619207));
                repository.save(new Webcam(111L, "Passo CostaLunga SP 241 direzione Passo CostaLunga",45.44882366603874, 11.29618792713422));
                repository.save(new Webcam(112L, "Passo Valles SP 81 direzione Passo Valles",46.33342118180983, 11.799999958401074));
                repository.save(new Webcam(113L, "Mazzin SS 48 direzione Mazzin",46.45708643539964, 11.700929210848585));
                repository.save(new Webcam(114L, "Terme di Rabbi SP 86 direzione Terme di Rabbi",46.40791986659251, 10.807870939682388));
                repository.save(new Webcam(115L, "Marileva 1400 SP 206 direzione Marileva 1400",46.30249967127666, 10.807752817817446));
                repository.save(new Webcam(116L, "Pejo fonti SP 87 direzione Pejo Fonti",46.35475947110629, 10.664614126187562));
                repository.save(new Webcam(117L, "Rumo SP 6 direzione Rumo",46.43663397111012, 11.029100226190977));
                repository.save(new Webcam(118L, "Amola SP 127 direzione Ledro",45.88967309752644, 10.730430973539633));
                repository.save(new Webcam(119L, "Tremalzo SP 127 direzione Passo Tremalzo",45.84074164434105, 10.685809893549647));
                repository.save(new Webcam(120L, "Vigolo Vattaro SS 349 direzione Vigolo Vattaro",45.99472797109131, 11.21720909733692));
                repository.save(new Webcam(121L, "Sant'Antonio di Mavignola SS 239 direzione Madonna di Campiglio",46.19183852508787, 10.789804668509179));
                repository.save(new Webcam(122L, "Pracul SP 27 direzione Val Daone",45.97667864691198, 10.542751507849514));
                repository.save(new Webcam(123L, "Bondone SP 69 direzione Bondone",45.8129073271616, 10.546494410822136));
                repository.save(new Webcam(124L, "Passo Duron SP 222 direzione Zuclo",46.03433792763168, 10.749453809788612));
                repository.save(new Webcam(125L, "Passo Sommo SS 350 direzione Folgaria",45.91952793479709, 11.206431468498062));
                repository.save(new Webcam(126L, "Serrada SP 02 direzione Serrada",45.89046195244296, 11.153669282866032));
                repository.save(new Webcam(127L, "PMV CARRELLATO 1122 strada non specificata",null,null));
                repository.save(new Webcam(128L, "PMV CARRELLATO 1123 strada non specificata",null,null));
                repository.save(new Webcam(129L, "Passo C.C. Magno SS 239 direzione Madonna di Campiglio",46.24502761070846, 10.842906839675617));
                repository.save(new Webcam(130L, "Ortisè SP 140 direzione Ortisè",46.32677654871865, 10.784442422215914));
                repository.save(new Webcam(132L, "Compet SP 12 direzione Panarotta",46.039305833313506, 11.300004028798352));
                repository.save(new Webcam(133L, "Kamuz SP 135 direzione Frassilongo",46.0742010785202, 11.302749459766522));
            }
        };
    }
}
